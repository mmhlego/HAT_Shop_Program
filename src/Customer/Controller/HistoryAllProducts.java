package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import DataController.ProductChecker;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
	ArrayList<Product> SpecialProduct = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			SpecialProduct = ProductChecker.GetSpecialProducts();
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
			for (Product spProduct : SpecialProduct) {
				if (p.ID.equals(spProduct.ID)) {

					special = true;
				}
			}
			AllProductPanel.getChildren().add(root);
			i++;
		}
	}

	private void buyPage(Product product, Image image) {
		ProductInformationPage.p = product;
		ProductInformationPage c = (ProductInformationPage) MainStructure
				.addPage("src/Customer/Visual/ProductInformationPage.fxml");
		c.buyPage(product, image, special);

	}
}
