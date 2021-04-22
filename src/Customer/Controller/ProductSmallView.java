package Customer.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProductSmallView implements Initializable {
	@FXML
	private Button BuyButton;
	@FXML
	private Label SpecialEvents;
	@FXML
	private Label ProductPrice;
	@FXML
	private Label ProductName;
	@FXML
	private ImageView ProductImage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public Button getBuyButton() {
		return BuyButton;
	}

	public void setBuyButton(Button buyButton) {
		BuyButton = buyButton;
	}

	public Label getSpecialEvents() {
		return SpecialEvents;
	}

	public void setSpecialEvents(Label specialEvents) {
		SpecialEvents = specialEvents;
	}

	public Label getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(Label productPrice) {
		ProductPrice = productPrice;
	}

	public Label getProductName() {
		return ProductName;
	}

	public void setProductName(Label productName) {
		ProductName = productName;
	}

	public ImageView getProductImage() {
		return ProductImage;
	}

	public void setProductImage(ImageView productImage) {
		ProductImage = productImage;
	}

}
