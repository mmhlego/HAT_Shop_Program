package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import DataController.ProductChecker;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainPage implements Initializable {
    @FXML
    private AnchorPane MainPanel;
    @FXML
    private TextField searchBar;
    @FXML
    private ImageView searchBTN;
    @FXML
    private ImageView nextBTN;
    @FXML
    private AnchorPane phones;
    @FXML
    private AnchorPane accessories;
    @FXML
    private AnchorPane pc;
    @FXML
    private AnchorPane books;
    @FXML
    private AnchorPane supermarket;
    @FXML
    private AnchorPane SpecialAnchor;

    public AnchorPane getSpecialAnchor() {
        return SpecialAnchor;
    }

    public void setSpecialAnchor(AnchorPane specialAnchor) {
        SpecialAnchor = specialAnchor;
    }

    public AnchorPane getMainPanel() {
        return MainPanel;
    }

    public void setMainPanel(AnchorPane mainPanel) {
        MainPanel = mainPanel;
    }

    public TextField getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(TextField searchBar) {
        this.searchBar = searchBar;
    }

    public ImageView getSearchBTN() {
        return searchBTN;
    }

    public void setSearchBTN(ImageView searchBTN) {
        this.searchBTN = searchBTN;
    }

    public ImageView getNextBTN() {
        return nextBTN;
    }

    public void setNextBTN(ImageView nextBTN) {
        this.nextBTN = nextBTN;
    }

    public AnchorPane getPhones() {
        return phones;
    }

    public void setPhones(AnchorPane phones) {
        this.phones = phones;
    }

    public AnchorPane getAccessories() {
        return accessories;
    }

    public void setAccessories(AnchorPane accessories) {
        this.accessories = accessories;
    }

    public AnchorPane getPc() {
        return pc;
    }

    public void setPc(AnchorPane pc) {
        this.pc = pc;
    }

    public AnchorPane getBooks() {
        return books;
    }

    public void setBooks(AnchorPane books) {
        this.books = books;
    }

    public AnchorPane getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(AnchorPane supermarket) {
        this.supermarket = supermarket;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextBTN.setOnMouseClicked(e -> {
            ProductsViewer controller = (ProductsViewer) MainStructure
                    .addPage("src/Customer/Visual/ProductsViewer.fxml");
            controller.getOnlyAmazingToggle().selectedProperty().setValue(true);
            controller.filter();
        });

        supermarket.setOnMouseClicked(e -> {
            ProductsViewer controller = (ProductsViewer) MainStructure
                    .addPage("src/Customer/Visual/ProductsViewer.fxml");
            controller.getPhoneCategoryToggle().selectedProperty().setValue(false);
            controller.getBookCategoryToggle().selectedProperty().setValue(false);
            controller.getComputerCategoryToggle().selectedProperty().setValue(false);
            controller.getAccessoriesCategoryToggle().selectedProperty().setValue(false);
            controller.filter();
        });

        books.setOnMouseClicked(e -> {
            ProductsViewer controller = (ProductsViewer) MainStructure
                    .addPage("src/Customer/Visual/ProductsViewer.fxml");
            controller.getPhoneCategoryToggle().selectedProperty().setValue(false);
            controller.getSuperMarketCategoryToggle().selectedProperty().setValue(false);
            controller.getComputerCategoryToggle().selectedProperty().setValue(false);
            controller.getAccessoriesCategoryToggle().selectedProperty().setValue(false);
            controller.filter();
        });

        accessories.setOnMouseClicked(e -> {
            ProductsViewer controller = (ProductsViewer) MainStructure
                    .addPage("src/Customer/Visual/ProductsViewer.fxml");
            controller.getPhoneCategoryToggle().selectedProperty().setValue(false);
            controller.getSuperMarketCategoryToggle().selectedProperty().setValue(false);
            controller.getComputerCategoryToggle().selectedProperty().setValue(false);
            controller.getBookCategoryToggle().selectedProperty().setValue(false);
            controller.filter();
        });

        phones.setOnMouseClicked(e -> {
            ProductsViewer controller = (ProductsViewer) MainStructure
                    .addPage("src/Customer/Visual/ProductsViewer.fxml");
            controller.getBookCategoryToggle().selectedProperty().setValue(false);
            controller.getSuperMarketCategoryToggle().selectedProperty().setValue(false);
            controller.getComputerCategoryToggle().selectedProperty().setValue(false);
            controller.getAccessoriesCategoryToggle().selectedProperty().setValue(false);
            controller.filter();
        });

        pc.setOnMouseClicked(e -> {
            ProductsViewer controller = (ProductsViewer) MainStructure
                    .addPage("src/Customer/Visual/ProductsViewer.fxml");
            controller.getPhoneCategoryToggle().selectedProperty().setValue(false);
            controller.getSuperMarketCategoryToggle().selectedProperty().setValue(false);
            controller.getBookCategoryToggle().selectedProperty().setValue(false);
            controller.getAccessoriesCategoryToggle().selectedProperty().setValue(false);
            controller.filter();
        });
        try {
            addSpecialProducts();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    static Random random = new Random(System.currentTimeMillis());

    private void addSpecialProducts() throws Exception {

        ArrayList<Product> specialProduct = new ArrayList<Product>();
        ArrayList<Product> AllSpecialProducts = ProductChecker.GetSpecialProducts();

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(AllSpecialProducts.size());
            while (specialProduct.contains(AllSpecialProducts.get(index))) {
                index = random.nextInt(AllSpecialProducts.size());
            }
            specialProduct.add(AllSpecialProducts.get(index));
        }
        int i = 0;

        for (Product product : specialProduct) {
            try {
                if (!product.equals(new Product())) {

                    FXMLLoader loader = new FXMLLoader(
                            this.getClass().getResource("../Components/ProductSmallView.fxml"));

                    Parent p = loader.load();
                    ProductSmallView s = loader.getController();
                    AnchorPane.setTopAnchor(p, ((double) 25));
                    AnchorPane.setLeftAnchor(p, ((double) (i) * 240 + 150));

                    Image image;
                    if (new File("src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")
                            .exists()) {
                        image = new Image(new FileInputStream(new File(
                                "src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")));
                    } else {
                        image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
                    }
                    s.getSpecialEvents().setVisible(true);
                    s.getProductImage().setImage(image);
                    s.getProductName().setText(product.Name);
                    s.getProductPrice().setText(String.valueOf(product.Price));
                    p.setOnMouseClicked(e -> ShowProduct(product, image));
                    ProductSmallView smallView = loader.getController();
                    smallView.getBuyButton().setOnAction(e -> ShowProduct(product, image));
                    SpecialAnchor.getChildren().add(p);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void ShowProduct(Product product, Image image) {
        try {
            //ProductInformationPage.p = product;
            ProductInformationPage c = (ProductInformationPage) MainStructure
                    .addPage("src/Customer/Visual/ProductInformationPage.fxml");
            c.buyPage(product, image);

        } catch (Exception er) {
            er.printStackTrace();
        }
    }
}
