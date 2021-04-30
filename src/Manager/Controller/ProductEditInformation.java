package Manager.Controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProductEditInformation {

	@FXML
	private ImageView ProductIMG;

	@FXML
	private Button EditDataBTN;

	@FXML
	private Label ProductNameLBL;

	@FXML
	private TextField ProductPriceLBL;

	@FXML
	private TextField ProductCategoryLBL;

	@FXML
	private TextField ProductIDLBL;

	@FXML
	private ImageView SpecialIMG;

	@FXML
	private Label SpecialTXT;

	@FXML
	private Group AddToCartGroup;

	@FXML
	private TextField ProductAmountLBL;

	@FXML
	private Group AddAmountGRP;

	@FXML
	private Button AddToAmountBTN;

	@FXML
	private TextField AddToAmountLBL;

	@FXML
	private JFXTextArea ProductDescriptionTXT;

	@FXML
	private TableView<?> ProductDetailsTable;

	@FXML
	private TableColumn<?, ?> InformationColumn;

	@FXML
	private TableColumn<?, ?> MColumn;

	@FXML
	private Button EditProductDataBTN;

}
