package Customer.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HistoryEachProduct {
    @FXML
    private ImageView ProductIMG;
    @FXML
    private Button SeeProductBTN;
    @FXML
    private Label TotalPriceLBL;
    @FXML
    private Label BasePriceLBL;
    @FXML
    private Label PercentageLBL;
    @FXML
    private Label ProductIDLBL;
    @FXML
    private Label ProductNameLBL;
    @FXML
    private Label ProductCategoryLBL;
    @FXML
    private Label AmountLBL;

    public ImageView getProductIMG() {
        return ProductIMG;
    }

    public void setProductIMG(ImageView productIMG) {
        ProductIMG = productIMG;
    }

    public Button getSeeProductBTN() {
        return SeeProductBTN;
    }

    public void setSeeProductBTN(Button seeProductBTN) {
        SeeProductBTN = seeProductBTN;
    }

    public Label getTotalPriceLBL() {
        return TotalPriceLBL;
    }

    public void setTotalPriceLBL(Label totalPriceLBL) {
        TotalPriceLBL = totalPriceLBL;
    }

    public Label getBasePriceLBL() {
        return BasePriceLBL;
    }

    public void setBasePriceLBL(Label basePriceLBL) {
        BasePriceLBL = basePriceLBL;
    }

    public Label getPercentageLBL() {
        return PercentageLBL;
    }

    public void setPercentageLBL(Label percentageLBL) {
        PercentageLBL = percentageLBL;
    }

    public Label getProductIDLBL() {
        return ProductIDLBL;
    }

    public void setProductIDLBL(Label productIDLBL) {
        ProductIDLBL = productIDLBL;
    }

    public Label getProductNameLBL() {
        return ProductNameLBL;
    }

    public void setProductNameLBL(Label productNameLBL) {
        ProductNameLBL = productNameLBL;
    }

    public Label getProductCategoryLBL() {
        return ProductCategoryLBL;
    }

    public void setProductCategoryLBL(Label productCategoryLBL) {
        ProductCategoryLBL = productCategoryLBL;
    }

    public Label getAmountLBL() {
        return AmountLBL;
    }

    public void setAmountLBL(Label amountLBL) {
        AmountLBL = amountLBL;
    }

}
