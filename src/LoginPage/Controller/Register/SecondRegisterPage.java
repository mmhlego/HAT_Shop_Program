package LoginPage.Controller.Register;

import java.net.URL;
import java.util.*;
import com.jfoenix.controls.JFXButton;
import DataController.*;
import Model.*;
import javafx.application.Platform;
import javafx.fxml.*;
import java.io.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SecondRegisterPage implements Initializable {

    @FXML
    private AnchorPane loginAnchor;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField OTP;

    @FXML
    private JFXButton sendOTP;

    @FXML
    private JFXButton check;

    @FXML
    private ImageView backBTN;

    public static String UserPhone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBTN.setCursor(Cursor.HAND);
        backBTN.setOnMouseClicked(e -> Platform.exit());
        Limitter.Limit(phoneNumber, 11, true);
        Limitter.Limit(OTP, 6, true);
        phoneNumber.setText(FirstRegisterPage.Phone);
        sendOTP.setOnAction((e) -> {
            if (phoneNumber.getText().length() == 11 && phoneNumber.getText().substring(0, 2).equals("09")) {
                SMSSender.SendOTP(phoneNumber.getText());
            } else {
                Alert(AlertType.ERROR, "شماره تلفن وارد شده اشتباه است !");
            }
        });

        check.setOnAction((e) -> {
            if (OTP.getText().equals(SMSSender.getOTP())) {
                UserPhone = phoneNumber.getText();
                FXMLLoader loader;
                try {
                    loader = new FXMLLoader(
                            new File("src\\LoginPage\\View\\Register\\ThirdRegisterPage.fxml").toURI().toURL());
                    loginAnchor.getChildren().add(loader.load());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                Alert(AlertType.ERROR, "رمز یکبار مصرف وارد شده اشتباه است");
            }
        });
    }

    private void Alert(AlertType AlertType, String Content) {
        Alert alert = new Alert(AlertType);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.show();
    }

}
