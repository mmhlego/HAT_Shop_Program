package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Model.Customer;
import Model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class EachUserProfile implements Initializable {

	@FXML
	private ImageView BackBTN;

	@FXML
	private TextField FirstNameLBL;

	@FXML
	private TextField UsernameLBL;

	@FXML
	private TextField EmailLBL;

	@FXML
	private Label mode;

	@FXML
	private TextField ModeLBL;

	@FXML
	private TextField LastNameLBL;

	@FXML
	private TextField PhoneLBL;

	@FXML
	private TextField IDLBL;

	@FXML
	private Group ValueGRP;

	@FXML
	private TextField ValueLBL;

	@FXML
	private Group AddressGRP;

	@FXML
	private TextField AddressLBL;

	@FXML
	private JFXButton EditUserInformationBTN;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void LoadProfileData(Customer c) {
		FirstNameLBL.setText(c.FirstName);
		LastNameLBL.setText(c.LastName);
		IDLBL.setText(c.ID);
		PhoneLBL.setText(c.Phone);
		UsernameLBL.setText(c.Username);
		EmailLBL.setText(c.Email);
		ModeLBL.setText(String.valueOf(c.Mode));
		ValueLBL.setText(String.valueOf(c.Value));
		AddressLBL.setText(c.Address);
	}

	public void LoadProfileData(Employee u) {
		FirstNameLBL.setText(u.FirstName);
		LastNameLBL.setText(u.LastName);
		IDLBL.setText(u.ID);
		PhoneLBL.setText(u.Phone);
		UsernameLBL.setText(u.Username);
		EmailLBL.setText(u.Email);
		ModeLBL.setText(String.valueOf(u.Mode));
		AddressGRP.setVisible(false);
		ValueGRP.setVisible(false);
	}

}
