package Manager.Controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProductsList implements Initializable {
	@FXML
	private TextField SearchTXF;
	@FXML
	private Button SearchBTN;
	@FXML
	private VBox MainPanel;
	@FXML
	private Button AddNewProductBTN;
	ArrayList<Product> products = new ArrayList<>();
	int i = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {

			MainPanel.getChildren().clear();
			products = ProductChecker.LoadAllProducts();
			show(products);
			SearchBTN.setOnAction(e -> {
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
			if (String.valueOf(product.Amount).toLowerCase().contains(s) || product.Category.toLowerCase().contains(s)
					|| product.Description.toLowerCase().contains(s) || product.ID.toLowerCase().contains(s)
					|| product.Name.toLowerCase().contains(s)
					|| String.valueOf(product.Percentage).toLowerCase().contains(s)
					|| String.valueOf(product.Price).toLowerCase().contains(s)) {
				searchResult.add(product);
			} else {
				for (int i = 0; i < product.Details.length; i++) {
					for (int j = 0; j < product.Details[i].length; j++) {
						if (product.Details[i][j].contains(s)) {
							searchResult.add(product);
						}
					}
				}
			}
		}
		MainPanel.getChildren().clear();
		i = 0;
		if (searchResult.size() == 0) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/NoResults.fxml"));
			MainPanel.getChildren().add(loader.load());
		} else {
			show(searchResult);
		}

	}

	private void show(ArrayList<Product> pr) throws Exception {
		for (Product p : pr) {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Components/EachProduct.fxml"));
			Parent parent = loader.load();
			EachProduct controller = loader.getController();
			System.out.println(i);
			i++;
			controller.AddProduct(p);
			AddNewProductBTN.setOnAction(e -> {

				MainStructure.addPage("src/Manager/Components/AddNewProduct.fxml");
			});

			MainPanel.getChildren().add(parent);
		}

	}

}
