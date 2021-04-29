package Manager.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EachCustomer {

    @FXML
    private Label RegularLBL;

    @FXML
    private Label PremiumLBL;

    @FXML
    private Label BannedLBL;

    @FXML
    private JFXButton CustomerOrderHistoryBTN;

    @FXML
    private JFXButton CustomerCartBTN;

    @FXML
    private JFXButton CustomerInformationBTN;

    @FXML
    private Label CustomerIDLBL;

    @FXML
    private Label CustomerNameLBL;

    public Label getRegularLBL() {
        return RegularLBL;
    }

    public void setRegularLBL(Label regularLBL) {
        RegularLBL = regularLBL;
    }

    public Label getPremiumLBL() {
        return PremiumLBL;
    }

    public void setPremiumLBL(Label premiumLBL) {
        PremiumLBL = premiumLBL;
    }

    public Label getBannedLBL() {
        return BannedLBL;
    }

    public void setBannedLBL(Label bannedLBL) {
        BannedLBL = bannedLBL;
    }

    public JFXButton getCustomerOrderHistoryBTN() {
        return CustomerOrderHistoryBTN;
    }

    public void setCustomerOrderHistoryBTN(JFXButton customerOrderHistoryBTN) {
        CustomerOrderHistoryBTN = customerOrderHistoryBTN;
    }

    public JFXButton getCustomerCartBTN() {
        return CustomerCartBTN;
    }

    public void setCustomerCartBTN(JFXButton customerCartBTN) {
        CustomerCartBTN = customerCartBTN;
    }

    public JFXButton getCustomerInformationBTN() {
        return CustomerInformationBTN;
    }

    public void setCustomerInformationBTN(JFXButton customerInformationBTN) {
        CustomerInformationBTN = customerInformationBTN;
    }

    public Label getCustomerIDLBL() {
        return CustomerIDLBL;
    }

    public void setCustomerIDLBL(Label customerIDLBL) {
        CustomerIDLBL = customerIDLBL;
    }

    public Label getCustomerNameLBL() {
        return CustomerNameLBL;
    }

    public void setCustomerNameLBL(Label customerNameLBL) {
        CustomerNameLBL = customerNameLBL;
    }

}
