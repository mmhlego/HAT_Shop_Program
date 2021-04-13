package DataController;

import java.sql.*;

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
            ps.setString(8, Long.toString(Value));
            ps.setString(9, Integer.toString(AccountMode));
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
            ps.setString(5, Integer.toString(Mode));
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

            System.out.println("Added");
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
            ps.setString(4, Long.toString(Price));
            ps.setString(5, Integer.toString(Percentage));
            ps.setString(6, Category);
            ps.setString(7, Integer.toString(Amount));
            ps.setString(8, ID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
