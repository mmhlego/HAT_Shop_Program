package Manager.Controller;

import java.io.File;
import java.io.FileInputStream;

import CommonPages.Controllers.MainStructure;
import Model.Product;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EachProduct {
	@FXML
	private ImageView ProductIMG;
	@FXML
	private Group SeeProductBTN;
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

	public void AddProduct(Product p) throws Exception {
		Image image;
		if (new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg").exists()) {
			image = new Image(
					new FileInputStream(new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg")));
		} else {
			image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
		}
		ProductIMG.setImage(image);
		BasePriceLBL.setText(String.valueOf(p.Price));
		PercentageLBL.setText(String.valueOf(p.Percentage) + " %");
		ProductIDLBL.setText(p.ID);
		ProductNameLBL.setText(p.Name);
		ProductCategoryLBL.setText(p.Category);
		AmountLBL.setText(String.valueOf(p.Amount));

		SeeProductBTN.setOnMouseClicked(e -> {
			ProductEditInformation c = (ProductEditInformation) MainStructure
					.addPage("src/Manager/Visual/ProductEditInformation.fxml");
			c.ShowProductInfo(p, image, special);
		});
	}
}
