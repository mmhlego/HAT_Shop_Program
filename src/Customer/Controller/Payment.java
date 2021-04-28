package Customer.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Controller.UserController;
import DataController.SMSSender;
import DataController.UserUpdator;
import Model.Captcha;
import Model.Limitter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Payment implements Initializable {

	@FXML
	private TextField CardNumberTF;
	@FXML
	private AnchorPane CaptchaPanel;
	@FXML
	private TextField CVV2TF;
	@FXML
	private TextField YearTF;
	@FXML
	private TextField MonthTF;
	@FXML
	private TextField PhoneTF;
	@FXML
	private JFXButton RequestOTP;
	@FXML
	private TextField OTPTF;
	@FXML
	private JFXButton ChangeCaptcha;
	@FXML
	private TextField CaptchaTF;
	@FXML
	private JFXButton CancelBTN;
	@FXML
	private JFXButton ProceedBTN;
	@FXML
	private Label TransactionIDLBL;
	@FXML
	private Label AmountLBL;

	public String FinishedAlertText = "حساب با موفقیت شارژ شد";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Captcha captcha = new Captcha(300, 40, 7);
		CaptchaPanel.getChildren().add(captcha);
		LimitTextFieldPassToNext();
		RequestOTP.setOnAction((e) -> {
			SMSSender.SendOTP(UserController.customer.Phone);
		});
		ProceedBTN.setOnAction((e) -> {
			if (!IsAllFieldsComplete()) {
				Alert(AlertType.ERROR, "بعضی از فیلد ها کامل نیستند !");
			} else if (!SMSSender.getOTP().equals(OTPTF.getText())) {
				Alert(AlertType.ERROR, "رمز یک بار مصرف درست نیست !");
			} else if (!captcha.getCaptchaResult().equals(CaptchaTF.getText())) {
				Alert(AlertType.ERROR, "حروف تصویر نادرست است !");
			} else {
				UserUpdator.UpdateValue(UserController.customer.Username, GetAmount());
				Alert(AlertType.INFORMATION, FinishedAlertText);
			}
		});
	}

	private long GetAmount() {
		return Long.parseLong(AmountLBL.getText().split(" ")[0]);
	}

	private void LimitTextFieldPassToNext() {
		Limitter.Limit(CardNumberTF, 16, true);
		Limitter.Limit(OTPTF, 6, true);
		Limitter.Limit(CVV2TF, 5, true);
		Limitter.Limit(MonthTF, 2, true);
		Limitter.Limit(YearTF, 2, true);
	}

	private boolean IsAllFieldsComplete() {
		if (CardNumberTF.getText().length() == 16 && OTPTF.getText().length() == 6 && CVV2TF.getText().length() == 5
				&& MonthTF.getText().length() == 2 && YearTF.getText().length() == 2
				&& !CaptchaTF.getText().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	private void Alert(AlertType AlertType, String Content) {
		Alert alert = new Alert(AlertType);
		alert.setHeaderText(null);
		alert.setContentText(Content);
		alert.show();
	}

}
