package Controller;

import DataController.*;
import Model.*;
import java.util.*;

public class UserController {

    public static UserMode Mode = null;
    public static Manager manager = null;
    public static Employee employee = null;
    public static Customer customer = null;
    private static ArrayList<Order> AllOrders = new ArrayList<Order>();
    private static ArrayList<Shipping> AllShippings = new ArrayList<Shipping>();
    private static ArrayList<Transaction> AllTransactions = new ArrayList<Transaction>();

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

    private static void LoadUserFullData() {
        if (Mode.equals(UserMode.Customer)) {
            AllOrders = UserGetter.ConvertOrderToArrayList(UserGetter.GetOrdersDB(customer.ID));
            AllShippings = UserGetter.ConvertShippingToArrayList(UserGetter.GetShippingsDB(customer.ID));
            AllTransactions = UserGetter.ConvertTransactionToArrayList(UserGetter.GetTransactionsDB(customer.ID));
        } /*else {
            AllOrders = UserGetter.ConvertOrderToArrayList(UserGetter.GetOrdersDB());
            AllShippings = UserGetter.ConvertShippingToArrayList(UserGetter.GetShippingsDB());
            AllTransactions = UserGetter.ConvertTransactionToArrayList(UserGetter.GetTransactionsDB());
          }*/
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
