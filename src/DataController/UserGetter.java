package DataController;

import java.sql.*;
import java.util.*;
import Model.*;
import Model.Order.OrderStatus;

public class UserGetter {

    private static User CurrentUser;
    public static Manager manager;
    public static Employee employee;
    public static Customer customer;
    private static ArrayList<Order> AllOrders = new ArrayList<Order>();
    private static ArrayList<Shipping> AllShippings = new ArrayList<Shipping>();
    private static ArrayList<Transaction> AllTransactions = new ArrayList<Transaction>();

    public static User getCurrentUser() {
        return CurrentUser;
    }

    public static void setCurrentUser(User u) {
        CurrentUser = u;
        LoadUserFullData(CurrentUser);
    }

    private static void LoadUserFullData(User u) {
        if (u instanceof Customer) {
            AllOrders = ConvertOrderToArrayList(DBConnector.GetOrdersDB(customer.ID));
            AllShippings = ConvertShippingToArrayList(DBConnector.GetShippingsDB(customer.ID));
            AllTransactions = ConvertTransactionToArrayList(DBConnector.GetTransactionsDB(customer.ID));
        } else {
            AllOrders = ConvertOrderToArrayList(DBConnector.GetOrdersDB());
            AllShippings = ConvertShippingToArrayList(DBConnector.GetShippingsDB());
            AllTransactions = ConvertTransactionToArrayList(DBConnector.GetTransactionsDB());
        }
    }

    private static ArrayList<Order> ConvertOrderToArrayList(ResultSet r) {
        ArrayList<Order> temp = new ArrayList<Order>();
        try {
            while (r.next()) {
                Order o = new Order(r.getString(1), OrderStatus.IntToMode(r.getInt(2)),
                        Order.GetIDsProducts(r.getString(3)), Order.GetIDsAmounts(r.getString(4)), r.getLong(5),
                        r.getString(6));
                temp.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    private static ArrayList<Shipping> ConvertShippingToArrayList(ResultSet r) {
        ArrayList<Shipping> temp = new ArrayList<Shipping>();
        try {
            while (r.next()) {
                Shipping SH = new Shipping(r.getString(1), r.getInt(2), r.getLong(3), r.getDate(4).toLocalDate(),
                        Shipping.GenerateID());
                temp.add(SH);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    private static ArrayList<Transaction> ConvertTransactionToArrayList(ResultSet r) {
        ArrayList<Transaction> temp = new ArrayList<Transaction>();
        try {
            while (r.next()) {
                Transaction t = new Transaction(r.getString(1), r.getLong(2), r.getDate(3).toLocalDate(),
                        r.getString(4));
                temp.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
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

}
