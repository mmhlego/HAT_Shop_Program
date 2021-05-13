package Manager.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import DataController.DataAdder;
import Model.Product;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AddNewProduct implements Initializable {

    @FXML
    private ImageView BackBTN;

    @FXML
    private TextField ProductNameTF;

    @FXML
    private TextField ProductCategoryTF;

    @FXML
    private TextField ProductPriceTF;

    @FXML
    private TextField ProductPercentageTF;

    @FXML
    private TextField ProductDetailsTF;

    @FXML
    private TextField ProductAmountTF;

    @FXML
    private TextField ProductIDTF;

    @FXML
    private TextField ProductDescriptionTF;

    @FXML
    private JFXButton AddProductBTN;

    public void ShowAddNewProduct(Product product) {
        BackBTN.setOnMouseClicked(e -> {
            ((AnchorPane) BackBTN.getParent().getParent().getParent()).getChildren()
                    .remove(BackBTN.getParent().getParent());
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AddProductBTN.setOnAction((e) -> {
            if (!IsAllFieldsComplete()) {
                Alert(AlertType.ERROR, "بعضی از فیلد ها خالی هستند !", "خطا");
            } else {
                Product New = new Product(ProductNameTF.getText(), ProductDescriptionTF.getText(),
                        ParseToArray(ProductDetailsTF.getText()), Long.parseLong(ProductPriceTF.getText()),
                        Integer.parseInt(ProductPercentageTF.getText()), ProductCategoryTF.getText(),
                        Integer.parseInt(ProductAmountTF.getText()), Product.GenerateID());
                DataAdder.AddProduct(New);
                Alert(AlertType.INFORMATION, "کالا با موفقیت افزوده شد ", "موفق");
            }
        });

        BackBTN.setOnMouseClicked(e -> {
            ((AnchorPane) BackBTN.getParent().getParent().getParent()).getChildren()
                    .remove(BackBTN.getParent().getParent());
        });
    }

    public static String[][] ParseToArray(String s) {
        try {
            String[] all = s.split(",");
            int len = all.length;

            String[][] ans = new String[len][2];

            for (int i = 0; i < len; i++) {
                ans[i] = all[i].split(":");
            }

            return ans;
        } catch (Exception e) {
            Alert(AlertType.ERROR, "فرمت وارد شده برای اطلاعات کالا نادرست است", "خطا");
        }
        return null;
    }

    private static void Alert(AlertType AlertType, String Content, String Title) {
        Alert alert = new Alert(AlertType);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.show();
    }

    private boolean IsAllFieldsComplete() {
        if (ProductNameTF.getText().equals("") || ProductDescriptionTF.getText().equals("")
                || ProductDetailsTF.getText().equals("") || ProductPriceTF.getText().equals("")
                || ProductPercentageTF.getText().equals("") || ProductCategoryTF.getText().equals("")
                || ProductAmountTF.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
