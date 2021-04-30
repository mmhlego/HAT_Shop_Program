package Controller;

import java.io.File;
import java.util.ArrayList;

import DataController.DataUpdator;
import DataController.UserGetter;
import Model.Customer;
import Model.Employee;
import Model.Manager;
import Model.Order;
import Model.Shipping;
import Model.Transaction;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserController {

	public static UserMode Mode = null;
	public static Manager manager = null;
	public static Employee employee = null;
	public static Customer customer = null;
	public static Order Cart = null;
	public static ArrayList<Order> AllOrders = new ArrayList<Order>();
	public static ArrayList<Shipping> AllShippings = new ArrayList<Shipping>();
	public static ArrayList<Transaction> AllTransactions = new ArrayList<Transaction>();

	public static enum UserMode {
		Customer, Employee, Manager;
	}

	public static void SetCurrentUser(String Username) {

		try {
			if (!UserGetter.GetCustomer(Username).equals(null)) {
				customer = UserGetter.GetCustomer(Username);
				Mode = UserMode.Customer;
			}
		} catch (Exception e) {
		}

		try {
			if (!UserGetter.GetEmployee(Username).equals(null)) {
				employee = UserGetter.GetEmployee(Username);
				Mode = UserMode.Employee;
			}
		} catch (Exception e) {
		}

		try {
			if (!UserGetter.GetManager(Username).equals(null)) {
				manager = UserGetter.GetManager(Username);
				Mode = UserMode.Manager;
			}
		} catch (Exception e) {
		}

		System.out.println("User mode : " + Mode.toString());

		LoadUserFullData();
	}

	public static void LoadUserFullData() {
		if (Mode.equals(UserMode.Customer)) {
			Cart = UserGetter.GetCartDB(customer.ID);
			AllOrders = UserGetter.ConvertOrderToArrayList(UserGetter.GetOrdersDB(customer.ID));
			AllShippings = UserGetter.ConvertShippingToArrayList(UserGetter.GetShippingsDB(customer.ID));
			AllTransactions = UserGetter.ConvertTransactionToArrayList(UserGetter.GetTransactionsDB(customer.ID));

			System.out.println(AllOrders.size());
			System.out.println(AllShippings.size());
			System.out.println(AllTransactions.size());
		} /*
			 * else { AllOrders =
			 * UserGetter.ConvertOrderToArrayList(UserGetter.GetOrdersDB()); AllShippings =
			 * UserGetter.ConvertShippingToArrayList(UserGetter.GetShippingsDB());
			 * AllTransactions =
			 * UserGetter.ConvertTransactionToArrayList(UserGetter.GetTransactionsDB()); }
			 */
	}

	public static ArrayList<Order> getOrders() {
		return AllOrders;
	}

	public static ArrayList<Shipping> getShippings() {
		return AllShippings;
	}

	public static ArrayList<Transaction> getTransactions() {
		return AllTransactions;
	}

	public static void UpdateScreen() {
		try {
			loadingStage = new Stage();
			Parent parent = FXMLLoader.load(new File("src/CommonPages/Visual/LoadingPage.fxml").toURI().toURL());
			Scene s = new Scene(parent);
			loadingStage.setScene(s);
			loadingStage.initStyle(StageStyle.TRANSPARENT);
			s.setFill(Color.TRANSPARENT);
			loadingStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Stage loadingStage;

	public static void UpdateUserData() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				DataUpdator.UpdateOrder(UserController.Cart);
				LoadUserFullData();
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						loadingStage.hide();
					}
				});
			}
		});
		thread.start();

	}

	public static void UpdateCart() {
		UpdateScreen();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				DataUpdator.UpdateOrder(UserController.Cart);
				Cart = UserGetter.GetCartDB(customer.ID);
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						loadingStage.hide();
					}
				});
			}
		});
		thread.start();
	}
}
