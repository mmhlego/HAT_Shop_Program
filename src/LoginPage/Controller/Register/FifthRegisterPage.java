package LoginPage.Controller.Register;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import DataController.DataAdder;
import Model.*;
import Model.Customer.CustomerMode;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.*;

public class FifthRegisterPage implements Initializable {

    @FXML
    private AnchorPane loginAnchor;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton registerBTN;

    @FXML
    private ImageView backBTN;

    public static String UserEmail, UserAddress;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phoneField.setText(SecondRegisterPage.UserPhone);
        if (!IsAllFieldsComplete(emailField, addressField)) {
            Alert(AlertType.ERROR, "بعضی از فیلد ها خالی هستند");
        } else {
            DataAdder.AddCustomer(FourthRegisterPage.UserFirstName, FourthRegisterPage.UserLastName,
                    ThirdRegisterPage.UserUsername, ThirdRegisterPage.UserPassword, SecondRegisterPage.UserPhone,
                    FifthRegisterPage.UserEmail, FifthRegisterPage.UserAddress, 0,
                    Customer.ModeToInt(CustomerMode.REGULAR), Customer.GenerateID());
            Alert(AlertType.INFORMATION, "با موفقیت ثبت نام شدید");
            FXMLLoader loader;
            try {
                loader = new FXMLLoader(new File("../../CommonPages/Visual/MainStructure.fxml").toURI().toURL());
                loginAnchor.getChildren().add(loader.load());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static boolean IsAllFieldsComplete(TextField emailField, TextField addressField) {
        if (emailField.getText().equals("") || addressField.getText().equals("")) {
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
