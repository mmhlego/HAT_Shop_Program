package Manager.Controller;

import Model.Shipping;
import Model.Shipping.ShippingMode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EachShipping {

	@FXML
	private Label ShippingStatusLBL;

	@FXML
	private Label ShippingFeeLBL;

	@FXML
	private Label ShippingOrderIDLBL;

	@FXML
	private Label ShippingIDLBL;

	@FXML
	private Label ShippingDateLBL;

	public Label getShippingStatusLBL() {
		return ShippingStatusLBL;
	}

	public void setShippingStatusLBL(Label shippingStatusLBL) {
		ShippingStatusLBL = shippingStatusLBL;
	}

	public Label getShippingFeeLBL() {
		return ShippingFeeLBL;
	}

	public void setShippingFeeLBL(Label shippingFeeLBL) {
		ShippingFeeLBL = shippingFeeLBL;
	}

	public Label getShippingOrderIDLBL() {
		return ShippingOrderIDLBL;
	}

	public void setShippingOrderIDLBL(Label shippingOrderIDLBL) {
		ShippingOrderIDLBL = shippingOrderIDLBL;
	}

	public Label getShippingIDLBL() {
		return ShippingIDLBL;
	}

	public void setShippingIDLBL(Label shippingIDLBL) {
		ShippingIDLBL = shippingIDLBL;
	}

	public Label getShippingDateLBL() {
		return ShippingDateLBL;
	}

	public void setShippingDateLBL(Label shippingDateLBL) {
		ShippingDateLBL = shippingDateLBL;
	}

	public void ShowShipping(Shipping s) {
		ShippingDateLBL.setText(s.Date.toString());
		ShippingFeeLBL.setText(String.valueOf(s.Fee));
		ShippingIDLBL.setText(s.ID);
		ShippingOrderIDLBL.setText(s.OrderId);
		ShippingStatusLBL.setText(String.valueOf(ShippingMode.IntToMode(s.Status)));

	}

}
