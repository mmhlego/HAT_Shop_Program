package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import DataController.UserGetter;
import Model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class CustomerList implements Initializable {
	@FXML
	private TextField SearchTXF;
	@FXML
	private Button SearchBTN;
	@FXML
	private VBox MainPanel;

	ArrayList<Customer> allCustomers;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			allCustomers = UserGetter.ConvertCustomersToArrayList(UserGetter.GetCustomersDB());
			System.out.println(allCustomers.size());
			ShowAllCustomers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int i = 0;

	private void ShowAllCustomers() throws Exception {
		for (Customer customer : allCustomers) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/EachCustomer.fxml"));
			Parent c = loader.load();
			EachCustomer controller = loader.getController();
			AnchorPane.setTopAnchor(c, (double) (35 + i * 115));
			AnchorPane.setLeftAnchor(c, (double) 32);
			controller.getCustomerIDLBL().setText(customer.ID);
			//controller.getCustomerNameLBL().setText(customer.FirstName + " " + customer.LastName);
			controller.getCustomerNameLBL().setText(customer.Username);
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
			controller.getCustomerInformationBTN().setOnMouseClicked(e -> {
				OpenProfile(customer);
			});
			MainPanel.getChildren().add(c);
		}
	}

	private void OpenProfile(Customer c) {
		EachUserProfile profile = (EachUserProfile) MainStructure
				.addPage("src/Manager/Components/EachUserProfile.fxml");
		profile.LoadProfileData(c);
	}
}
