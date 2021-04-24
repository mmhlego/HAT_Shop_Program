package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSlider;
import CommonPages.Controllers.MainStructure;
import DataController.ProductChecker;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
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
	@FXML
	private JFXCheckBox OnlyAmazingToggle;

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
		ArrayList<Product> products = filter();
		ArrayList<Product> searchResult = new ArrayList<>();
		String searchText = SearchTXF.getText();
		if (searchText.isEmpty()) {
			addProducts(filter());
		} else {
			for (Product product : products) {
				if (product.Name.contains(searchText) || product.Description.contains(searchText)
						|| product.Category.contains(searchText)) {
					searchResult.add(product);
				}
			}
			addProducts(searchResult);
		}

	}

	int size = ProductChecker.LoadAllProducts().size();

	private ArrayList<Product> filter() {
		ArrayList<Product> products = ProductChecker.LoadAllProducts();
		ArrayList<Product> filteredProducts = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Product product = products.get(i);
			// if (OnlyAvailableToggle.isSelected()) {
			if (product.Amount >= 0 || !OnlyAvailableToggle.isSelected()) {
				switch (product.Category) {
				case Product.ACCESSORIES:
					if (AccessoriesCategoryToggle.isSelected()) {
						filteredProducts.add(product);
					}
					break;
				case Product.BOOK:
					if (BookCategoryToggle.isSelected()) {
						filteredProducts.add(product);
					}
					break;
				case Product.COMPUTER:
					if (ComputerCategoryToggle.isSelected()) {
						filteredProducts.add(product);
					}
					break;
				case Product.PHONE:
					if (PhoneCategoryToggle.isSelected()) {
						filteredProducts.add(product);
						System.out.println("ProductsViewer.filter()");
					}
					break;
				case Product.SUPERMARKET:
					if (SuperMarketCategoryToggle.isSelected()) {
						filteredProducts.add(product);
					}
					break;

				}
			}

			// }

		}

		addProducts(filteredProducts);
		search();
		return filteredProducts;
	}

	private void addProducts(ArrayList<Product> products) {
		System.out.println(products.size());
		try {
			int i = 0;
			ProductsPanel.getChildren().clear();
			ProductsPanel.setPrefHeight(((double) ((int) (i / 3)) * 275));
			for (Product product : products) {
				if (!product.equals(new Product())) {

					FXMLLoader loader = new FXMLLoader(
							this.getClass().getResource("../Components/ProductSmallView.fxml"));
					;
					Parent p = loader.load();
					ProductSmallView s = loader.getController();
					AnchorPane.setTopAnchor(p, ((double) ((int) (i / 3)) * 275));
					AnchorPane.setLeftAnchor(p, ((double) (i % 3) * 239 + 14));

					Image image;

					/*
					 * try { image = new Image(new FileInputStream(new File(
					 * "src/pictures/Product Images/" + product.Category + "/" + product.Name +
					 * ".jpg"))); } catch (FileNotFoundException e) { System.out.println(
					 * "Cannot find Product Images/" + product.Category + "/" + product.Name +
					 * ".jpg");
					 * 
					 * image = new Image(new FileInputStream(new
					 * File("src/pictures/Product Images/Product.png"))); }
					 */

					if (new File("src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")
							.exists()) {
						image = new Image(new FileInputStream(new File(
								"src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")));
					} else {
						image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
					}

					s.getProductImage().setImage(image);
					s.getProductName().setText(product.Name);
					s.getProductPrice().setText(String.valueOf(product.Price));
					p.setOnMouseClicked(e -> buyPage(product, image));
					ProductSmallView smallView = loader.getController();
					smallView.getBuyButton().setOnAction(e -> buyPage(product, image));
					ProductsPanel.getChildren().add(p);
					ProductsPanel.setPrefHeight(((double) ((int) (i / 3)) * 275));
				}
				i++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void buyPage(Product p, Image image) {
		ProductInformationPage c = (ProductInformationPage) MainStructure
				.addPage("src/Customer/Visual/ProductInformationPage.fxml");
		c.getBuyBTN().setOnAction(e -> {
			c.getBuyBTN().setVisible(false);
			c.getAddToCartGroup().setVisible(true);
		});
		c.getProductCategoryLBL().setText(p.Category);
		c.getProductDescriptionTXT().setText(p.Description);
		c.getProductIDLBL().setText(p.ID);
		c.getProductIMG().setImage(image);
		c.getProductNameLBL().setText(p.Name);
		c.getProductPriceLBL().setText(String.valueOf(p.Price));
		ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();
		for (int j = 0; j < p.Details.length; j++) {
			Map<String, Object> item = new HashMap<>();
			item.put("firstrow", p.Details[j][0]);
			item.put("secondrow", p.Details[j][1]);
			items.add(item);
		}
		c.getMColumn().setCellValueFactory(new MapValueFactory<String>("firstrow"));
		c.getInformationColumn().setCellValueFactory(new MapValueFactory<String>("secondrow"));
		c.getProductDetailsTable().setItems(items);

	}

}
