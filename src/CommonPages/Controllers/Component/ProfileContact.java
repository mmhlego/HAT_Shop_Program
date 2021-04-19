package CommonPages.Controllers.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfileContact {

    @FXML
    private Label MailLBL;

    @FXML
    private Label PhoneLBL;

    public Label getMailLBL() {
        return MailLBL;
    }

    public void setMailLBL(Label mailLBL) {
        MailLBL = mailLBL;
    }

    public Label getPhoneLBL() {
        return PhoneLBL;
    }

    public void setPhoneLBL(Label phoneLBL) {
        PhoneLBL = phoneLBL;
    }

}
