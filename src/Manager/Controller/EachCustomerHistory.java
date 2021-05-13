package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DataController.UserGetter;
import Model.Customer;
import Model.Order;
import Model.Shipping;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class EachCustomerHistory implements Initializable {

    @FXML
    private ImageView BackBTN;

    @FXML
    private VBox OrdersPanel;
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        BackBTN.setOnMouseClicked(e -> {
            ((AnchorPane) BackBTN.getParent().getParent().getParent()).getChildren()
                    .remove(BackBTN.getParent().getParent());
        });
    }

    public void AddCustomersOrdersHistory(Customer c) throws Exception {
        orders = UserGetter.ConvertOrderToArrayList(UserGetter.GetOrdersDB(c.ID));
        for (Order order : orders) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("../Components/EachCustomerHistoryEachOrder.fxml"));
            Parent parent = loader.load();
            HistoryEachHistoryOrder controller = loader.getController();
            Shipping shipping = UserGetter.GetShippingByOrderID(order.OrderID);
            controller.AddEachOrder(order, shipping,
                    UserGetter.GetTransactionByOrderID(order.OwnerID, order.TotalValue, shipping.Fee));
            OrdersPanel.getChildren().add(parent);
        }
    }
}
