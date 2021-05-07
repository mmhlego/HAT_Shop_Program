package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AddNewProduct implements Initializable {

	@FXML
	private ImageView BackBTN;

	@FXML
	private TextField ProductNameTF;

	@FXML
	private TextField ProductPriceTF;

	@FXML
	private Label mode;

	@FXML
	private TextField ProductAmountTF;

	@FXML
	private TextField ProductCategoryTF;

	@FXML
	private TextField ProductPercentageTF;

	@FXML
	private Group ValueGRP;

	@FXML
	private TextField ProductIDTF;

	@FXML
	private Group AddressGRP;

	@FXML
	private TextField ProductDescriptionTF;

	@FXML
	private JFXButton EditUserInformationBTN;

	@FXML
	private Group AddressGRP1;

	@FXML
	private TextField ProductDetailsTF;

	public void ShowAddNewProduct(Product product) {
		BackBTN.setOnMouseClicked(e -> {
			((AnchorPane) BackBTN.getParent().getParent().getParent()).getChildren()
					.remove(BackBTN.getParent().getParent());
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
