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
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
		BackBTN.setOnMouseClicked(e -> {
			((AnchorPane) BackBTN.getParent().getParent().getParent()).getChildren()
					.remove(BackBTN.getParent().getParent());
		});
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
		EditUserInformationBTN.setOnAction(e -> {
			FirstNameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			LastNameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			Tooltip tooltip = new Tooltip("آیدی قابل تغییر نیست");
			tooltip.setFont(Font.font("B Kamran", FontWeight.BOLD, 20));
			tooltip.setAutoHide(false);
			IDLBL.setTooltip(tooltip);
			PhoneLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			UsernameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			EmailLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			ModeLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			ValueLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			AddressLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			EditUserInformationBTN
					.setText(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر") ? "ذخیره اطلاعات کاربر"
							: "تغییر اطلاعات کاربر");
			UpdateCustomerData();

		});
	}

	private void UpdateCustomerData() {
		// This Method Must Be written

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
		EditUserInformationBTN.setOnAction(e -> {
			FirstNameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			LastNameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			Tooltip tooltip = new Tooltip("آیدی قابل تغییر نیست");
			tooltip.setAutoHide(false);
			tooltip.setFont(Font.font("B Kamran", FontWeight.BOLD, 20));
			IDLBL.setTooltip(tooltip);
			PhoneLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			UsernameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			EmailLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			ModeLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			EditUserInformationBTN
					.setText(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر") ? "ذخیره اطلاعات کاربر"
							: "تغییر اطلاعات کاربر");
			UpdateEmployeeData();

		});
	}

	private void UpdateEmployeeData() {
		// This Method Must Be written

	}

}
