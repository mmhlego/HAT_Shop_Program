package Customer.Controller;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoryEachOrderDetails {
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
	@FXML
	private JFXButton viewProducts;

	public JFXButton getViewProducts() {
		return viewProducts;
	}

	public void setViewProducts(JFXButton viewProducts) {
		this.viewProducts = viewProducts;
	}

	public Label getShippingFeeLBL() {
		return ShippingFeeLBL;
	}

	public void setShippingFeeLBL(Label shippingFeeLBL) {
		ShippingFeeLBL = shippingFeeLBL;
	}

	public Label getShippingDateLBL() {
		return ShippingDateLBL;
	}

	public void setShippingDateLBL(Label shippingDateLBL) {
		ShippingDateLBL = shippingDateLBL;
	}

	public Label getShippingIDLBL() {
		return ShippingIDLBL;
	}

	public void setShippingIDLBL(Label shippingIDLBL) {
		ShippingIDLBL = shippingIDLBL;
	}

	public Label getTransactionTotalPriceLBL() {
		return TransactionTotalPriceLBL;
	}

	public void setTransactionTotalPriceLBL(Label transactionTotalPriceLBL) {
		TransactionTotalPriceLBL = transactionTotalPriceLBL;
	}

	public Label getTransactionDateLBL() {
		return TransactionDateLBL;
	}

	public void setTransactionDateLBL(Label transactionDateLBL) {
		TransactionDateLBL = transactionDateLBL;
	}

	public Label getTransactionIDLBL() {
		return TransactionIDLBL;
	}

	public void setTransactionIDLBL(Label transactionIDLBL) {
		TransactionIDLBL = transactionIDLBL;
	}

	public Label getOrderID() {
		return OrderID;
	}

	public void setOrderID(Label orderID) {
		OrderID = orderID;
	}

	public Label getStatusFinishedLBL() {
		return StatusFinishedLBL;
	}

	public void setStatusFinishedLBL(Label statusFinishedLBL) {
		StatusFinishedLBL = statusFinishedLBL;
	}

	public Label getStatusSendingLBL() {
		return StatusSendingLBL;
	}

	public void setStatusSendingLBL(Label statusSendingLBL) {
		StatusSendingLBL = statusSendingLBL;
	}

}
