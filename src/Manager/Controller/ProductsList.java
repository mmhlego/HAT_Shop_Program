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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			int i = 0;
			MainPanel.getChildren().clear();
			products = ProductChecker.LoadAllProducts();
			for (Product p : products) {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Components/EachProduct.fxml"));
				Parent parent = loader.load();
				EachProduct controller = loader.getController();
				System.out.println(i++);
				controller.AddProduct(p);
				AddNewProductBTN.setOnAction(e -> {
					AddNewProduct add = (AddNewProduct) MainStructure
							.addPage("src/Manager/Components/AddNewProduct.fxml");
				});

				MainPanel.getChildren().add(parent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
