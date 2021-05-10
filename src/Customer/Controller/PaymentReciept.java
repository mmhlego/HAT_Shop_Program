package Customer.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import Controller.UserController;
import javafx.fxml.*;
import javafx.scene.Cursor;
import javafx.scene.control.Label;

public class PaymentReciept implements Initializable {

    @FXML
    private Label NameLBL;

    @FXML
    private Label CardLBL;

    @FXML
    private Label PriceLBL;

    @FXML
    private Label DateLBL;

    @FXML
    private Label TransactionLBL;

    @FXML
    private JFXButton ConfirmBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String TokenizedCard = Payment.Card.substring(0, 4) + "-" + Payment.Card.substring(4, 8) + "-" + Payment.Card
                .substring(8, 12) + "-" + Payment.Card.substring(12, 16);
        ConfirmBTN.setCursor(Cursor.HAND);
        NameLBL.setText(UserController.customer.FirstName + " " + UserController.customer.LastName);
        CardLBL.setText(TokenizedCard);
        PriceLBL.setText(Payment.FinalPrice);
        DateLBL.setText(Payment.ShippingDate);
        TransactionLBL.setText(Payment.TRID);

        ConfirmBTN.setOnAction((e) -> {
            Payment.stage.close();
        });
    }

}
