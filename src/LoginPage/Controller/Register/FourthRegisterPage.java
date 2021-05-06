package LoginPage.Controller.Register;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.*;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.io.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FourthRegisterPage implements Initializable {

    @FXML
    private AnchorPane loginAnchor;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private JFXButton nextStep;

    @FXML
    private ImageView backBTN;

    public static String UserFirstName, UserLastName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBTN.setCursor(Cursor.HAND);
        backBTN.setOnMouseClicked(e -> System.exit(0));
        nextStep.setCursor(Cursor.HAND);
        nextStep.setOnAction((e) -> {
            if (!IsAllFieldsComplete(firstName, lastName)) {
                Alert(AlertType.ERROR, "بعضی از فیلد ها خالی هستند");
            } else {
                UserFirstName = firstName.getText();
                UserLastName = lastName.getText();
                FXMLLoader loader;
                try {
                    loader = new FXMLLoader(
                            new File("src\\LoginPage\\View\\Register\\FifthRegisterPage.fxml").toURI().toURL());
                    loginAnchor.getChildren().add(loader.load());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static boolean IsAllFieldsComplete(TextField Firstname, TextField LastName) {
        if (Firstname.getText().equals("") || LastName.getText().equals("")) {
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
