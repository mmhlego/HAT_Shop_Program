package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSlider;

import DataController.ProductChecker;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class ProductsViewer implements Initializable {
	@FXML
	private AnchorPane ProductsPanel;
	@FXML
	private TextField SearchTXF;
	@FXML
	private Button SearchBTN;
	@FXML
	private JFXCheckBox PhoneCategoryToggle;
	@FXML
	private JFXCheckBox AccessoriesCategoryToggle;
	@FXML
	private JFXCheckBox ComputerCategoryToggle;
	@FXML
	private JFXCheckBox BookCategoryToggle;
	@FXML
	private JFXCheckBox SuperMarketCategoryToggle;
	@FXML
	private JFXCheckBox OnlyAvailableToggle;
	@FXML
	private Button FilterBTN;
	@FXML
	private JFXSlider MaxPriceSlider;
	@FXML
	private Label MaxPriceLBL;

	public AnchorPane getProductsPanel() {
		return ProductsPanel;
	}

	public void setProductsPanel(AnchorPane productsPanel) {
		ProductsPanel = productsPanel;
	}

	public TextField getSearchTXF() {
		return SearchTXF;
	}

	public void setSearchTXF(TextField searchTXF) {
		SearchTXF = searchTXF;
	}

	public Button getSearchBTN() {
		return SearchBTN;
	}

	public void setSearchBTN(Button searchBTN) {
		SearchBTN = searchBTN;
	}

	public JFXCheckBox getPhoneCategoryToggle() {
		return PhoneCategoryToggle;
	}

	public void setPhoneCategoryToggle(JFXCheckBox phoneCategoryToggle) {
		PhoneCategoryToggle = phoneCategoryToggle;
	}

	public JFXCheckBox getAccessoriesCategoryToggle() {
		return AccessoriesCategoryToggle;
	}

	public void setAccessoriesCategoryToggle(JFXCheckBox accessoriesCategoryToggle) {
		AccessoriesCategoryToggle = accessoriesCategoryToggle;
	}

	public JFXCheckBox getComputerCategoryToggle() {
		return ComputerCategoryToggle;
	}

	public void setComputerCategoryToggle(JFXCheckBox computerCategoryToggle) {
		ComputerCategoryToggle = computerCategoryToggle;
	}

	public JFXCheckBox getBookCategoryToggle() {
		return BookCategoryToggle;
	}

	public void setBookCategoryToggle(JFXCheckBox bookCategoryToggle) {
		BookCategoryToggle = bookCategoryToggle;
	}

	public JFXCheckBox getSuperMarketCategoryToggle() {
		return SuperMarketCategoryToggle;
	}

	public void setSuperMarketCategoryToggle(JFXCheckBox superMarketCategoryToggle) {
		SuperMarketCategoryToggle = superMarketCategoryToggle;
	}

	public JFXCheckBox getOnlyAvailableToggle() {
		return OnlyAvailableToggle;
	}

	public void setOnlyAvailableToggle(JFXCheckBox onlyAvailableToggle) {
		OnlyAvailableToggle = onlyAvailableToggle;
	}

	public Button getFilterBTN() {
		return FilterBTN;
	}

	public void setFilterBTN(Button filterBTN) {
		FilterBTN = filterBTN;
	}

	public JFXSlider getMaxPriceSlider() {
		return MaxPriceSlider;
	}

	public void setMaxPriceSlider(JFXSlider maxPriceSlider) {
		MaxPriceSlider = maxPriceSlider;
	}

	public Label getMaxPriceLBL() {
		return MaxPriceLBL;
	}

	public void setMaxPriceLBL(Label maxPriceLBL) {
		MaxPriceLBL = maxPriceLBL;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<Product> products = ProductChecker.LoadAllProducts();
		addProducts(products);
		FilterBTN.setOnAction(e -> filter());
		SearchBTN.setOnAction(e -> search());

	}

	private void search() {
		ArrayList<Product> products = ProductChecker.LoadAllProducts();
		ArrayList<Product> searchResult = new ArrayList<>();
		String searchText = SearchTXF.getText();
		if (searchText.isEmpty()) {
			addProducts(ProductChecker.LoadAllProducts());
		} else {
			for (Product product : products) {
				if (product.Name.contains(searchText) || product.Description.contains(searchText)
						|| product.Category.contains(searchText)) {
					searchResult.add(product);
				}
			}
			addProducts(searchResult);
		}
		filter();

	}

	int size = ProductChecker.LoadAllProducts().size();

	private void filter() {
		ArrayList<Product> products = ProductChecker.LoadAllProducts();
		for (int i = 0; i < size; i++) {
			Product product = products.get(i);
			if (!BookCategoryToggle.isSelected()) {
				if (product.Category.equals(Product.BOOK)) {
					System.out.println(products.size());
					product = new Product();
				}
			}
			if (!ComputerCategoryToggle.isSelected()) {
				if (product.Category.equals(Product.COMPUTER)) {
					System.out.println(products.size());
					product = new Product();
				}
			}
			if (!AccessoriesCategoryToggle.isSelected()) {
				if (product.Category.equals(Product.ACCESSORIES)) {
					System.out.println(products.size());
					product = new Product();
				}
			}
			if (!PhoneCategoryToggle.isSelected()) {
				if (product.Category.equals(Product.PHONE)) {
					System.out.println(products.size());
					product = new Product();
				}
			}
			if (!SuperMarketCategoryToggle.isSelected()) {
				System.out.println(products.size());
				if (product.Category.equals(Product.SUPERMARKET)) {
					product = new Product();
				}
			}

			if (OnlyAvailableToggle.isSelected()) {
				System.out.println(products.size());
				if (product.Amount <= 0) {
					product = new Product();
				}
			}
			System.out.println("ProductsViewer.filter()");

			/*
			 * if (product.Amount>Double.parseDouble(MaxPriceLBL.getText())) {
			 * products.remove(product); }
			 */

		}
		addProducts(products);
	}

	private void addProducts(ArrayList<Product> products) {
		try {
			int i = 0;
			ProductsPanel.getChildren().clear();
			for (Product product : products) {
				if (!product.equals(new Product())) {

					FXMLLoader loader = new FXMLLoader(
							this.getClass().getResource("../Components/ProductSmallView.fxml"));
					;
					Parent p = loader.load();
					ProductSmallView s = loader.getController();
					AnchorPane.setTopAnchor(p, ((double) ((int) (i / 3)) * 275));
					AnchorPane.setLeftAnchor(p, ((double) (i % 3) * 239 + 14));
					try {
						s.getProductImage().setImage(new Image(new FileInputStream(new File(
								"src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg"))));
					} catch (FileNotFoundException e) {

					}
					s.getProductName().setText(product.Name);
					s.getProductPrice().setText(String.valueOf(product.Price));
					ProductsPanel.getChildren().add(p);
					ProductsPanel.setPrefHeight(((double) ((int) (i / 3)) * 275));
				}
				i++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
