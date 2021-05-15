package Manager.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EachProductAmount {
    @FXML
    private Label ProductAmountLBL;
    @FXML
    private Label ProductNameLBL;

    public Label getProductAmountLBL() {
        return ProductAmountLBL;
    }

    public void setProductAmountLBL(Label productAmountLBL) {
        ProductAmountLBL = productAmountLBL;
    }

    public Label getProductNameLBL() {
        return ProductNameLBL;
    }

    public void setProductNameLBL(Label productNameLBL) {
        ProductNameLBL = productNameLBL;
    }
}
