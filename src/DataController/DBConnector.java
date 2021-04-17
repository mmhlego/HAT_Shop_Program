package DataController;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.layout.AnchorPane;

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

    public static void CheckConnection(AnchorPane CurrentPage) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (Connect()) {
                    System.out.println("Connected");
                    CheckConnection(CurrentPage);
                } else {
                    System.out.println("Connecting to database ...");
                    // FXMLLoader loader;
                    // try {
                    //     loader = new FXMLLoader(new File("src\\CommonPages\\Visual\\LoadingPage.fxml").toURI().toURL());
                    //     CurrentPage.getChildren().add(loader.load());
                    // } catch (IOException e1) {
                    //     e1.printStackTrace();
                    // }
                    CheckConnection(CurrentPage);
                }

            }
        };
        timer.schedule(task, 1000);
    }

}
