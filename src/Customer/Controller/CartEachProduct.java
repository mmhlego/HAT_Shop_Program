package Customer.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class CartEachProduct {

	@FXML
	private ImageView ProductIMG;

	@FXML
	private Button SeeProductBTN;

	@FXML
	private Button DeleteProductBTN;

	@FXML
	private Label TotalPriceLBL;

	@FXML
	private Label BasePriceLBL;

	@FXML
	private Label PercentageLBL;

	@FXML
	private Button IncreaseAmountBTN;

	@FXML
	private Label AmountLBL;

	@FXML
	private Button DecreaseAmountBTN;

	@FXML
	private Label ProductIDLBL;

	@FXML
	private Label ProductNameLBL;

	@FXML
	private Label ProductCategoryLBL;

	public ImageView getProductIMG() {
		return ProductIMG;
	}

	public void setProductIMG(ImageView productIMG) {
		ProductIMG = productIMG;
	}

	public Button getSeeProductBTN() {
		return SeeProductBTN;
	}

	public void setSeeProductBTN(Button seeProductBTN) {
		SeeProductBTN = seeProductBTN;
	}

	public Button getDeleteProductBTN() {
		return DeleteProductBTN;
	}

	public void setDeleteProductBTN(Button deleteProductBTN) {
		DeleteProductBTN = deleteProductBTN;
	}

	public Label getTotalPriceLBL() {
		return TotalPriceLBL;
	}

	public void setTotalPriceLBL(Label totalPriceLBL) {
		TotalPriceLBL = totalPriceLBL;
	}

	public Label getBasePriceLBL() {
		return BasePriceLBL;
	}

	public void setBasePriceLBL(Label basePriceLBL) {
		BasePriceLBL = basePriceLBL;
	}

	public Label getPercentageLBL() {
		return PercentageLBL;
	}

	public void setPercentageLBL(Label percentageLBL) {
		PercentageLBL = percentageLBL;
	}

	public Button getIncreaseAmountBTN() {
		return IncreaseAmountBTN;
	}

	public void setIncreaseAmountBTN(Button increaseAmountBTN) {
		IncreaseAmountBTN = increaseAmountBTN;
	}

	public Label getAmountLBL() {
		return AmountLBL;
	}

	public void setAmountLBL(Label amountLBL) {
		AmountLBL = amountLBL;
	}

	public Button getDecreaseAmountBTN() {
		return DecreaseAmountBTN;
	}

	public void setDecreaseAmountBTN(Button decreaseAmountBTN) {
		DecreaseAmountBTN = decreaseAmountBTN;
	}

	public Label getProductIDLBL() {
		return ProductIDLBL;
	}

	public void setProductIDLBL(Label productIDLBL) {
		ProductIDLBL = productIDLBL;
	}

	public Label getProductNameLBL() {
		return ProductNameLBL;
	}

	public void setProductNameLBL(Label productNameLBL) {
		ProductNameLBL = productNameLBL;
	}

	public Label getProductCategoryLBL() {
		return ProductCategoryLBL;
	}

	public void setProductCategoryLBL(Label productCategoryLBL) {
		ProductCategoryLBL = productCategoryLBL;
	}

}
