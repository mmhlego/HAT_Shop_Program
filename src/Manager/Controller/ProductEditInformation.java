package Manager.Controller;

import java.util.HashMap;
import java.util.Map;

import com.jfoenix.controls.JFXTextArea;

import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
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
	private TableView<Map<String, Object>> ProductDetailsTable;

	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn<Map, String> InformationColumn;

	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn<Map, String> MColumn;

	@FXML
	private Button EditProductDataBTN;

	public void ShowProductInfo(Product p, Image image, boolean special) {
		ProductAmountLBL.setText(String.valueOf(p.Amount));
		ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();
		for (int j = 0; j < p.Details.length; j++) {
			Map<String, Object> item = new HashMap<>();
			item.put("firstrow", p.Details[j][0]);
			item.put("secondrow", p.Details[j][1]);
			items.add(item);
		}
		MColumn.setCellValueFactory(new MapValueFactory<String>("firstrow"));
		InformationColumn.setCellValueFactory(new MapValueFactory<String>("secondrow"));
		ProductDetailsTable.setItems(items);
		ProductIMG.setImage(image);
		ProductCategoryLBL.setText(p.Category);
		ProductDescriptionTXT.setText(p.Description);
		ProductIDLBL.setText(p.ID);
		ProductNameLBL.setText(p.Name);
		ProductPriceLBL.setText(String.valueOf(p.Price));
		/*
		 * SpecialIMG.setVisible(special); SpecialTXT.setVisible(special);
		 */

	}

}
