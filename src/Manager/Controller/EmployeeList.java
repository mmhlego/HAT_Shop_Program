package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import Controller.UserController;
import DataController.UserGetter;
import Model.Employee;
import Model.Employee.EmployeeMode;
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
	@FXML
	private Button AddNewEmployeeBTN;
	@FXML
	private Button RefreshPageBTN;

	ArrayList<Employee> allEmployees;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AddNewEmployeeBTN.setOnMouseClicked(e -> {
			MainStructure.addPage("src/Manager/Components/AddNewEmployee.fxml");
		});

		try {
			if (UserController.Mode.equals(UserController.UserMode.Manager)) {
				allEmployees = UserGetter.GetAllEmployees();
			} else {

				if (UserController.employee.Mode.equals(EmployeeMode.QUALITYCONTROL))
					allEmployees = UserGetter.GetLowLevelEmployees();
				else {
					allEmployees = UserGetter.GetAllEmployees();
				}
			}
			ShowAllEmployees(allEmployees);
			RefreshPageBTN.setOnAction(e -> {
				try {
					if (UserController.Mode.equals(UserController.UserMode.Manager)) {
						allEmployees = UserGetter.GetAllEmployees();
					} else {

						if (UserController.employee.Mode.equals(EmployeeMode.QUALITYCONTROL))
							allEmployees = UserGetter.GetLowLevelEmployees();
						else {
							allEmployees = UserGetter.GetAllEmployees();
						}
					}
					search(SearchTXF.getText().toLowerCase());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
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
		ArrayList<Employee> searchResult = new ArrayList<>();
		for (Employee employee : allEmployees) {
			if (employee.Email.toLowerCase().contains(s) || employee.FirstName.toLowerCase().contains(s)
					|| employee.ID.toLowerCase().contains(s) || employee.LastName.toLowerCase().contains(s)
					|| String.valueOf(employee.Mode).toLowerCase().contains(s)
					|| employee.Phone.toLowerCase().contains(s) || employee.Username.toLowerCase().contains(s)) {
				searchResult.add(employee);
			}
		}
		i = 0;
		MainPanel.getChildren().clear();
		if (searchResult.size() == 0) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/NoResults.fxml"));
			MainPanel.getChildren().add(loader.load());
		} else {
			ShowAllEmployees(searchResult);
		}
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
