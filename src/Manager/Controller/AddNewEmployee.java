package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
        //Tooltip tooltip = new Tooltip("Avalible Categories: " + Product.ACCESSORIES + " ," + Product.BOOK + " ,"
        //        + Product.COMPUTER + " ," + Product.PHONE + " ," + Product.SUPERMARKET);
        //tooltip.setAutoHide(false);
        //ProductCategoryTF.setTooltip(tooltip);
    }
}
