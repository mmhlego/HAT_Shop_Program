package Customer.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import CommonPages.Controllers.MainStructure;
import Controller.UserController;
import DataController.*;
import Model.*;
import Model.Order.OrderStatus;

import java.io.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class Cart implements Initializable {
	@FXML
	private VBox ProductsListPanel;
	@FXML
	private Button PayOrderFromPaymentBTN;
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
	@FXML
	private Button PayOrderFromValueBTN;

	private boolean special = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			if (UserController.Cart.equals(null) || UserController.Cart.Products.size() == 0) {
				addEmptyPage();
			} else {
				addOrder();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		PayOrderFromPaymentBTN.setOnAction((e) -> {
			Payment.FinalPrice = FinalPriceLBL.getText();
			Payment.ShippingDate = ShippingDateLBL.getText();
			Payment.ShippingFee = ShippingFeeLBL.getText();

			DBConnector.stage.hide();
			try {
				FXMLLoader loader = new FXMLLoader(new File("src/Customer/Visual/Payment.fxml").toURI().toURL());

				Scene scene = new Scene(loader.load());
				scene.setFill(Color.TRANSPARENT);
				Stage stage = new Stage(StageStyle.TRANSPARENT);
				stage.setScene(scene);
				stage.show();
				Payment.TransactionMode = true;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		PayOrderFromValueBTN.setOnAction((e) -> {
			UserUpdator.UpdateValue(UserController.customer.Username, -Long.parseLong(FinalPriceLBL.getText()));
			UserController.Cart.Status = OrderStatus.SENDING;
			DataUpdator.UpdateOrderStatus(UserController.Cart);
			DataAdder.AddShipping(UserController.Cart.OrderID, 0, Long.parseLong(ShippingFeeLBL.getText()),
					LocalDate.parse(ShippingDateLBL.getText()), Shipping.GenerateID());
			DataAdder.AddTransaction(UserController.Cart.OwnerID, Long.parseLong(FinalPriceLBL.getText()),
					LocalDate.parse(ShippingDateLBL.getText()), Transaction.GenerateID());
			DataAdder.AddOrder(new Order(UserController.customer.ID, Order.GenerateID(), OrderStatus.PENDING));
			UserController.LoadUserFullData();
		});
	}

	int i = 0;

	private void addOrder() throws Exception {
		long finalPrice = 0;
		long basePrice = 0;
		int fees = 0;
		System.out.println(UserController.Cart.Products.size());
		i = 0;
		for (Product p : UserController.Cart.Products) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/CartEachProduct.fxml"));
			Parent parent = loader.load();
			CartEachProduct controller = loader.getController();
			controller.getAmountLBL().setText(String.valueOf(UserController.Cart.Amounts.get(i)));
			controller.getBasePriceLBL().setText(String.valueOf(p.Price));
			controller.getPercentageLBL().setText(String.valueOf(p.Percentage) + " %");
			controller.getProductCategoryLBL().setText(p.Category);
			controller.getProductIDLBL().setText(p.ID);
			checkAmount(Integer.parseInt(controller.getAmountLBL().getText()), p.Amount,
					controller.getDecreaseAmountBTN(), controller.getIncreaseAmountBTN());
			Image image;
			if (new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg").exists()) {
				image = new Image(new FileInputStream(
						new File("src/pictures/Product Images/" + p.Category + "/" + p.Name + ".jpg")));
			} else {
				image = new Image(new FileInputStream(new File("src/pictures/Product Images/Product.png")));
			}
			controller.getProductIMG().setImage(image);
			controller.getProductNameLBL().setText(p.Name);
			controller.getTotalPriceLBL()
					.setText(String.valueOf(Product.getTotalValue(p, UserController.Cart.Amounts.get(i))));
			controller.getSeeProductBTN().setOnAction(e -> buyPage(p, image));

			controller.getDeleteProductBTN().setOnAction(e -> {
				try {
					UserController.Cart.Amounts.remove(UserController.Cart.Products.indexOf(p));
					UserController.Cart.Products.remove(p);

					ProductsListPanel.getChildren().clear();
					if (UserController.Cart.Products.size() == 0) {
						addEmptyPage();
					} else {
						addOrder();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			});
			controller.getIncreaseAmountBTN().setOnAction(e -> {
				controller.getAmountLBL()
						.setText(String.valueOf(Integer.parseInt(controller.getAmountLBL().getText()) + 1));
				checkAmount(Integer.parseInt(controller.getAmountLBL().getText()), p.Amount,
						controller.getDecreaseAmountBTN(), controller.getIncreaseAmountBTN());
				UserController.Cart.Amounts.set(UserController.Cart.Products.indexOf(p),
						Integer.parseInt(controller.getAmountLBL().getText()));
				UserController.Cart.Amounts.set(UserController.Cart.Products.indexOf(p),
						Integer.parseInt(controller.getAmountLBL().getText()));

				ProductsListPanel.getChildren().clear();
				try {
					addOrder();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			});
			controller.getDecreaseAmountBTN().setOnAction(e -> {
				controller.getAmountLBL()
						.setText(String.valueOf(Integer.parseInt(controller.getAmountLBL().getText()) - 1));
				checkAmount(Integer.parseInt(controller.getAmountLBL().getText()), p.Amount,
						controller.getDecreaseAmountBTN(), controller.getIncreaseAmountBTN());
				UserController.Cart.Amounts.set(UserController.Cart.Products.indexOf(p),
						Integer.parseInt(controller.getAmountLBL().getText()));
				UserController.Cart.Amounts.set(UserController.Cart.Products.indexOf(p),
						Integer.parseInt(controller.getAmountLBL().getText()));

				ProductsListPanel.getChildren().clear();
				try {
					addOrder();

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			});
			fees += Shipping.generateFee(UserController.Cart.Amounts.get(i), UserController.customer.Mode);
			basePrice += p.Price;
			finalPrice += Product.getTotalValue(p, UserController.Cart.Amounts.get(i));
			ProductsListPanel.getChildren().add(parent);
			i++;
		}
		ShippingFeeLBL.setText(String.valueOf(fees));
		SumOfPricesLBL.setText(String.valueOf(basePrice));
		FinalPriceLBL.setText(String.valueOf(finalPrice));
		SumOfDiscountsLBL.setText(String.valueOf((basePrice / (double) finalPrice) * 100));
		Random random = new Random(System.currentTimeMillis());

		if (ShippingDateLBL.getText().equals("-")) {
			LocalDate date = LocalDate.now().plusDays(1 + random.nextInt(5));
			ShippingDateLBL.setText(date.toString());
		}

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

	private void checkAmount(int amount, int max, Button dButton, Button iButton) {
		if (amount > 1) {
			dButton.setDisable(false);
		} else {
			dButton.setDisable(true);
		}
		if (amount < max) {
			iButton.setDisable(false);
		} else {
			iButton.setDisable(true);
		}
	}

	private void addEmptyPage() throws Exception {
		PayOrderFromValueBTN.getParent().setVisible(false);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/CartEmpty.fxml"));
		Parent parent = loader.load();
		ProductsListPanel.getChildren().add(parent);
	}
}