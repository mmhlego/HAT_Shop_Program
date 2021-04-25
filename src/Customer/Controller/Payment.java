package Customer.Controller;

import java.net.URL;
import java.util.*;

import Controller.UserController;
import DataController.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import Model.*;

public class Payment implements Initializable {

    @FXML
    private AnchorPane PaymentAnchor;

    @FXML
    private TextField CardNumberTF;

    @FXML
    private TextField AmountTF;

    @FXML
    private TextField CVVTF;

    @FXML
    private TextField CVV2TF;

    @FXML
    private TextField MonthTF;

    @FXML
    private TextField YearTF;

    @FXML
    private TextField CaptchaTF;

    @FXML
    private Button RequestOTP;

    @FXML
    private Button ChangeCaptcha;

    @FXML
    private Button Procceed;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LimitTextFieldPassToNext();
        RequestOTP.setOnAction((e) -> {
            SMSSender.SendOTP(UserController.customer.Phone);
        });
        Procceed.setOnAction((e) -> {
            if (!IsAllFieldsComplete()) {
                Alert(AlertType.ERROR, "بعضی از فیلد ها کامل نیستند !");
            } else if (!SMSSender.getOTP().equals(CVVTF.getText())) {
                Alert(AlertType.ERROR, "رمز یک بار مصرف درست نیست !");
            } else if (!Captcha.captchaResult.equals(CaptchaTF.getText())) {
                Alert(AlertType.ERROR, "حروف تصویر نادرست است !");
            } else {
                UserUpdator.UpdateValue(UserController.customer.Username, Long.parseLong(AmountTF.getText()));
                Alert(AlertType.INFORMATION, "حساب با موفقیت شارژ شد");
            }
        });
    }

    private void LimitTextFieldPassToNext() {
        Limitter.Limit(CardNumberTF, 16, true);
        Limitter.Limit(CVVTF, 3, true);
        Limitter.Limit(CVV2TF, 5, true);
        Limitter.Limit(MonthTF, 2, true);
        Limitter.Limit(YearTF, 2, true);
    }

    private boolean IsAllFieldsComplete() {
        if (CardNumberTF.getText().length() == 16 && CVVTF.getText().length() == 3 && CVV2TF.getText().length() == 5
                && MonthTF.getText().length() == 2 && YearTF.getText().length() == 2 && !AmountTF.getText().equals("")
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
