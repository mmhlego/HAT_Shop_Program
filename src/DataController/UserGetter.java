package DataController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Customer;
import Model.Customer.CustomerMode;
import Model.Employee;
import Model.Manager;
import Model.Order;
import Model.Order.OrderStatus;
import Model.Shipping;
import Model.Transaction;

public class UserGetter {

    public static ArrayList<Order> ConvertOrderToArrayList(ResultSet r) {
        ArrayList<Order> temp = new ArrayList<Order>();
        try {
            int count = 0;
            while (r.next()) {
                Order o = new Order(r.getString(1), OrderStatus.IntToMode(r.getInt(2)),
                        Order.GetIDsProducts(r.getString(3)), Order.GetIDsAmounts(r.getString(4)), r.getLong(5),
                        r.getString(6));
                System.out.println("Order #" + count++);
                temp.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static ArrayList<Shipping> ConvertShippingToArrayList(ResultSet r) {
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

    public static ArrayList<Transaction> ConvertTransactionToArrayList(ResultSet r) {
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

    public static ArrayList<Customer> ConvertCustomersToArrayList(ResultSet r) {
        ArrayList<Customer> temp = new ArrayList<Customer>();
        try {
            while (r.next()) {
                Customer c = new Customer(r.getString(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getString(6), r.getString(7), r.getLong(8),
                        CustomerMode.IntToMode(r.getInt(9)), r.getString(10));
                temp.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static ArrayList<Employee> GetAllEmployees() {
        ArrayList<Employee> temp = new ArrayList<Employee>();
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Employees");
            while (r.next()) {
                Employee e = new Employee(r.getString(1), r.getString(2), r.getString(3), r.getString(4),
                        Employee.IntToMode(r.getInt(5)), r.getString(6), r.getString(7), r.getString(8));
                temp.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static ArrayList<Employee> GetLowLevelEmployees() {
        ArrayList<Employee> temp = new ArrayList<Employee>();
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Employees WHERE Mode = 0 OR Mode = 1 OR Mode = 2");
            while (r.next()) {
                Employee e = new Employee(r.getString(1), r.getString(2), r.getString(3), r.getString(4),
                        Employee.IntToMode(r.getInt(5)), r.getString(6), r.getString(7), r.getString(8));
                temp.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static ResultSet GetOrdersDB(String OwnerID) {
        try {
            return DBConnector.RunCommand("SELECT * FROM Orders WHERE OwnerID=" + "\'" + OwnerID + "\'"
                    + " AND Status > 0 ORDER BY OrderID ASC");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet GetShippingsDB(String OwnerID) {
        try {
            return DBConnector
                    .RunCommand("SELECT * FROM Shipping WHERE OrderID=ANY( SELECT OrderID FROM `Orders` WHERE OwnerID='"
                            + OwnerID + "' )");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet GetTransactionsDB(String FromID) {
        try {
            return DBConnector.RunCommand("SELECT * FROM Transactions WHERE FromID=" + "\'" + FromID + "\'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Order GetCartDB(String OwnerID) {
        try {
            ResultSet r = DBConnector
                    .RunCommand("SELECT * FROM Orders WHERE OwnerID=" + "\'" + OwnerID + "\'" + " AND Status = 0");
            r.next();
            return new Order(r.getString(1), OrderStatus.IntToMode(r.getInt(2)), Order.GetIDsProducts(r.getString(3)),
                    Order.GetIDsAmounts(r.getString(4)), r.getLong(5), r.getString(6));
        } catch (Exception e) {

        }
        return null;
    }

    public static ResultSet GetOrdersDB() {
        try {
            return DBConnector.RunCommand("SELECT * FROM Orders");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet GetShippingsDB() {
        try {
            return DBConnector.RunCommand("SELECT * FROM Shipping");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet GetTransactionsDB() {
        try {
            return DBConnector.RunCommand("SELECT * FROM Transactions");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet GetCustomersDB() {
        try {
            return DBConnector.RunCommand("SELECT * FROM Customers");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Customer GetCustomer(String Username) {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Customers WHERE Username=" + "\'" + Username + "\'");
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
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Employees WHERE Username=" + "\'" + Username + "\'");
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
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Manager WHERE Username=" + "\'" + Username + "\'");
            if (r.next()) {
                return new Manager(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
                        r.getString(6));
            }
        } catch (Exception e) {
            System.out.println("No Managers Found !");
        }
        return null;
    }

    public static Transaction GetTransactionByOrderID(String UserID, long Value, long Fee) {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Transactions WHERE FromID=" + "\'" + UserID + "\'"
                    + " AND ( Value=" + Value + " OR Value=" + (Value + Fee) + ")");
            r.next();
            return new Transaction(r.getString(1), r.getLong(2), r.getDate(3).toLocalDate(), r.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Shipping GetShippingByOrderID(String OrderID) {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Shipping WHERE OrderID=" + "\'" + OrderID + "\'");
            r.next();
            return new Shipping(r.getString(1), r.getInt(2), r.getLong(3), r.getDate(4).toLocalDate(), r.getString(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int GetNumberOfCustomers() {
        int count = 0;
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Customers");
            while (r.next()) {
                count++;
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int GetNumberOfEmployees() {
        int count = 0;
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Employees");
            while (r.next()) {
                count++;
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
