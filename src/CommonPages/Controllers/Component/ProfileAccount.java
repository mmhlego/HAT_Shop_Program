package CommonPages.Controllers.Component;

import javafx.fxml.FXML;
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
