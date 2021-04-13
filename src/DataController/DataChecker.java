package DataController;

import java.sql.*;

public class DataChecker {

    public static boolean CheckLogin(String Username, String Password) {
        try {
            ResultSet r = DBConnector
                    .RunCommand("SELECT Password FROM Customers WHERE Username=" + "\'" + Username + "\'");
            if (r.next()) {
                String password = r.getString(1);
                if (password.equals(Encoder.encode(Password))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean UserExists(String Username) {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT * FROM Customers WHERE Username=" + "\'" + Username + "\'");
            if (r.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
