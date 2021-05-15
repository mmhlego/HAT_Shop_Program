package Manager.Controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import DataController.DBConnector;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductEditInformation implements Initializable {
    @FXML
    private ImageView ProductIMG;
    @FXML
    private Button EditDataBTN;
    @FXML
    private JFXTextField ProductNameLBL;
    @FXML
    private TextField ProductPriceLBL;
    @FXML
    private TextField ProductCategoryLBL;
    @FXML
    private TextField ProductIDLBL;
    @FXML
    private ImageView SpecialIMG;
    @FXML
    private Label SpecialTXT;
    @FXML
    private Group AddToCartGroup;
    @FXML
    private TextField ProductAmountLBL;
    @FXML
    private Group AddAmountGRP;
    @FXML
    private Button AddToAmountBTN;
    @FXML
    private TextField AddToAmountLBL;
    @FXML
    private JFXTextArea ProductDescriptionTXT;
    @FXML
    private TableView<Map<String, Object>> ProductDetailsTable;
    @SuppressWarnings("rawtypes")
    @FXML
    private TableColumn<Map, String> InformationColumn;
    @SuppressWarnings("rawtypes")
    @FXML
    private TableColumn<Map, String> MColumn;
    @FXML
    private Button EditProductDataBTN;
    @FXML
    private Button DeleteProductBTN;

    public void ShowProductInfo(Product p, Image image, boolean special) {
        ProductAmountLBL.setText(String.valueOf(p.Amount));
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
        ProductIMG.setImage(image);
        ProductCategoryLBL.setText(p.Category);
        ProductDescriptionTXT.setText(p.Description);
        ProductIDLBL.setText(p.ID);
        ProductNameLBL.setText(p.Name);
        ProductPriceLBL.setText(String.valueOf(p.Price));
        /*
         * SpecialIMG.setVisible(special); SpecialTXT.setVisible(special);
         */
        DeleteProductBTN.setOnMouseClicked(e -> {
            try {
                PreparedStatement ps = DBConnector.Con
                        .prepareStatement("DELETE FROM Products WHERE ID=" + "\'" + ProductIDLBL.getText() + "\'");
                ps.executeUpdate();
                Alert(AlertType.INFORMATION, "کالای مورد نظر با موفقیت حذف شد", "موفق");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AddToAmountBTN.setOnAction((e) -> {
            if (AddToAmountLBL.getText().equals("")) {
                Alert(AlertType.ERROR, "عددی را وارد نمایید", "خطا");
            } else if (Integer.parseInt(AddToAmountLBL.getText()) < 0) {
                Alert(AlertType.ERROR, "عدد وارد شده نمیتواند منفی باشد ! ", "خطا");
            } else {
                ProductAmountLBL.setText(Integer.toString(
                        (Integer.parseInt(ProductAmountLBL.getText()) + Integer.parseInt(AddToAmountLBL.getText()))));
                AddToAmountLBL.setText("");
            }
        });

        EditProductDataBTN.setOnAction((e) -> {
            try {
                PreparedStatement ps = DBConnector.Con.prepareStatement("UPDATE Products SET Name=" + "\'"
                        + ProductNameLBL.getText() + "\'" + ", Description=" + "\'" + ProductDescriptionTXT.getText()
                        + "\'" + ", Price=" + Long.parseLong(ProductPriceLBL.getText()) + ", Category=" + "\'"
                        + ProductCategoryLBL.getText() + "\'" + ", Amount="
                        + Integer.parseInt(ProductAmountLBL.getText()) + " WHERE ID=" + "\'" + ProductIDLBL.getText()
                        + "\'");
                ps.executeUpdate();
                Alert(AlertType.INFORMATION, "اطلاعات کالا با موفقیت تغییر یافت", "موفق");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

    }

    private void Alert(AlertType AlertType, String Content, String Title) {
        Alert alert = new Alert(AlertType);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.show();
    }

}
