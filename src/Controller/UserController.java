package Controller;

import DataController.*;
import Model.*;
import java.util.*;

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
