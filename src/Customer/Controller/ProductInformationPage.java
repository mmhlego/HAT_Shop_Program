package Customer.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProductInformationPage implements Initializable {
    @FXML
    private ImageView ProductIMG;
    @FXML
    private Button BuyBTN;
    @FXML
    private Label ProductNameLBL;
    @FXML
    private Label ProductPriceLBL;
    @FXML
    private Label ProductCategoryLBL;
    @FXML
    private Label ProductIDLBL;
    @FXML
    private ImageView SpecialIMG;
    @FXML
    private Label SpecialTXT;
    @FXML
    private JFXTextArea ProductDescriptionTXT;
    @FXML
    private TableView<?> ProductDetailsTable;
    @FXML
    private AnchorPane SimilarProductsAnchor;
    @FXML
    private Button LoadMoreBTN;

    public ImageView getProductIMG() {
        return ProductIMG;
    }

    public void setProductIMG(ImageView productIMG) {
        ProductIMG = productIMG;
    }

    public Button getBuyBTN() {
        return BuyBTN;
    }

    public void setBuyBTN(Button buyBTN) {
        BuyBTN = buyBTN;
    }

    public Label getProductNameLBL() {
        return ProductNameLBL;
    }

    public void setProductNameLBL(Label productNameLBL) {
        ProductNameLBL = productNameLBL;
    }

    public Label getProductPriceLBL() {
        return ProductPriceLBL;
    }

    public void setProductPriceLBL(Label productPriceLBL) {
        ProductPriceLBL = productPriceLBL;
    }

    public Label getProductCategoryLBL() {
        return ProductCategoryLBL;
    }

    public void setProductCategoryLBL(Label productCategoryLBL) {
        ProductCategoryLBL = productCategoryLBL;
    }

    public Label getProductIDLBL() {
        return ProductIDLBL;
    }

    public void setProductIDLBL(Label productIDLBL) {
        ProductIDLBL = productIDLBL;
    }

    public ImageView getSpecialIMG() {
        return SpecialIMG;
    }

    public void setSpecialIMG(ImageView specialIMG) {
        SpecialIMG = specialIMG;
    }

    public Label getSpecialTXT() {
        return SpecialTXT;
    }

    public void setSpecialTXT(Label specialTXT) {
        SpecialTXT = specialTXT;
    }

    public JFXTextArea getProductDescriptionTXT() {
        return ProductDescriptionTXT;
    }

    public void setProductDescriptionTXT(JFXTextArea productDescriptionTXT) {
        ProductDescriptionTXT = productDescriptionTXT;
    }

    public TableView<?> getProductDetailsTable() {
        return ProductDetailsTable;
    }

    public void setProductDetailsTable(TableView<?> productDetailsTable) {
        ProductDetailsTable = productDetailsTable;
    }

    public AnchorPane getSimilarProductsAnchor() {
        return SimilarProductsAnchor;
    }

    public void setSimilarProductsAnchor(AnchorPane similarProductsAnchor) {
        SimilarProductsAnchor = similarProductsAnchor;
    }

    public Button getLoadMoreBTN() {
        return LoadMoreBTN;
    }

    public void setLoadMoreBTN(Button loadMoreBTN) {
        LoadMoreBTN = loadMoreBTN;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}