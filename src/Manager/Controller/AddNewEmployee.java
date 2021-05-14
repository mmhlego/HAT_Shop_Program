package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import DataController.DataAdder;
import Model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AddNewEmployee implements Initializable {

    @FXML
    private ImageView BackBTN;

    @FXML
    private TextField EmployeeFirstNameTF;

    @FXML
    private TextField EmployeeLastNameTF;

    @FXML
    private TextField EmployeeUsernameTF;

    @FXML
    private TextField EmployyeePasswordTF;

    @FXML
    private TextField EmployeePhoneTF;

    @FXML
    private TextField EmployeeEMailTF;

    @FXML
    private JFXButton AddEmployeeBTN;

    @FXML
    private TextField EmployeeAccessLevelTF;

    @FXML
    private TextField EmployeeIDTF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackBTN.setOnMouseClicked(e -> {
            ((AnchorPane) BackBTN.getParent().getParent().getParent()).getChildren()
                    .remove(BackBTN.getParent().getParent());
        });
        Tooltip tooltip = new Tooltip(
                "Avalible Levels: " + Employee.EmployeeMode.ACCOUNTANT + " ," + Employee.EmployeeMode.ASSISTANT + " ,"
                        + Employee.EmployeeMode.QUALITYCONTROL + " ," + Employee.EmployeeMode.REGULAR + " ,"
                        + Employee.EmployeeMode.STOREKEEPER + " ," + Employee.EmployeeMode.SUPPLIER);
        tooltip.setAutoHide(false);
        EmployeeAccessLevelTF.setTooltip(tooltip);

        AddEmployeeBTN.setOnAction((e) -> {
            if (!IsAllFieldsComplete()) {
                Alert(AlertType.ERROR, "بعضی از فیلد ها خالی هستند !", "خطا");
            } else {
                DataAdder.AddEmployee(EmployeeFirstNameTF.getText(), EmployeeLastNameTF.getText(),
                        EmployeeUsernameTF.getText(), EmployyeePasswordTF.getText(),
                        StringModeToIntMode(EmployeeAccessLevelTF.getText()), EmployeePhoneTF.getText(),
                        EmployeeEMailTF.getText(),
                        Employee.GenerateID(Employee.IntToMode(StringModeToIntMode(EmployeeAccessLevelTF.getText()))));
                        Alert(AlertType.INFORMATION, "کارمند با موفقیت افزوده شد", "موفق");
            }
        });
    }

    private void Alert(AlertType AlertType, String Content, String Title) {
        Alert alert = new Alert(AlertType);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.showAndWait();
    }

    private boolean IsAllFieldsComplete() {
        if (EmployeeFirstNameTF.getText().equals("") || EmployeeLastNameTF.getText().equals("")
                || EmployeeUsernameTF.getText().equals("") || EmployyeePasswordTF.getText().equals("")
                || EmployeePhoneTF.getText().equals("") || EmployeeEMailTF.getText().equals("")
                || EmployeeAccessLevelTF.getText().equals("")) {
            return false;
        }
        return true;
    }

    private int StringModeToIntMode(String Mode) {
        switch (Mode) {
            case "ASSISTANT":
                return 0;
            case "ACCOUNTANT":
                return 1;
            case "QUALITYCONTROL":
                return 2;
            case "REGULAR":
                return 3;
            case "SUPPLIER":
                return 4;
            case "STOREKEEPER":
                return 5;
        }
        return -1;
    }

}
