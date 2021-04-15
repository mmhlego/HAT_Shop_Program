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

    // public static boolean CheckConnection() {

    // }
    
    public static void CreateTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (Connect()) {
                    System.out.println("Connected");
                    CreateTimer();
                } else {
                    System.out.println("Network Error");
                    CreateTimer();
                }

            }
        };
        timer.schedule(task, 1000);
    }

}
