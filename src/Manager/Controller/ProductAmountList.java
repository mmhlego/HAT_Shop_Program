package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DataController.ProductChecker;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProductAmountList implements Initializable {
	@FXML
	private TextField SearchTXF;
	@FXML
	private Button SearchBTN;
	@FXML
	private VBox MainPanel;
	@FXML
	private Button AddNewProductBTN;
	@FXML
	private Button RefreshPageBTN;

	ArrayList<Product> products = new ArrayList<>();
	int i = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			products = ProductChecker.LoadAllProducts();
			ShowAllProducts(products);
			SearchBTN.setOnAction(e -> {
				try {
					search(SearchTXF.getText().toLowerCase());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			RefreshPageBTN.setOnAction(e -> {
				try {
					search(SearchTXF.getText().toLowerCase());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void search(String s) throws Exception {
		ArrayList<Product> searchResult = new ArrayList<>();
		for (Product product : products) {
			if (String.valueOf(product.Amount).toLowerCase().contains(s) || product.Name.toLowerCase().contains(s)) {
				searchResult.add(product);
			}
		}
		ShowAllProducts(searchResult);
	}

	private void ShowAllProducts(ArrayList<Product> products) throws Exception {
		for (Product product : products) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/EachProductAmount.fxml"));
			Parent root = loader.load();
			EachProductAmount c = loader.getController();
			c.ShowProductAmount(product);
			MainPanel.getChildren().add(root);
		}

	}

}
