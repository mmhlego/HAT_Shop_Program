package Manager.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import Customer.Controller.ProductInformationPage;
import DataController.ProductChecker;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EachCustomerEachProduct implements Initializable {

	@FXML
	private ImageView ProductIMG;

	@FXML
	private Button SeeProductBTN;

	@FXML
	private Label TotalPriceLBL;

	@FXML
	private Label BasePriceLBL;

	@FXML
	private Label PercentageLBL;

	@FXML
	private Label ProductIDLBL;

	@FXML
	private Label ProductNameLBL;

	@FXML
	private Label ProductCategoryLBL;

	@FXML
	private Label AmountLBL;
	private boolean special = false;
	ArrayList<Product> SpecialProduct = new ArrayList<>();

	public void LoadProduct(Product p, int amount) throws Exception {
		for (Product spProduct : SpecialProduct) {
			if (p.ID.equals(spProduct.ID)) {

				special = true;
			}
		}
		Image image;
		if (new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg").exists()) {
			image = new Image(
					new FileInputStream(new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg")));
		} else {
			image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
		}
		AmountLBL.setText(String.valueOf(amount));
		BasePriceLBL.setText(String.valueOf(p.Price));
		PercentageLBL.setText(String.valueOf(p.Percentage) + " %");
		ProductCategoryLBL.setText(p.Category);
		ProductIDLBL.setText(p.ID);
		ProductIMG.setImage(image);
		ProductNameLBL.setText(p.Name);
		TotalPriceLBL.setText(String.valueOf(Product.getTotalValue(p, amount)));
		SeeProductBTN.setOnAction(e -> {
			buyPage(p, image);
		});

	}

	private void buyPage(Product product, Image image) {

		ProductInformationPage.p = product;
		ProductInformationPage c = (ProductInformationPage) MainStructure
				.addPage("src/Customer/Visual/ProductInformationPage.fxml");
		c.buyPage(product, image, special);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SpecialProduct = ProductChecker.GetSpecialProducts();

	}

}
