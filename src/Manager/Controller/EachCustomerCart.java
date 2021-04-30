package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DataController.UserGetter;
import Model.Customer;
import Model.Order;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class EachCustomerCart implements Initializable {
	@FXML
	private ImageView BackBTN;
	@FXML
	private VBox ProductsPanel;

	public void LoadCustomerCart(Customer c) throws Exception {
		Order orders = UserGetter.GetCartDB(c.ID);
		int i = 0;
		for (Product p : orders.Products) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/EachCustomerEachProduct.fxml"));
			Parent parent = loader.load();
			EachCustomerEachProduct controller = loader.getController();
			controller.LoadProduct(p, orders.Amounts.get(i));
			ProductsPanel.getChildren().add(parent);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		BackBTN.setOnMouseClicked(e -> {
			((AnchorPane) BackBTN.getParent().getParent().getParent()).getChildren()
					.remove(BackBTN.getParent().getParent());
			System.out.println(1);
		});

	}

}
