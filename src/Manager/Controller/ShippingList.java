package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DataController.UserGetter;
import Model.Shipping;
import Model.Shipping.ShippingMode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ShippingList implements Initializable {
	@FXML
	private VBox MainPanel;
	@FXML
	private TextField SearchTXF;
	@FXML
	private Button SearchBTN;
	@FXML
	private Button RefreshPageBTN;

	ArrayList<Shipping> AllShippings;

	int i = 0;

	private void search(String s) throws Exception {
		ArrayList<Shipping> searchResult = new ArrayList<>();
		for (Shipping shipping : AllShippings) {
			if (shipping.Date.toString().toLowerCase().contains(s)
					|| String.valueOf(shipping.Fee).toLowerCase().contains(s) || shipping.ID.toLowerCase().contains(s)
					|| shipping.OrderId.toLowerCase().contains(s)
					|| String.valueOf(ShippingMode.IntToMode(shipping.Status)).toLowerCase().contains(s)) {
				searchResult.add(shipping);
			}
		}
		ShowAllShipping(searchResult);
	}

	private void ShowAllShipping(ArrayList<Shipping> shippings) throws Exception {
		for (Shipping shipping : shippings) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/EachShipping.fxml"));
			Parent root = loader.load();
			EachShipping c = loader.getController();
			c.ShowShipping(shipping);
			MainPanel.getChildren().add(root);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			AllShippings = UserGetter.ConvertShippingToArrayList(UserGetter.GetShippingsDB());
			ShowAllShipping(AllShippings);
			SearchBTN.setOnAction(e -> {
				try {
					search(SearchTXF.getText().toLowerCase());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			RefreshPageBTN.setOnAction(e -> {
				try {
					AllShippings = UserGetter.ConvertShippingToArrayList(UserGetter.GetShippingsDB());
					search(SearchTXF.getText().toLowerCase());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
