package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Order;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Cart implements Initializable {
	@FXML
	private VBox ProductsListPanel;
	@FXML
	private Button FinalizeOrderBTN;
	@FXML
	private Label SumOfDiscountsLBL;
	@FXML
	private Label SumOfPricesLBL;
	@FXML
	private Label FinalPriceLBL;
	@FXML
	private Label ShippingDateLBL;
	@FXML
	private Label ShippingFeeLBL;

	ArrayList<Order> Orders;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void addOrders() throws Exception {
		for (Order order : Orders) {
			for (Product p : order.Products) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../Component/CartEachProduct.fxml"));
				Parent parent = loader.load();
				CartEachProduct controller = loader.getController();
				controller.getAmountLBL().setText(String.valueOf(p.Amount));
				controller.getBasePriceLBL().setText(String.valueOf(p.Price));
				controller.getPercentageLBL().setText(String.valueOf(p.Percentage) + " %");
				controller.getProductCategoryLBL().setText(p.Category);
				controller.getProductIDLBL().setText(p.ID);
				Image image;
				if (new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg").exists()) {
					image = new Image(new FileInputStream(
							new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg")));
				} else {
					image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
				}
				controller.getProductIMG().setImage(image);
				controller.getProductNameLBL().setText(p.Name);
				controller.getTotalPriceLBL().setText(String.valueOf(Product.getTotalValue(p, p.Amount)));
				ProductsListPanel.getChildren().add(parent);
			}
		}

	}

}