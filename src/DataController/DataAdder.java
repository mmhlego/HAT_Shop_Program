package DataController;

import java.sql.*;

import Model.Product;

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

    public static void AddProduct(String Name, String Description, String Details, long Price, int Percentage,
            String Category, int Amount, String ID) {
        try {
            PreparedStatement ps = DBConnector.Con.prepareStatement(
                    "INSERT INTO `Products`(`Name`, `Description`, `Details`, `Price`, `Percentage`, `Category`, `Amount`, `ID`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, Name);
            ps.setString(2, Description);
            ps.setString(3, Details);
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

}
