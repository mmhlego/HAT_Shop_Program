package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
	private boolean special = false;

	ArrayList<Product> AllProducts, FilteredProducts = new ArrayList<Product>(),
			ShowingProducts = new ArrayList<Product>(), SpecialProduct = new ArrayList<>();

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

	public JFXCheckBox getOnlyAmazingToggle() {
		return OnlyAmazingToggle;
	}

	public void setOnlyAmazingToggle(JFXCheckBox onlyAmazingToggle) {
		OnlyAmazingToggle = onlyAmazingToggle;
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
		MaxPriceSlider.setMin(ProductChecker.GetMinValue() / 10000);
		MaxPriceSlider.setMax(ProductChecker.GetMaxValue() / 10000);
		MaxPriceSlider.setValue(ProductChecker.GetMaxValue() / 10000);
		MaxPriceLBL.setText(String.valueOf((long) MaxPriceSlider.getValue() * 10000) + " تومان");
		MaxPriceSlider.setOnMouseDragged(e -> {
			MaxPriceLBL.setText(String.valueOf((long) MaxPriceSlider.getValue() * 10000) + " تومان");
		});
		MaxPriceSlider.setOnMouseClicked(e -> {
			MaxPriceLBL.setText(String.valueOf((long) MaxPriceSlider.getValue() * 10000) + " تومان");
		});
		AllProducts = ProductChecker.LoadAllProducts();
		SpecialProduct = ProductChecker.GetSpecialProducts();
		addProducts(AllProducts);

		FilterBTN.setOnAction(e -> filter());
		SearchBTN.setOnAction(e -> filter());
	}

	private void addProducts(ArrayList<Product> products) {
		System.out.println("Showing " + products.size() + " products");
		try {
			int i = 0;
			ProductsPanel.getChildren().clear();
			ProductsPanel.setPrefHeight(((double) ((int) (i / 3)) * 275));
			for (Product product : products) {
				if (!product.equals(new Product())) {
					FXMLLoader loader = new FXMLLoader(
							this.getClass().getResource("../Components/ProductSmallView.fxml"));
					Parent p = loader.load();
					ProductSmallView controller = loader.getController();

					AnchorPane.setTopAnchor(p, ((double) ((int) (i / 3)) * 275));
					AnchorPane.setRightAnchor(p, ((double) (i % 3) * 239 + 34));

					Image image;
					if (new File("src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")
							.exists()) {
						image = new Image(new FileInputStream(new File(
								"src/pictures/Product Images/" + product.Category + "/" + product.Name + ".jpg")));
					} else {
						image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
					}

					controller.getProductImage().setImage(image);
					controller.getProductName().setText(product.Name);
					controller.getProductPrice().setText(String.valueOf(product.Price));
					p.setOnMouseClicked(e -> buyPage(product, image));
					controller.getBuyButton().setOnAction(e -> buyPage(product, image));
					for (Product spProduct : SpecialProduct) {
						if (product.equals(spProduct)) {
							controller.getSpecialEvents().setText("کالای شگفت انگیز");
							controller.getSpecialEvents().setVisible(true);
							special = true;
						}
					}
					ProductsPanel.getChildren().add(p);
					ProductsPanel.setPrefHeight(((double) ((int) ((i + 3) / 3)) * 275));
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void search() {
		ShowingProducts.clear();

		String searchText = SearchTXF.getText().toLowerCase();

		for (Product product : FilteredProducts) {
			if (product.Name.toLowerCase().contains(searchText)
					|| product.Description.toLowerCase().contains(searchText)) {
				ShowingProducts.add(product);
			}
		}

		addProducts(ShowingProducts);
	}

	public void filter() {
		FilteredProducts.clear();
		int size = (!OnlyAmazingToggle.isSelected()) ? AllProducts.size() : SpecialProduct.size();

		for (int i = 0; i < size; i++) {
			Product product = (!OnlyAmazingToggle.isSelected()) ? AllProducts.get(i) : SpecialProduct.get(i);

			if (product.Price <= (MaxPriceSlider.getValue() * 10000)) {

				if (product.Amount >= 0 || !OnlyAvailableToggle.isSelected()) {
					switch (product.Category) {
					case Product.ACCESSORIES:
						if (AccessoriesCategoryToggle.isSelected()) {
							FilteredProducts.add(product);
						}
						break;
					case Product.BOOK:
						if (BookCategoryToggle.isSelected()) {
							FilteredProducts.add(product);
						}
						break;
					case Product.COMPUTER:
						if (ComputerCategoryToggle.isSelected()) {
							FilteredProducts.add(product);
						}
						break;
					case Product.PHONE:
						if (PhoneCategoryToggle.isSelected()) {
							FilteredProducts.add(product);
						}
						break;
					case Product.SUPERMARKET:
						if (SuperMarketCategoryToggle.isSelected()) {
							FilteredProducts.add(product);
						}
						break;
					}
				}
			}
		}

		search();
	}

	public void buyPage(Product p, Image image) {
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
		c.getSpecialTXT().setVisible(false);
		showSpecialProduct(c.getSimilarProductsAnchor());
		if (special) {
			c.getSpecialTXT().setVisible(true);
		}
		c.getLoadMoreBTN().toFront();
		c.getLoadMoreBTN().setOnAction(e -> {
			ProductsViewer controller = (ProductsViewer) MainStructure
					.addPage("src/Customer/Visual/ProductsViewer.fxml");
			controller.getOnlyAmazingToggle().selectedProperty().setValue(true);
			controller.filter();
		});
	}

	Random random = new Random();

	private void showSpecialProduct(AnchorPane pane) {
		ArrayList<Product> specialProduct = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			specialProduct.add(ProductChecker.GetSpecialProducts()
					.get(random.nextInt(ProductChecker.GetSpecialProducts().size())));
		}
		int i = 0;
		for (Product product : specialProduct) {
			try {
				if (!product.equals(new Product())) {

					FXMLLoader loader = new FXMLLoader(
							this.getClass().getResource("../Components/ProductSmallView.fxml"));

					Parent p = loader.load();
					ProductSmallView s = loader.getController();
					AnchorPane.setTopAnchor(p, ((double) 25));
					AnchorPane.setLeftAnchor(p, ((double) (i) * 225 + 25 - 120));

					Image image;
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
					s.getSpecialEvents().setText("کالای شگفت انگیز");
					s.getSpecialEvents().setVisible(true);
					p.setOnMouseClicked(e -> buyPage(product, image));
					ProductSmallView smallView = loader.getController();
					smallView.getBuyButton().setOnAction(e -> buyPage(product, image));
					pane.getChildren().add(p);

				}
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
