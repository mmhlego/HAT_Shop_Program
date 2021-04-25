package DataController;

import java.sql.*;

public class DataChecker {

    public static boolean CheckLogin(String Username, String Password) {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT Username,Password FROM `Customers` WHERE Username=\'"
                    + Username + "\' UNION (SELECT Username,Password FROM `Employees` WHERE Username=\'" + Username
                    + "\') UNION (SELECT Username ,Password FROM `Manager` WHERE Username=\'" + Username + "\')");

            if (r.next()) {
                String username = r.getString(1);
                String password = r.getString(2);
                if (password.equals(Encoder.encode(Password)) && username.equals(Username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean UsernameExists(String Username) {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT Username FROM `Customers` WHERE Username=\'" + Username
                    + "\' UNION (SELECT Username FROM `Employees` WHERE Username=\'" + Username
                    + "\') UNION (SELECT Username FROM `Manager` WHERE Username=\'" + Username + "\')");

            if (r.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int GetAmountOf(String Which) {

        try {
            int Count = 0;
            ResultSet r = DBConnector.RunCommand("SELECT * FROM " + Which);
            while (r.next()) {
                Count++;
            }
            return Count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean IsBanned(String Username) {
        try {
            ResultSet r = DBConnector
                    .RunCommand("SELECT AccountMode FROM Customers WHERE Username=" + "\'" + Username + "\'");
            r.next();
            int Mode = r.getInt(1);
            if (Mode == 2) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
