package LoginPage.Controller.Register;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import DataController.DataAdder;
import Model.*;
import Model.Customer.CustomerMode;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        backBTN.setCursor(Cursor.HAND);
        backBTN.setOnMouseClicked(e -> Platform.exit());
        phoneField.setText(SecondRegisterPage.UserPhone);
        registerBTN.setOnAction((e) -> {
            if (!IsAllFieldsComplete(emailField, addressField)) {
                Alert(AlertType.ERROR, "بعضی از فیلد ها خالی هستند");
            } else {
                UserEmail = emailField.getText();
                UserAddress = addressField.getText();
                DataAdder.AddCustomer(FourthRegisterPage.UserFirstName, FourthRegisterPage.UserLastName,
                        ThirdRegisterPage.UserUsername, ThirdRegisterPage.UserPassword, SecondRegisterPage.UserPhone,
                        FifthRegisterPage.UserEmail, FifthRegisterPage.UserAddress, 0,
                        Customer.ModeToInt(CustomerMode.REGULAR), Customer.GenerateID());
                try {
                    ((Stage) registerBTN.getScene().getWindow()).close();
                    FXMLLoader loader = new FXMLLoader(
                            new File("src\\CommonPages\\Visual\\MainStructure.fxml").toURI().toURL());
                    Scene scene = new Scene(loader.load());
                    Stage stage = new Stage(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Alert(AlertType.INFORMATION, "با موفقیت ثبت نام شدید");
            }
        });
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
