package DataController;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class UserUpdator {

    public static void Update() {
        UpdateShippingAndOrder(GetPastDate(10));
    }

    public static Date GetPastDate(int Day) {
        LocalDate today = LocalDate.now();
        return Date.valueOf(today.plusDays(-Day));
    }

    private static void UpdateShippingAndOrder(Date date) {
        try {
            PreparedStatement ps = DBConnector.Con.prepareStatement("UPDATE `Orders` SET `Status`=2 WHERE OrderID=Any("
                    + "SELECT OrderID FROM `Shipping` WHERE Date BETWEEN '2010-01-01' AND " + "\'" + date + "\'"
                    + " AND Status=0)");
            PreparedStatement ps2 = DBConnector.Con
                    .prepareStatement("UPDATE `Shipping` SET `Status`=1 WHERE Date BETWEEN '2010-01-01' AND " + "\'"
                            + date + "\'" + " AND Status=0");
            ps.executeUpdate();
            ps2.executeUpdate();
            System.out.println("Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
