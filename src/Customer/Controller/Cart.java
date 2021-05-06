package Customer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import Controller.UserController;
import DataController.DBConnector;
import DataController.DataAdder;
import DataController.DataUpdator;
import DataController.ProductChecker;
import DataController.UserUpdator;
import Model.Order;
import Model.Order.OrderStatus;
import Model.Product;
import Model.Shipping;
import Model.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	ArrayList<Product> SpecialProduct = new ArrayList<>();
	public static Stage pStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			SpecialProduct = ProductChecker.GetSpecialProducts();
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
				pStage = stage;
				stage.show();
				Payment.TransactionMode = true;

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		PayOrderFromValueBTN.setOnAction((e) -> {
			if (UserController.customer.Value >= Long.parseLong(FinalPriceLBL.getText())) {
				UserController.UpdateScreen();

				UserUpdator.UpdateValue(UserController.customer.Username, -Long.parseLong(FinalPriceLBL.getText()));
				UserController.Cart.Status = OrderStatus.SENDING;
				UserController.Cart.BuyProducts();
				DataUpdator.UpdateOrderStatus(UserController.Cart);
				DataAdder.AddShipping(UserController.Cart.OrderID, 0, Long.parseLong(ShippingFeeLBL.getText()),
						LocalDate.parse(ShippingDateLBL.getText()), Shipping.GenerateID());
				DataAdder.AddTransaction(UserController.Cart.OwnerID, Long.parseLong(FinalPriceLBL.getText()),
						LocalDate.parse(ShippingDateLBL.getText()), Transaction.GenerateID());
				DataAdder.AddOrder(new Order(UserController.customer.ID, Order.GenerateID(), OrderStatus.PENDING));

				UserController.LoadUserFullData();
				UserController.HideLoading();
			} else {
				Alert(AlertType.ERROR, "اعتبار حساب کافی نیست !");
			}
		});
	}

	private static void Alert(AlertType AlertType, String Content) {
		Alert alert = new Alert(AlertType);
		alert.setHeaderText(null);
		alert.setContentText(Content);
		alert.show();
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

					int j = 0;
					for (Product x : UserController.Cart.Products) {
						if (x.ID.equals(p.ID)) {
							UserController.Cart.Amounts.remove(j);
							UserController.Cart.Products.remove(j);
							break;
						}
						j++;
					}
					UserController.UpdateCart();
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
				int j = 0;
				for (Product x : UserController.Cart.Products) {
					if (x.ID.equals(p.ID)) {
						UserController.Cart.Amounts.set(j, Integer.parseInt(controller.getAmountLBL().getText()));
						break;
					}
					j++;
				}

				UserController.UpdateCart();
				ProductsListPanel.getChildren().clear();
				try {
					addOrder();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			});
			for (Product spProduct : SpecialProduct) {
				if (p.ID.equals(spProduct.ID)) {

					special = true;
				}
			}
			controller.getDecreaseAmountBTN().setOnAction(e -> {
				controller.getAmountLBL()
						.setText(String.valueOf(Integer.parseInt(controller.getAmountLBL().getText()) - 1));
				checkAmount(Integer.parseInt(controller.getAmountLBL().getText()), p.Amount,
						controller.getDecreaseAmountBTN(), controller.getIncreaseAmountBTN());
				int j = 0;
				for (Product x : UserController.Cart.Products) {
					if (x.ID.equals(p.ID)) {
						UserController.Cart.Amounts.set(j, Integer.parseInt(controller.getAmountLBL().getText()));
						break;
					}
					j++;
				}
				UserController.UpdateCart();
				ProductsListPanel.getChildren().clear();
				try {
					addOrder();

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			});
			fees += Shipping.generateFee(UserController.Cart.Amounts.get(i), UserController.customer.Mode);
			basePrice += p.Price * UserController.Cart.Amounts.get(i);
			finalPrice += Product.getTotalValue(p, UserController.Cart.Amounts.get(i));
			ProductsListPanel.getChildren().add(parent);
			i++;
		}
		ShippingFeeLBL.setText(String.valueOf(fees));
		SumOfPricesLBL.setText(String.valueOf(basePrice));
		FinalPriceLBL.setText(String.valueOf(finalPrice));
		SumOfDiscountsLBL.setText(String.valueOf(basePrice - finalPrice));

		if (ShippingDateLBL.getText().equals("-")) {
			LocalDate date = LocalDate.now().plusDays(5);
			ShippingDateLBL.setText(date.toString());
		}

	}

	private void buyPage(Product product, Image image) {

		ProductInformationPage.p = product;
		ProductInformationPage c = (ProductInformationPage) MainStructure
				.addPage("src/Customer/Visual/ProductInformationPage.fxml");
		c.buyPage(product, image, special);

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