package DataController;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import Model.Customer;
import Model.Order;
import Model.Product;
import Model.Shipping;
import Model.Transaction;

public class DataAdder {

	public static void AddCustomer(String FirstName, String LastName, String Username, String Password, String Phone,
			String Email, String Address, long Value, int AccountMode, String ID) {

		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement(
					"INSERT INTO `Customers`(`FirstName`, `LastName`, `Username`, `Password`, `Phone`, `Email`, `Address`, `Value`, `AccountMode`, `ID`) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, Username);
			ps.setString(4, Encoder.encode(Password));
			ps.setString(5, Phone);
			ps.setString(6, Email);
			ps.setString(7, Address);
			ps.setLong(8, Value);
			ps.setInt(9, AccountMode);
			ps.setString(10, ID);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddCustomer(Customer c) {
		AddCustomer(c.FirstName, c.LastName, c.Username, c.Password, c.Phone, c.Email, c.Address, c.Value,
				Customer.CustomerMode.ModeToInt(c.Mode), c.ID);
	}

	public static void AddEmployee(String FirstName, String LastName, String Username, String Password, int Mode,
			String Phone, String Email, String ID) {
		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement(
					"INSERT INTO `Employees`(`FirstName`, `LastName`, `Username`, `Password`, `Mode`, `Phone`, `Email`, `ID`) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, Username);
			ps.setString(4, Encoder.encode(Password));
			ps.setInt(5, Mode);
			ps.setString(6, Phone);
			ps.setString(7, Email);
			ps.setString(8, ID);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddManager(String FirstName, String LastName, String Username, String Password, String Phone,
			String Email) {
		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement(
					"INSERT INTO `Manager`(`FirstName`, `LastName`, `Username`, `Password`, `Phone`, `Email`) VALUES (?,?,?,?,?,?)");
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, Username);
			ps.setString(4, Encoder.encode(Password));
			ps.setString(5, Phone);
			ps.setString(6, Email);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddProduct(String Name, String Description, String[][] Details, long Price, int Percentage,
			String Category, int Amount, String ID) {
		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement(
					"INSERT INTO `Products`(`Name`, `Description`, `Details`, `Price`, `Percentage`, `Category`, `Amount`, `ID`) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, Name);
			ps.setString(2, Description);
			ps.setString(3, Arrays.deepToString(Details));
			ps.setLong(4, Price);
			ps.setInt(5, Percentage);
			ps.setString(6, Category);
			ps.setInt(7, Amount);
			ps.setString(8, ID);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddProduct(Product P) {
		AddProduct(P.Name, P.Description, P.Details, P.Price, P.Percentage, P.Category, P.Amount, P.ID);
	}

	public static void AddShipping(String ID, int Status, long Fee, LocalDate date, String shippingID) {
		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement(
					"INSERT INTO `Shipping`(`OrderID`, `Status`, `Fee`, `Date` , `ShippingID`) VALUES (?,?,?,?,?)");
			ps.setString(1, ID);
			ps.setInt(2, Status);
			ps.setLong(3, Fee);
			ps.setDate(4, Date.valueOf(date));
			ps.setString(5, shippingID);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void AddShipping(Shipping SH) {
		AddShipping(SH.ID, SH.Status, SH.Fee, SH.Date, SH.ID);
	}

	public static void AddTransaction(String FromID, long Value, LocalDate date, String ID) {
		try {
			PreparedStatement ps = DBConnector.Con
					.prepareStatement("INSERT INTO `Transactions`(`FromID`, `Value`, `Date`, `ID`) VALUES (?,?,?,?)");
			ps.setString(1, FromID);
			ps.setLong(2, Value);
			ps.setDate(3, Date.valueOf(date));
			ps.setString(4, ID);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void AddTransaction(Transaction T) {
		AddTransaction(T.FromID, T.Amount, T.Date, T.ID);
	}

	public static void AddOrder(String OwnerID, int Status, ArrayList<String> ProductIDs, ArrayList<Integer> Amounts,
			long TotalValue, String OrderID) {
		try {
			PreparedStatement ps = DBConnector.Con.prepareStatement(
					"INSERT INTO `Orders`(`OwnerID`, `Status`, `Products`, `Amounts`, `TotalValue`, `OrderID`) VALUES (?,?,?,?,?,?)");
			ps.setString(1, OwnerID);
			ps.setInt(2, Status);
			ps.setString(3, Arrays.toString(ProductIDs.toArray()));
			ps.setString(4, Arrays.toString(Amounts.toArray()));
			ps.setLong(5, TotalValue);
			ps.setString(6, OrderID);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void AddOrder(Order o) {
		AddOrder(o.OwnerID, Order.OrderStatus.ModeToInt(o.Status), o.GetProductIDs(), o.Amounts, o.TotalValue,
				o.OrderID);
	}

}
