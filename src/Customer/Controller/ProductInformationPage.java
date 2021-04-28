package Customer.Controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import Controller.UserController;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	@FXML
	private TableColumn<Map, String> InformationColumn;
	@FXML
	private TableColumn<Map, String> MColumn;

	public static Product p;

	public TableView<Map<String, Object>> getProductDetailsTable() {
		return ProductDetailsTable;
	}

	public void setProductDetailsTable(TableView<Map<String, Object>> productDetailsTable) {
		ProductDetailsTable = productDetailsTable;
	}

	public TableColumn<Map, String> getInformationColumn() {
		return InformationColumn;
	}

	public void setInformationColumn(TableColumn<Map, String> informationColumn) {
		InformationColumn = informationColumn;
	}

	public TableColumn<Map, String> getMColumn() {
		return MColumn;
	}

	public void setMColumn(TableColumn<Map, String> mColumn) {
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount, DecreaseBTN, IncreaseBTN);
		if (p.Amount == 0) {
			SelectedAmountLBL.setText("0");
		}
		// UserController.Cart.addProduct(p, amount);
		IncreaseBTN.setOnAction(e -> {
			SelectedAmountLBL.setText(String.valueOf(Integer.parseInt(SelectedAmountLBL.getText()) + 1));
			checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount, DecreaseBTN, IncreaseBTN);
		});

		DecreaseBTN.setOnAction(e -> {
			SelectedAmountLBL.setText(String.valueOf(Integer.parseInt(SelectedAmountLBL.getText()) - 1));
			checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount, DecreaseBTN, IncreaseBTN);
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
}
