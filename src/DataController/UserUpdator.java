package DataController;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void UpdateValue(String Username, long Amount) {
        try {
            ResultSet r = DBConnector
                    .RunCommand("SELECT Value FROM Customers WHERE Username=" + "\'" + Username + "\'");
            r.next();
            long CurrentValue = r.getLong(1);
            long NewValue = CurrentValue;
            if (Amount > 0) {
                NewValue = CurrentValue + Amount;
                PreparedStatement ps = DBConnector.Con.prepareStatement(
                        "UPDATE Customers SET Value=" + NewValue + " WHERE Username=" + "\'" + Username + "\'");
                ps.executeUpdate();
                Alert(AlertType.INFORMATION, "حساب با موفقیت شارژ شد");
            } else {
                if (-Amount < CurrentValue) {
                    NewValue = CurrentValue + Amount;
                    PreparedStatement ps = DBConnector.Con.prepareStatement(
                            "UPDATE Customers SET Value=" + NewValue + " WHERE Username=" + "\'" + Username + "\'");
                    ps.executeUpdate();
                    Alert(AlertType.INFORMATION, "پرداخت با موفقیت انجام شد");
                } else {
                    Alert(AlertType.ERROR, "اعتبار حساب کافی نیست !");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Alert(AlertType AlertType, String Content) {
        Alert alert = new Alert(AlertType);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.show();
    }

}
