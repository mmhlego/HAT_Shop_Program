package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.UserController;
import DataController.UserGetter;
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
			if (UserController.Mode.equals(UserController.UserMode.Manager)) {
				allEmployees = UserGetter.GetAllEmployees();
			} else {
				allEmployees = UserGetter.GetLowLevelEmployees();
			}
			ShowAllEmployees(allEmployees);
			SearchBTN.setOnAction(e -> {
				try {
					search(SearchTXF.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void search(String s) throws Exception {
		ArrayList<Employee> searchResult = new ArrayList<>();
		for (Employee employee : allEmployees) {
			if (employee.Email.contains(s) || employee.FirstName.contains(s) || employee.ID.contains(s)
					|| employee.LastName.contains(s) || String.valueOf(employee.Mode).contains(s)
					|| employee.Phone.contains(s) || employee.Username.contains(s)) {
				searchResult.add(employee);
			}
		}
		i = 0;
		MainPanel.getChildren().clear();
		ShowAllEmployees(searchResult);
	}

	int i = 0;

	private void ShowAllEmployees(ArrayList<Employee> e) throws Exception {
		for (Employee employee : e) {
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
