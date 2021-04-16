package LoginPage.Controller.Register;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import DataController.DataChecker;
import Model.*;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ThirdRegisterPage implements Initializable {

    @FXML
    private AnchorPane loginAnchor;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField passwordRepeat;

    @FXML
    private JFXButton nextStep;

    @FXML
    private ImageView backBTN;

    public static String UserUsername , UserPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBTN.setCursor(Cursor.HAND);
        backBTN.setOnMouseClicked(e -> Platform.exit());
        Limitter.Limit(username, 15, false);
        Limitter.Limit(password, 15, false);
        Limitter.Limit(passwordRepeat, 15, false);
        nextStep.setOnAction((e) -> {
            if (!IsAllFieldsComplete(username, password, passwordRepeat)) {
                Alert(AlertType.ERROR, "بعضی از فیلد ها خالی هستند");
            }else if (!password.getText().equals(passwordRepeat.getText())){
                Alert(AlertType.ERROR, "پسورد ها مطابقت ندارند");
            } else if (DataChecker.UsernameExists(username.getText())) {
                Alert(AlertType.ERROR, "این نام کاربری موجود است نام کاربری دیگری انتخاب نمایید");
            } else {
                UserUsername = username.getText();
                UserPassword = password.getText();
                FXMLLoader loader;
                try {
                    loader = new FXMLLoader(
                            new File("src\\LoginPage\\View\\Register\\FourthRegisterPage.fxml").toURI().toURL());
                    loginAnchor.getChildren().add(loader.load());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static boolean IsAllFieldsComplete(TextField Username, TextField Password, TextField PasswordRepeat) {
        if (Username.getText().equals("") || Password.getText().equals("") || PasswordRepeat.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void Alert(AlertType AlertType, String Content) {
        Alert alert = new Alert(AlertType);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.show();
    }

}
