package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import CommonPages.Controllers.MainStructure;
import Controller.UserController;
import Controller.UserController.UserMode;
import DataController.ProductChecker;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProductInformationPage implements Initializable {
	@FXML
	private ImageView ProductIMG;
	@FXML
	private Button BuyBTN;
	@FXML
	private Label ProductNameLBL;
	@FXML
	private Label ProductPriceLBL;
	@FXML
	private Label ProductCategoryLBL;
	@FXML
	private Label ProductIDLBL;
	@FXML
	private ImageView SpecialIMG;
	@FXML
	private Label SpecialTXT;
	@FXML
	private Group AddToCartGroup;
	@FXML
	private Button AddToCartBTN;
	@FXML
	private Button IncreaseBTN;
	@FXML
	private Label SelectedAmountLBL;
	@FXML
	private Button DecreaseBTN;
	@FXML
	private JFXTextArea ProductDescriptionTXT;
	@FXML
	private TableView<Map<String, Object>> ProductDetailsTable;
	@FXML
	private AnchorPane SimilarProductsAnchor;
	@FXML
	private Button LoadMoreBTN;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn<Map, String> InformationColumn;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn<Map, String> MColumn;

	public static Product p;

	public TableView<Map<String, Object>> getProductDetailsTable() {
		return ProductDetailsTable;
	}

	public void setProductDetailsTable(TableView<Map<String, Object>> productDetailsTable) {
		ProductDetailsTable = productDetailsTable;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn<Map, String> getInformationColumn() {
		return InformationColumn;
	}

	public void setInformationColumn(@SuppressWarnings("rawtypes") TableColumn<Map, String> informationColumn) {
		InformationColumn = informationColumn;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn<Map, String> getMColumn() {
		return MColumn;
	}

	public void setMColumn(@SuppressWarnings("rawtypes") TableColumn<Map, String> mColumn) {
		MColumn = mColumn;
	}

	public ImageView getProductIMG() {
		return ProductIMG;
	}

	public void setProductIMG(ImageView productIMG) {
		ProductIMG = productIMG;
	}

	public Button getBuyBTN() {
		return BuyBTN;
	}

	public void setBuyBTN(Button buyBTN) {
		BuyBTN = buyBTN;
	}

	public Label getProductNameLBL() {
		return ProductNameLBL;
	}

	public void setProductNameLBL(Label productNameLBL) {
		ProductNameLBL = productNameLBL;
	}

	public Label getProductPriceLBL() {
		return ProductPriceLBL;
	}

	public void setProductPriceLBL(Label productPriceLBL) {
		ProductPriceLBL = productPriceLBL;
	}

	public Label getProductCategoryLBL() {
		return ProductCategoryLBL;
	}

	public void setProductCategoryLBL(Label productCategoryLBL) {
		ProductCategoryLBL = productCategoryLBL;
	}

	public Label getProductIDLBL() {
		return ProductIDLBL;
	}

	public void setProductIDLBL(Label productIDLBL) {
		ProductIDLBL = productIDLBL;
	}

	public ImageView getSpecialIMG() {
		return SpecialIMG;
	}

	public void setSpecialIMG(ImageView specialIMG) {
		SpecialIMG = specialIMG;
	}

	public Label getSpecialTXT() {
		return SpecialTXT;
	}

	public void setSpecialTXT(Label specialTXT) {
		SpecialTXT = specialTXT;
	}

	public Group getAddToCartGroup() {
		return AddToCartGroup;
	}

	public void setAddToCartGroup(Group addToCartGroup) {
		AddToCartGroup = addToCartGroup;
	}

	public Button getAddToCartBTN() {
		return AddToCartBTN;
	}

	public void setAddToCartBTN(Button addToCartBTN) {
		AddToCartBTN = addToCartBTN;
	}

	public Button getIncreaseBTN() {
		return IncreaseBTN;
	}

	public void setIncreaseBTN(Button increaseBTN) {
		IncreaseBTN = increaseBTN;
	}

	public Label getSelectedAmountLBL() {
		return SelectedAmountLBL;
	}

	public void setSelectedAmountLBL(Label selectedAmountLBL) {
		SelectedAmountLBL = selectedAmountLBL;
	}

	public Button getDecreaseBTN() {
		return DecreaseBTN;
	}

	public void setDecreaseBTN(Button decreaseBTN) {
		DecreaseBTN = decreaseBTN;
	}

	public JFXTextArea getProductDescriptionTXT() {
		return ProductDescriptionTXT;
	}

	public void setProductDescriptionTXT(JFXTextArea productDescriptionTXT) {
		ProductDescriptionTXT = productDescriptionTXT;
	}

	public AnchorPane getSimilarProductsAnchor() {
		return SimilarProductsAnchor;
	}

	public void setSimilarProductsAnchor(AnchorPane similarProductsAnchor) {
		SimilarProductsAnchor = similarProductsAnchor;
	}

	public Button getLoadMoreBTN() {
		return LoadMoreBTN;
	}

	public void setLoadMoreBTN(Button loadMoreBTN) {
		LoadMoreBTN = loadMoreBTN;
	}

	int AmountInsideCart = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount, DecreaseBTN, IncreaseBTN);
		if (p.Amount == 0) {
			SelectedAmountLBL.setText("0");
		}
		if (UserController.Mode.equals(UserMode.Customer)) {

			int index = UserController.Cart.contains(p.ID);
			if (index != -1) {
				AmountInsideCart = UserController.Cart.Amounts.get(index);
			}
		}

		// UserController.Cart.addProduct(p, amount);
		IncreaseBTN.setOnAction(e -> {
			SelectedAmountLBL.setText(String.valueOf(Integer.parseInt(SelectedAmountLBL.getText()) + 1));
			checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount - AmountInsideCart, DecreaseBTN,
					IncreaseBTN);
		});

		DecreaseBTN.setOnAction(e -> {
			SelectedAmountLBL.setText(String.valueOf(Integer.parseInt(SelectedAmountLBL.getText()) - 1));
			checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount - AmountInsideCart, DecreaseBTN,
					IncreaseBTN);
		});

		AddToCartBTN.setOnAction(e -> {
			UserController.Cart.addProduct(p, Integer.parseInt(SelectedAmountLBL.getText()));
			UserController.UpdateCart();
		});
	}

	private void checkAmount(int amount, int max, Button dButton, Button iButton) {
		if (amount > 1) {
			dButton.setDisable(false);
		} else {
			dButton.setDisable(true);
		}
		if (amount < max) {
			iButton.setDisable(false);
		} else {
			iButton.setDisable(true);
		}
	}

	public void buyPage(Product p, Image image, boolean special) {

		if (p.Amount == 0) {
			getBuyBTN().setDisable(true);
		}

		getBuyBTN().setOnAction(e -> {
			getBuyBTN().setVisible(false);
			getAddToCartGroup().setVisible(true);
		});

		getProductCategoryLBL().setText(p.Category);
		getProductDescriptionTXT().setText(p.Description);
		getProductIDLBL().setText(p.ID);
		getProductIMG().setImage(image);
		getProductNameLBL().setText(p.Name);
		getProductPriceLBL().setText(String.valueOf(p.Price));

		ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();
		for (int j = 0; j < p.Details.length; j++) {
			Map<String, Object> item = new HashMap<>();
			item.put("firstrow", p.Details[j][0]);
			item.put("secondrow", p.Details[j][1]);
			items.add(item);
		}
		getMColumn().setCellValueFactory(new MapValueFactory<String>("firstrow"));
		getInformationColumn().setCellValueFactory(new MapValueFactory<String>("secondrow"));
		getProductDetailsTable().setItems(items);
		getSpecialTXT().setVisible(false);
		showSpecialProduct(getSimilarProductsAnchor());

		if (special) {
			getSpecialTXT().setVisible(true);
			getSpecialIMG().setVisible(true);
		} else {
			getSpecialTXT().setVisible(false);
			getSpecialIMG().setVisible(false);
		}

		getLoadMoreBTN().toFront();
		getLoadMoreBTN().setOnAction(e -> {
			ProductsViewer controller = (ProductsViewer) MainStructure
					.addPage("src/Customer/Visual/ProductsViewer.fxml");
			controller.getOnlyAmazingToggle().selectedProperty().setValue(true);
			controller.filter();
		});
	}

	Random random = new Random(System.currentTimeMillis());

	private void showSpecialProduct(AnchorPane pane) {
		ArrayList<Product> specialProduct = new ArrayList<Product>();
		ArrayList<Product> AllSpecialProducts = ProductChecker.GetSpecialProducts();

		for (int i = 0; i < 5; i++) {
			int index = random.nextInt(AllSpecialProducts.size());
			while (specialProduct.contains(AllSpecialProducts.get(index))) {
				index = random.nextInt(AllSpecialProducts.size());
			}
			specialProduct.add(AllSpecialProducts.get(index));
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
					p.setOnMouseClicked(e -> buyPage(product, image, true));
					ProductSmallView smallView = loader.getController();
					smallView.getBuyButton().setOnAction(e -> buyPage(product, image, true));
					pane.getChildren().add(p);

				}
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
