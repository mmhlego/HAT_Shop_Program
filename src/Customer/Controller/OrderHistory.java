package Customer.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import Controller.UserController;
import Model.Order;
import Model.Order.OrderStatus;
import Model.Shipping;
import Model.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class OrderHistory implements Initializable {
	@FXML
	private VBox OrdersPanel;
	ArrayList<Order> allOrders = new ArrayList<>();
	ArrayList<Shipping> allShippings = new ArrayList<>();
	ArrayList<Transaction> allTransactions = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		allOrders = UserController.AllOrders;
		allShippings = UserController.AllShippings;
		allTransactions = UserController.AllTransactions;
		System.out.println(allOrders.size());
		System.out.println(allShippings.size());
		System.out.println(allTransactions.size());
		try {
			AddOrdersToPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int i;

	private void AddOrdersToPage() throws Exception {
		i = 0;
		for (Order order : allOrders) {
			Shipping shipping = allShippings.get(i);
			Transaction transaction = allTransactions.get(i);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/HistoryEachOrderDetails.fxml"));
			Parent parent = loader.load();
			HistoryEachOrderDetails c = loader.getController();
			c.getOrderID().setText(order.OrderID);
			c.getShippingDateLBL().setText(shipping.Date.toString());
			c.getShippingFeeLBL().setText(String.valueOf(shipping.Fee));
			c.getShippingIDLBL().setText(shipping.ID);
			if (order.Status.equals(OrderStatus.SENDING)) {
				c.getStatusSendingLBL().setVisible(true);
			} else {
				c.getStatusFinishedLBL().setVisible(true);
			}
			c.getTransactionDateLBL().setText(transaction.Date.toString());
			c.getTransactionIDLBL().setText(transaction.ID);
			c.getTransactionTotalPriceLBL().setText(String.valueOf(transaction.Amount));
			c.getViewProducts().setOnAction(e -> {
				HistoryAllProducts.OrdersProduct = order.Products;
				HistoryAllProducts.OrderAmounts = order.Amounts;
				MainStructure.addPage("src/Customer/Components/HistoryAllProducts.fxml");
			});
			OrdersPanel.getChildren().add(parent);
			i++;
		}

	}
}
