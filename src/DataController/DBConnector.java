package DataController;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class DBConnector {

    private static ResultSet Results;
    public static Connection Con;

    public static boolean Connect() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://freedb.tech/freedbtech_hatshopsystem",
                    "freedbtech_hatusername", "hatpassword");

            if (Con != null) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public static ResultSet RunCommand(String Command) throws Exception {
        Results = null;

        Statement stmt = Con.createStatement();
        Results = stmt.executeQuery(Command);

        return Results;
    }

    public static void CheckConnection() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (Connect()) {
                    System.out.println("Connected");
                    CheckConnection();
                } else {
                    System.out.println("Network Error");
                    CheckConnection();
                }

            }
        };
        timer.schedule(task, 1000);
    }

}
