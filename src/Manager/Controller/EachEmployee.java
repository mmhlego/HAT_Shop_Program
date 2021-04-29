package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import CommonPages.Controllers.MainStructure;
import Model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class EachEmployee implements Initializable {

	@FXML
	private Label RegularLBL;

	@FXML
	private Label PremiumLBL;

	@FXML
	private Label BannedLBL;

	@FXML
	private JFXButton EmployeeInformationBTN;

	@FXML
	private Label EmployeeIDLBL;

	@FXML
	private Label EmployeeUsernameLBL;

	@FXML
	private Label EmployeeRoleLBL;

	public Label getRegularLBL() {
		return RegularLBL;
	}

	public void setRegularLBL(Label regularLBL) {
		RegularLBL = regularLBL;
	}

	public Label getPremiumLBL() {
		return PremiumLBL;
	}

	public void setPremiumLBL(Label premiumLBL) {
		PremiumLBL = premiumLBL;
	}

	public Label getBannedLBL() {
		return BannedLBL;
	}

	public void setBannedLBL(Label bannedLBL) {
		BannedLBL = bannedLBL;
	}

	public JFXButton getEmployeeInformationBTN() {
		return EmployeeInformationBTN;
	}

	public void setEmployeeInformationBTN(JFXButton employeeInformationBTN) {
		EmployeeInformationBTN = employeeInformationBTN;
	}

	public Label getEmployeeIDLBL() {
		return EmployeeIDLBL;
	}

	public void setEmployeeIDLBL(Label employeeIDLBL) {
		EmployeeIDLBL = employeeIDLBL;
	}

	public Label getEmployeeUsernameLBL() {
		return EmployeeUsernameLBL;
	}

	public void setEmployeeUsernameLBL(Label employeeUsernameLBL) {
		EmployeeUsernameLBL = employeeUsernameLBL;
	}

	public Label getEmployeeRoleLBL() {
		return EmployeeRoleLBL;
	}

	public void setEmployeeRoleLBL(Label employeeRoleLBL) {
		EmployeeRoleLBL = employeeRoleLBL;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void AddEmployee(Employee e) {
		EmployeeIDLBL.setText(e.ID);
		EmployeeRoleLBL.setText(String.valueOf(e.Mode));
		EmployeeUsernameLBL.setText(e.Username);
		EmployeeInformationBTN.setOnAction(ex -> {
			EachUserProfile profile = (EachUserProfile) MainStructure
					.addPage("src/Manager/Components/EachUserProfile.fxml");
			profile.LoadProfileData(e);
		});

	}

}
