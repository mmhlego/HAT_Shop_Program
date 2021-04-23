package DataController;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import Model.Customer;
import Model.Employee;
import Model.Manager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DBConnector {

	private static ResultSet Results;
	public static Connection Con;
	public static Stage stage;

	public static boolean Connect() {
		try {
			Con = DriverManager.getConnection(
					"jdbc:mysql://sql3.freesqldatabase.com/sql3407743?characterEncoding=UTF-8", "sql3407743",
					"RLyeK4eFrm");

			if (Con != null) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	public static ResultSet RunCommand(String Command) throws Exception {
		Results = null;

		Statement stmt = Con.createStatement();
		Results = stmt.executeQuery(Command);

		return Results;
	}

	public static void CheckConnection(AnchorPane CurrentPage) {
		FXMLLoader loader;
		try {
			loader = new FXMLLoader(new File("src/CommonPages/Visual/LoadingPage.fxml").toURI().toURL());
			Parent Loading = loader.load();
			AnchorPane Pane = (AnchorPane) stage.getScene().getRoot();
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					if (Connect()) {
						Pane.getChildren().remove(Loading);
						System.out.println("Connected");
						CheckConnection(CurrentPage);
					} else {
						Pane.getChildren().add(Loading);
						System.out.println("Connecting to database ...");
						CheckConnection(CurrentPage);
					}

				}
			};
			timer.schedule(task, 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Customer GetCustomer(String Username) {
		try {
			ResultSet r = RunCommand("SELECT * FROM Customers WHERE Username=" + "\'" + Username + "\"");
			if (r.next()) {
				return new Customer(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
						r.getString(6), r.getString(7), r.getLong(8), Customer.CustomerMode.IntToMode(r.getInt(9)),
						r.getString(10));
			}
		} catch (Exception e) {
			System.out.println("No Users Found !");
		}
		return null;
	}

	public static Employee GetEmployee(String Username) {
		try {
			ResultSet r = RunCommand("SELECT * FROM Employees WHERE Username=" + "\'" + Username + "\"");
			if (r.next()) {
				return new Employee(r.getString(1), r.getString(2), r.getString(3), r.getString(4),
						Employee.IntToMode(r.getInt(5)), r.getString(6), r.getString(7), r.getString(8));
			}
		} catch (Exception e) {
			System.out.println("No Employees Found !");
		}
		return null;
	}

	public static Manager GetManager(String Username) {
		try {
			ResultSet r = RunCommand("SELECT * FROM Manager WHERE Username=" + "\'" + Username + "\"");
			if (r.next()) {
				return new Manager(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
						r.getString(6));
			}
		} catch (Exception e) {
			System.out.println("No Managers Found !");
		}
		return null;
	}

	public static ResultSet GetOrdersDB(String OwnerID) {
		try {
			return RunCommand("SELECT * FROM Orders WHERE OwnerID=" + "\'" + OwnerID + "\'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet GetShippingsDB(String OrderID) {
		try {
			return RunCommand("SELECT * FROM Shipping WHERE OrderID=" + "\'" + OrderID + "\'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet GetTransactionsDB(String FromID) {
		try {
			return RunCommand("SELECT * FROM Transactions WHERE FromID=" + "\'" + FromID + "\'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
