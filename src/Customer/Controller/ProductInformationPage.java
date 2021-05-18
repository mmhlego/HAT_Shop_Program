package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import CommonPages.Controllers.MainStructure;
import Controller.UserController;
import Controller.UserController.UserMode;
import DataController.ProductChecker;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
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
    private Group AddToCartGroup;

    @FXML
    private Button AddToCartBTN;

    @FXML
    private Button IncreaseBTN;

    @FXML
    private Label SelectedAmountLBL;

    @FXML
    private Button DecreaseBTN;

    @FXML
    private JFXTextArea ProductDescriptionTXT;

    @FXML
    private TableView<Map<String, Object>> ProductDetailsTable;

    @FXML
    private AnchorPane SimilarProductsAnchor;

    @SuppressWarnings("rawtypes")
    @FXML
    private TableColumn<Map, String> InformationColumn;

    @SuppressWarnings("rawtypes")
    @FXML
    private TableColumn<Map, String> MColumn;

    @FXML
    private Button LoadMoreBTN;

    @FXML
    private Group FinishedGroup;

    public Product p;

    int AmountInsideCart = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IncreaseBTN.setOnAction(e -> {
            SelectedAmountLBL.setText(String.valueOf(Integer.parseInt(SelectedAmountLBL.getText()) + 1));
            checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount - AmountInsideCart, DecreaseBTN,
                    IncreaseBTN);
        });

        DecreaseBTN.setOnAction(e -> {
            SelectedAmountLBL.setText(String.valueOf(Integer.parseInt(SelectedAmountLBL.getText()) - 1));
            checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount - AmountInsideCart, DecreaseBTN,
                    IncreaseBTN);
        });

        AddToCartBTN.setOnAction(e -> {
            UserController.Cart.addProduct(p, Integer.parseInt(SelectedAmountLBL.getText()));
            UserController.UpdateCart();
        });

        //checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount - AmountInsideCart, DecreaseBTN,
        //        IncreaseBTN);

        //CheckSpecial();
    }

    private void checkAmount(int amount, int max, Button dButton, Button iButton) {
        if (amount == 0) {
            SelectedAmountLBL.setText("0");
            AddToCartBTN.setDisable(true);
            BuyBTN.setText("");
            FinishedGroup.setVisible(true);
        } else {
            FinishedGroup.setVisible(false);
        }

        if (amount > 1) {
            dButton.setDisable(false);
        } else {
            dButton.setDisable(true);
        }
        if (amount < max) {
            iButton.setDisable(false);
        } else {
            iButton.setDisable(true);
        }

        CheckSpecial();
    }

    public void buyPage(Product p, Image image) {
        this.p = p;

        if (UserController.Mode.equals(UserMode.Customer)) {
            int index = UserController.Cart.contains(p.ID);
            if (index != -1) {
                AmountInsideCart = UserController.Cart.Amounts.get(index);
            }
        }

        if (p.Amount - AmountInsideCart == 0) {
            SelectedAmountLBL.setText("0");
        }

        if (p.Amount == 0) {
            BuyBTN.setDisable(true);
        }

        BuyBTN.setOnAction(e -> {
            BuyBTN.setVisible(false);
            AddToCartGroup.setVisible(true);
        });

        ProductCategoryLBL.setText(p.Category);
        ProductDescriptionTXT.setText(p.Description);
        ProductIDLBL.setText(p.ID);
        ProductIMG.setImage(image);
        ProductNameLBL.setText(p.Name);
        ProductPriceLBL.setText(String.valueOf(p.Price));

        ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();
        for (int j = 0; j < p.Details.length; j++) {
            Map<String, Object> item = new HashMap<>();
            item.put("firstrow", p.Details[j][0]);
            item.put("secondrow", p.Details[j][1]);
            items.add(item);
        }

        MColumn.setCellValueFactory(new MapValueFactory<String>("firstrow"));
        InformationColumn.setCellValueFactory(new MapValueFactory<String>("secondrow"));
        ProductDetailsTable.setItems(items);
        showSpecialProduct(SimilarProductsAnchor);

        LoadMoreBTN.toFront();
        LoadMoreBTN.setOnAction(e -> {
            ProductsViewer controller = (ProductsViewer) MainStructure
                    .addPage("src/Customer/Visual/ProductsViewer.fxml");
            controller.getOnlyAmazingToggle().selectedProperty().setValue(true);
            controller.filter();
        });

        checkAmount(Integer.parseInt(SelectedAmountLBL.getText()), p.Amount - AmountInsideCart, DecreaseBTN,
                IncreaseBTN);

        CheckSpecial();
    }

    private void CheckSpecial() {
        boolean special = p.IsSpecial();
        SpecialIMG.setVisible(special);
        SpecialTXT.setVisible(special);
    }

    Random random = new Random(System.currentTimeMillis());

    private void showSpecialProduct(AnchorPane pane) {
        ArrayList<Product> specialProduct = new ArrayList<Product>();
        ArrayList<Product> AllSpecialProducts = ProductChecker.GetSpecialProducts();

        for (int i = 0; i < 5; i++) {
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
                    AnchorPane.setLeftAnchor(p, ((double) (i) * 225 + 25 - 120));

                    Image image;
                    if (new File("src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")
                            .exists()) {
                        image = new Image(new FileInputStream(new File(
                                "src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")));
                    } else {
                        image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
                    }

                    s.getProductImage().setImage(image);
                    s.getProductName().setText(product.Name);
                    s.getProductPrice().setText(String.valueOf(product.Price));
                    s.getSpecialEvents().setText("کالای شگفت انگیز");
                    s.getSpecialEvents().setVisible(true);
                    p.setOnMouseClicked(e -> buyPage(product, image));
                    ProductSmallView smallView = loader.getController();
                    smallView.getBuyButton().setOnAction(e -> buyPage(product, image));
                    pane.getChildren().add(p);

                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
