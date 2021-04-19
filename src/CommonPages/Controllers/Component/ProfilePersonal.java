package CommonPages.Controllers.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfilePersonal {

    @FXML
    private Label FirstNameLBL;

    @FXML
    private Label LastNameLBL;

    public Label getFirstNameLBL() {
        return FirstNameLBL;
    }

    public void setFirstNameLBL(Label firstNameLBL) {
        FirstNameLBL = firstNameLBL;
    }

    public Label getLastNameLBL() {
        return LastNameLBL;
    }

    public void setLastNameLBL(Label lastNameLBL) {
        LastNameLBL = lastNameLBL;
    }

}
