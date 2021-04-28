package Customer.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import Controller.UserController;
import DataController.*;
import Model.*;
import Model.Transaction;
import Model.Order.OrderStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

	public static boolean TransactionMode = false;

	public static String FinalPrice;
	public static String ShippingDate;
	public static String ShippingFee;
	public String TRID;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AmountLBL.setText(FinalPrice);
		TRID = Transaction.GenerateID();
		TransactionIDLBL.setText(TRID);

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
				if (TransactionMode) {
					UserController.Cart.Status = OrderStatus.SENDING;
					DataUpdator.UpdateOrderStatus(UserController.Cart);
					DataAdder.AddShipping(UserController.Cart.OrderID, 0, Long.parseLong(ShippingFee),
							LocalDate.parse(ShippingDate), Shipping.GenerateID());
					DataAdder.AddTransaction(UserController.Cart.OwnerID, Long.parseLong(FinalPrice),
							LocalDate.parse(ShippingDate), Transaction.GenerateID());
					DataAdder.AddOrder(new Order(UserController.customer.ID, Order.GenerateID(), OrderStatus.PENDING));
					Alert(AlertType.INFORMATION, "پرداخت با موفقیت انجام شد.");
					ProceedBTN.getParent().getScene().getWindow().hide();
				} else {
					UserUpdator.UpdateValue(UserController.customer.Username, GetAmount());
				}
				UserController.LoadUserFullData();
			}
		});

		CancelBTN.setOnAction((e) -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("آیا میخواهید فرآیند پرداخت را لغو کنید ؟");
			alert.showAndWait();
			if (alert.getResult() == ButtonType.OK) {
				CancelBTN.getParent().getScene().getWindow().hide();
				Alert(AlertType.INFORMATION, "پرداخت با امنیت کامل لغو شد");
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
