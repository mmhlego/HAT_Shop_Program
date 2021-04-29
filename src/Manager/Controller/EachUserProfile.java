package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Customer;
import Model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class EachUserProfile implements Initializable {

	@FXML
	private ImageView BackBTN;

	@FXML
	private Label FirstNameLBL;

	@FXML
	private Label UsernameLBL;

	@FXML
	private Label EmailLBL;

	@FXML
	private Label mode;

	@FXML
	private Label ModeLBL;

	@FXML
	private Label LastNameLBL;

	@FXML
	private Label PhoneLBL;

	@FXML
	private Label IDLBL;

	@FXML
	private Group ValueGRP;

	@FXML
	private Label ValueLBL;

	@FXML
	private Group AddressGRP;

	@FXML
	private Label AddressLBL;

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
