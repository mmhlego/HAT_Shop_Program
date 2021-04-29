package Manager.Controller;

import java.util.ArrayList;

import Model.Order;
import Model.Order.OrderStatus;
import Model.Product;
import Model.Shipping;
import Model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoryEachHistoryOrder {

	@FXML
	private Label ShippingFeeLBL;

	@FXML
	private Label ShippingDateLBL;

	@FXML
	private Label ShippingIDLBL;

	@FXML
	private Label TransactionTotalPriceLBL;

	@FXML
	private Label TransactionDateLBL;

	@FXML
	private Label TransactionIDLBL;

	@FXML
	private Label OrderID;

	@FXML
	private Label StatusFinishedLBL;

	@FXML
	private Label StatusSendingLBL;
	ArrayList<Product> EachOrderProducts = new ArrayList<>();
	ArrayList<Integer> EachOrderAmounts = new ArrayList<>();

	public void AddEachOrder(Order o, Shipping s, Transaction t) {
		EachOrderAmounts = o.Amounts;
		EachOrderProducts = o.Products;

		ShippingFeeLBL.setText(String.valueOf(s.Fee));
		ShippingDateLBL.setText(s.Date.toString());
		ShippingIDLBL.setText(s.ID);
		TransactionTotalPriceLBL.setText(String.valueOf(t.Amount));/////////////////////////// ?????????????
		TransactionDateLBL.setText(t.Date.toString());
		TransactionIDLBL.setText(t.ID);
		if (o.Status.equals(OrderStatus.FINISHED)) {
			StatusFinishedLBL.setVisible(true);
		} else if (o.Status.equals(OrderStatus.SENDING)) {
			StatusSendingLBL.setVisible(true);
		}

	}

}
