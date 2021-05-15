package Manager.Controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Controller.UserController;
import Controller.UserController.UserMode;
import DataController.DBConnector;
import DataController.UserUpdator;
import Model.Customer;
import Model.Customer.CustomerMode;
import Model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	@FXML
	private JFXButton BanUserBTN;
	@FXML
	private JFXButton UnbanUserBTN;
	@FXML
	private JFXButton FireEmployeeBTN;

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
		Tooltip tooltip = new Tooltip(CustomerMode.REGULAR + " ," + CustomerMode.PREMIUM + " ,"
				+ CustomerMode.REGULARBANNED + " ," + CustomerMode.PREMIUMBANNED);
		tooltip.setAutoHide(false);
		ModeLBL.setText(String.valueOf(c.Mode));
		ModeLBL.setTooltip(tooltip);
		ValueLBL.setText(String.valueOf(c.Value));
		AddressLBL.setText(c.Address);

		if (CustomerMode.ModeToInt(c.Mode) <= 1) {
			BanUserBTN.setVisible(true);
			BanUserBTN.setOnMouseClicked(e -> {
				UserUpdator.ChangeStatus(IDLBL.getText(), 2);
				Alert(AlertType.INFORMATION, "موفق", "کاربر مورد نظر مسدود شد");
			});
		} else {
			UnbanUserBTN.setVisible(true);
			UnbanUserBTN.setOnMouseClicked(e -> {
				UserUpdator.ChangeStatus(IDLBL.getText(), -2);
				Alert(AlertType.INFORMATION, "موفق", "کاربر مورد نظر رفع مسدودیت شد");
			});
		}

		EditUserInformationBTN.setOnAction(e -> {
			FirstNameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			LastNameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			Tooltip t = new Tooltip("آیدی قابل تغییر نیست");
			t.setFont(Font.font("B Kamran", FontWeight.BOLD, 20));
			t.setAutoHide(false);
			IDLBL.setTooltip(t);
			PhoneLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			UsernameLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			EmailLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			ModeLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			ValueLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			AddressLBL.setEditable(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر"));
			if (EditUserInformationBTN.getText().equals("ذخیره اطلاعات کاربر")) {
				UpdateCustomerData();
			}
			EditUserInformationBTN
					.setText(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر") ? "ذخیره اطلاعات کاربر"
							: "تغییر اطلاعات کاربر");
		});
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

		FireEmployeeBTN.setVisible(true);
		FireEmployeeBTN.setOnMouseClicked(e -> {
			UserUpdator.FireEmployee(IDLBL.getText());
			Alert(AlertType.INFORMATION, "موفق", "کارمند مورد نظر با موفقیت حدف شد");
		});
		if (UserController.Mode.equals(UserMode.Employee)) {
			FireEmployeeBTN.setDisable(true);
		}

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
			if (EditUserInformationBTN.getText().equals("ذخیره اطلاعات کاربر")) {
				UpdateEmployeeData();
			}
			EditUserInformationBTN
					.setText(EditUserInformationBTN.getText().equals("تغییر اطلاعات کاربر") ? "ذخیره اطلاعات کاربر"
							: "تغییر اطلاعات کاربر");
		});
	}

	private void UpdateCustomerData() {
		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement("UPDATE Customers SET FirstName=" + "\'"
					+ FirstNameLBL.getText() + "\' , LastName=" + "\'" + LastNameLBL.getText() + "\' , Username=" + "\'"
					+ UsernameLBL.getText() + "\' , Phone=" + "\'" + PhoneLBL.getText() + "\' , Email=" + "\'"
					+ EmailLBL.getText() + "\' , Address=" + "\'" + AddressLBL.getText() + "\' , Value="
					+ Long.parseLong(ValueLBL.getText()) + " WHERE ID=" + "\'" + IDLBL.getText() + "\'");
			ps.executeUpdate();
			Alert(AlertType.INFORMATION, "موفق", "اطلاعات کاربر با موفقیت به روزرسانی شد !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void UpdateEmployeeData() {
		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement("UPDATE Employees SET FirstName=" + "\'"
					+ FirstNameLBL.getText() + "\' , LastName=" + "\'" + LastNameLBL.getText() + "\' , Username=" + "\'"
					+ UsernameLBL.getText() + "\' , Phone=" + "\'" + PhoneLBL.getText() + "\' , Email=" + "\'"
					+ EmailLBL.getText() + "\'" + " WHERE ID=" + "\'" + IDLBL.getText() + "\'");
			ps.executeUpdate();
			Alert(AlertType.INFORMATION, "موفق", "اطلاعات کاربر با موفقیت به روزرسانی شد !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void Alert(AlertType AlertType, String Title, String Content) {
		Alert alert = new Alert(AlertType);
		alert.setTitle(Title);
		alert.setHeaderText(null);
		alert.setContentText(Content);
		alert.show();
	}

}
