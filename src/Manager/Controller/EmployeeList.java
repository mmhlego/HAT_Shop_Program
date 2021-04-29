package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class EmployeeList implements Initializable {
	@FXML
	private TextField SearchTXF;
	@FXML
	private Button SearchBTN;
	@FXML
	private VBox MainPanel;

	ArrayList<Employee> allEmployees;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println("employee list");
		try {
			/* allEmployees=UserGetter. */
			ShowAllEmployees();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// try {
		// allCustomers =
		// UserGetter.ConvertCustomersToArrayList(UserGetter.GetCustomersDB());
		// System.out.println(allCustomers.size());
		// ShowAllCustomers();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	int i = 0;

	private void ShowAllEmployees() throws Exception {
		for (Employee employee : allEmployees) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/EachEmployee.fxml"));
			Parent c = loader.load();
			EachEmployee controller = loader.getController();
			AnchorPane.setTopAnchor(c, (double) (35 + i * 115));
			AnchorPane.setLeftAnchor(c, (double) 32);
			controller.AddEmployee(employee);

			MainPanel.getChildren().add(c);
		}

	}

}
