package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class SearchSortable implements Initializable {
	@FXML
	private AnchorPane MainPanel;
	ArrayList<Customer> allCustomers;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ShowAllCustomers();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	int i = 0;

	private void ShowAllCustomers() throws Exception {
		for (Customer customer : allCustomers) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Visual/Components/EachCustomer.fxml"));
			Parent c = loader.load();
			EachCustomer controller = loader.getController();
			AnchorPane.setTopAnchor(c, (double) (35 + i * 115));
			AnchorPane.setLeftAnchor(c, (double) 32);
			controller.getCustomerIDLBL().setText(customer.ID);
			controller.getCustomerNameLBL().setText(customer.FirstName + " " + customer.LastName);
			switch (customer.Mode) {
			case PREMIUM:
				controller.getPremiumLBL().setVisible(true);
				break;
			case PREMIUMBANNED:
				controller.getBannedLBL().setVisible(true);
				break;
			case REGULAR:
				controller.getRegularLBL().setVisible(true);
				break;
			case REGULARBANNED:
				controller.getBannedLBL().setVisible(true);
				break;
			}

		}

	}

}
