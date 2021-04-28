package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import DataController.ProductChecker;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HistoryAllProducts implements Initializable {
	@FXML
	private ImageView BackBTN;
	@FXML
	private VBox AllProductPanel;
	private boolean special = false;

	public ImageView getBackBTN() {
		return BackBTN;
	}

	public void setBackBTN(ImageView backBTN) {
		BackBTN = backBTN;
	}

	public VBox getAllProductPanel() {
		return AllProductPanel;
	}

	public void setAllProductPanel(VBox allProductPanel) {
		AllProductPanel = allProductPanel;
	}

	public static ArrayList<Product> OrdersProduct;
	public static ArrayList<Integer> OrderAmounts;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			AddOrdersProducts();
			BackBTN.setOnMouseClicked(e -> {
				((AnchorPane) AllProductPanel.getParent().getParent().getParent().getParent().getParent().getParent())
						.getChildren()
						.remove((AllProductPanel.getParent().getParent().getParent().getParent().getParent()));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int i = 0;

	private void AddOrdersProducts() throws Exception {
		for (Product p : OrdersProduct) {
			int amount = OrderAmounts.get(i);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/HistoryEachProduct.fxml"));
			Parent root = loader.load();
			HistoryEachProduct controller = loader.getController();
			controller.getAmountLBL().setText(String.valueOf(amount));
			controller.getBasePriceLBL().setText(String.valueOf(p.Price));
			controller.getPercentageLBL().setText(String.valueOf(p.Percentage) + " %");
			controller.getProductCategoryLBL().setText(p.Category);
			controller.getProductIDLBL().setText(p.ID);
			Image image;
			if (new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg").exists()) {
				image = new Image(new FileInputStream(
						new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg")));
			} else {
				image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
			}
			controller.getProductIMG().setImage(image);
			controller.getProductNameLBL().setText(p.Name);
			controller.getTotalPriceLBL().setText(String.valueOf(Product.getTotalValue(p, amount)));
			controller.getSeeProductBTN().setOnAction(e -> {
				buyPage(p, image);
			});
			AllProductPanel.getChildren().add(root);
			i++;
		}
	}

	public void buyPage(Product p, Image image) {
		ProductInformationPage.p = p;
		ProductInformationPage c = (ProductInformationPage) MainStructure
				.addPage("src/Customer/Visual/ProductInformationPage.fxml");
		c.getBuyBTN().setOnAction(e -> {
			c.getBuyBTN().setVisible(false);
			c.getAddToCartGroup().setVisible(true);
		});
		c.getProductCategoryLBL().setText(p.Category);
		c.getProductDescriptionTXT().setText(p.Description);
		c.getProductIDLBL().setText(p.ID);
		c.getProductIMG().setImage(image);
		c.getProductNameLBL().setText(p.Name);
		c.getProductPriceLBL().setText(String.valueOf(p.Price));
		ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();
		for (int j = 0; j < p.Details.length; j++) {
			Map<String, Object> item = new HashMap<>();
			item.put("firstrow", p.Details[j][0]);
			item.put("secondrow", p.Details[j][1]);
			items.add(item);
		}
		c.getMColumn().setCellValueFactory(new MapValueFactory<String>("firstrow"));
		c.getInformationColumn().setCellValueFactory(new MapValueFactory<String>("secondrow"));
		c.getProductDetailsTable().setItems(items);
		c.getSpecialTXT().setVisible(false);
		showSpecialProduct(c.getSimilarProductsAnchor());
		if (special) {
			c.getSpecialTXT().setVisible(true);
		}
		c.getLoadMoreBTN().toFront();
		c.getLoadMoreBTN().setOnAction(e -> {
			ProductsViewer controller = (ProductsViewer) MainStructure
					.addPage("src/Customer/Visual/ProductsViewer.fxml");
			controller.getOnlyAmazingToggle().selectedProperty().setValue(true);
			controller.filter();
		});
	}

	Random random = new Random();

	private void showSpecialProduct(AnchorPane pane) {
		ArrayList<Product> specialProduct = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			specialProduct.add(ProductChecker.GetSpecialProducts()
					.get(random.nextInt(ProductChecker.GetSpecialProducts().size())));
		}
		int i = 0;
		for (Product product : specialProduct) {
			try {
				if (!product.equals(new Product())) {

					FXMLLoader loader = new FXMLLoader(
							this.getClass().getResource("../Components/ProductSmallView.fxml"));

					Parent p = loader.load();
					ProductSmallView s = loader.getController();
					AnchorPane.setTopAnchor(p, ((double) 25));
					AnchorPane.setLeftAnchor(p, ((double) (i) * 225 + 25 - 120));

					Image image;
					if (new File("src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")
							.exists()) {
						image = new Image(new FileInputStream(new File(
								"src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")));
					} else {
						image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
					}

					s.getProductImage().setImage(image);
					s.getProductName().setText(product.Name);
					s.getProductPrice().setText(String.valueOf(product.Price));
					s.getSpecialEvents().setText("کالای شگفت انگیز");
					s.getSpecialEvents().setVisible(true);
					p.setOnMouseClicked(e -> buyPage(product, image));
					ProductSmallView smallView = loader.getController();
					smallView.getBuyButton().setOnAction(e -> buyPage(product, image));
					pane.getChildren().add(p);

				}
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
