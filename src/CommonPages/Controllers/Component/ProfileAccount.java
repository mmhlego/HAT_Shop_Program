package CommonPages.Controllers.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfileAccount {
    @FXML
    private Label UsernameLBL;
    @FXML
    private Label ModeTitleLBL;
    @FXML
    private Label ModeLBL;
    @FXML
    private Label IDTitleLBL;
    @FXML
    private Label IDLBL;
    @FXML
    private Button ChargeBalanceBTN;
    @FXML
    private Button UpgradeAccountBTN;
    @FXML
    private Label AccountValueTitle;
    @FXML
    private Label AccountValueLBL;

    public Button getChargeBalanceBTN() {
        return ChargeBalanceBTN;
    }

    public Label getAccountValueTitle() {
        return AccountValueTitle;
    }

    public void setAccountValueTitle(Label accountValueTitle) {
        AccountValueTitle = accountValueTitle;
    }

    public Label getAccountValueLBL() {
        return AccountValueLBL;
    }

    public void setAccountValueLBL(Label accountValueLBL) {
        AccountValueLBL = accountValueLBL;
    }

    public void setChargeBalanceBTN(Button chargeBalanceBTN) {
        ChargeBalanceBTN = chargeBalanceBTN;
    }

    public Button getUpgradeAccountBTN() {
        return UpgradeAccountBTN;
    }

    public void setUpgradeAccountBTN(Button upgradeAccountBTN) {
        UpgradeAccountBTN = upgradeAccountBTN;
    }

    public Label getUsernameLBL() {
        return UsernameLBL;
    }

    public void setUsernameLBL(Label usernameLBL) {
        UsernameLBL = usernameLBL;
    }

    public Label getModeTitleLBL() {
        return ModeTitleLBL;
    }

    public void setModeTitleLBL(Label modeTitleLBL) {
        ModeTitleLBL = modeTitleLBL;
    }

    public Label getModeLBL() {
        return ModeLBL;
    }

    public void setModeLBL(Label modeLBL) {
        ModeLBL = modeLBL;
    }

    public Label getIDTitleLBL() {
        return IDTitleLBL;
    }

    public void setIDTitleLBL(Label iDTitleLBL) {
        IDTitleLBL = iDTitleLBL;
    }

    public Label getIDLBL() {
        return IDLBL;
    }

    public void setIDLBL(Label iDLBL) {
        IDLBL = iDLBL;
    }

}
