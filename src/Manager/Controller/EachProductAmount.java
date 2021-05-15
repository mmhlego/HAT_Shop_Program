package Manager.Controller;

import Model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EachProductAmount {
	@FXML
	private Label ProductAmountLBL;
	@FXML
	private Label ProductNameLBL;

	public Label getProductAmountLBL() {
		return ProductAmountLBL;
	}

	public void setProductAmountLBL(Label productAmountLBL) {
		ProductAmountLBL = productAmountLBL;
	}

	public Label getProductNameLBL() {
		return ProductNameLBL;
	}

	public void setProductNameLBL(Label productNameLBL) {
		ProductNameLBL = productNameLBL;
	}

	public void ShowProductAmount(Product p) {
		ProductAmountLBL.setText(String.valueOf(p.Amount));
		ProductNameLBL.setText(p.Name);
	}
}
