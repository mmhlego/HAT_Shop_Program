package DataController;

import java.io.File;
import java.sql.*;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

public class DBConnector {
    private static ResultSet Results;
    public static Connection Con;
    public static Stage stage;

    public static boolean Connect() {
        try {
            Con = DriverManager.getConnection(
                    "jdbc:mysql://sql3.freesqldatabase.com/sql3407743?characterEncoding=UTF-8", "sql3407743",
                    "RLyeK4eFrm");

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
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(new File("src/CommonPages/Visual/LoadingPage.fxml").toURI().toURL());
            Parent Loading = loader.load();
            AnchorPane Pane = (AnchorPane) stage.getScene().getRoot();
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (Connect()) {
                        Pane.getChildren().remove(Loading);
                        System.out.println("Connected");
                        CheckConnection(CurrentPage);
                    } else {
                        Pane.getChildren().add(Loading);
                        System.out.println("Connecting to database ...");
                        CheckConnection(CurrentPage);
                    }

                }
            };
            timer.schedule(task, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
