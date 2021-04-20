package Customer.Controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSlider;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProductsViewer {
    @FXML
    private AnchorPane ProductsPanel;
    @FXML
    private TextField SearchTXF;
    @FXML
    private Button SearchBTN;
    @FXML
    private JFXCheckBox PhoneCategoryToggle;
    @FXML
    private JFXCheckBox AccessoriesCategoryToggle;
    @FXML
    private JFXCheckBox ComputerCategoryToggle;
    @FXML
    private JFXCheckBox BookCategoryToggle;
    @FXML
    private JFXCheckBox SuperMarketCategoryToggle;
    @FXML
    private JFXCheckBox OnlyAvailableToggle;
    @FXML
    private Button FilterBTN;
    @FXML
    private JFXSlider MaxPriceSlider;
    @FXML
    private Label MaxPriceLBL;

    public AnchorPane getProductsPanel() {
        return ProductsPanel;
    }

    public void setProductsPanel(AnchorPane productsPanel) {
        ProductsPanel = productsPanel;
    }

    public TextField getSearchTXF() {
        return SearchTXF;
    }

    public void setSearchTXF(TextField searchTXF) {
        SearchTXF = searchTXF;
    }

    public Button getSearchBTN() {
        return SearchBTN;
    }

    public void setSearchBTN(Button searchBTN) {
        SearchBTN = searchBTN;
    }

    public JFXCheckBox getPhoneCategoryToggle() {
        return PhoneCategoryToggle;
    }

    public void setPhoneCategoryToggle(JFXCheckBox phoneCategoryToggle) {
        PhoneCategoryToggle = phoneCategoryToggle;
    }

    public JFXCheckBox getAccessoriesCategoryToggle() {
        return AccessoriesCategoryToggle;
    }

    public void setAccessoriesCategoryToggle(JFXCheckBox accessoriesCategoryToggle) {
        AccessoriesCategoryToggle = accessoriesCategoryToggle;
    }

    public JFXCheckBox getComputerCategoryToggle() {
        return ComputerCategoryToggle;
    }

    public void setComputerCategoryToggle(JFXCheckBox computerCategoryToggle) {
        ComputerCategoryToggle = computerCategoryToggle;
    }

    public JFXCheckBox getBookCategoryToggle() {
        return BookCategoryToggle;
    }

    public void setBookCategoryToggle(JFXCheckBox bookCategoryToggle) {
        BookCategoryToggle = bookCategoryToggle;
    }

    public JFXCheckBox getSuperMarketCategoryToggle() {
        return SuperMarketCategoryToggle;
    }

    public void setSuperMarketCategoryToggle(JFXCheckBox superMarketCategoryToggle) {
        SuperMarketCategoryToggle = superMarketCategoryToggle;
    }

    public JFXCheckBox getOnlyAvailableToggle() {
        return OnlyAvailableToggle;
    }

    public void setOnlyAvailableToggle(JFXCheckBox onlyAvailableToggle) {
        OnlyAvailableToggle = onlyAvailableToggle;
    }

    public Button getFilterBTN() {
        return FilterBTN;
    }

    public void setFilterBTN(Button filterBTN) {
        FilterBTN = filterBTN;
    }

    public JFXSlider getMaxPriceSlider() {
        return MaxPriceSlider;
    }

    public void setMaxPriceSlider(JFXSlider maxPriceSlider) {
        MaxPriceSlider = maxPriceSlider;
    }

    public Label getMaxPriceLBL() {
        return MaxPriceLBL;
    }

    public void setMaxPriceLBL(Label maxPriceLBL) {
        MaxPriceLBL = maxPriceLBL;
    }
}
