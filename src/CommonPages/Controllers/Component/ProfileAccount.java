package CommonPages.Controllers.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfileAccount {

    @FXML
    private Label UsernameLBL;

    @FXML
    private Label ModeLBL;

    @FXML
    private Label IDLBL;

    public Label getUsernameLBL() {
        return UsernameLBL;
    }

    public void setUsernameLBL(Label usernameLBL) {
        UsernameLBL = usernameLBL;
    }

    public Label getModeLBL() {
        return ModeLBL;
    }

    public void setModeLBL(Label modeLBL) {
        ModeLBL = modeLBL;
    }

    public Label getIDLBL() {
        return IDLBL;
    }

    public void setIDLBL(Label iDLBL) {
        IDLBL = iDLBL;
    }

}
