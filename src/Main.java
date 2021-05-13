import java.io.IOException;
import DataController.DBConnector;
import DataController.UserUpdator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static void PrintEstimatedTime(long start) {
        long time = System.currentTimeMillis() - start;
        System.out.println("\n=====================================================================================\n");
        System.out.println("Program run time information:");
        System.out.println("\t- " + (time / 1000) / 60 + " Minutes");
        System.out.println("\t- " + (time / 1000) % 60 + " Seconds");
        System.out.println("\t- " + time % 1000 + " Milliseconds");
        System.out.println("\n=====================================================================================\n");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnector.stage = primaryStage;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                }

                while (!DBConnector.Connect()) {
                    System.out.println("Disconnected. Trying again . . .");
                }

                System.out.println("Connected");
                PrintEstimatedTime(start);

                UserUpdator.Update();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        OpenLoginPage(primaryStage);
                    }
                });
            }
        });

        thread.start();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("LoginPage/View/FirstPage.fxml"));
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void OpenLoginPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage/View/Login.fxml"));
            primaryStage.close();
            Stage SecondaryStage = new Stage(StageStyle.TRANSPARENT);
            Scene scene = new Scene(loader.load());
            SecondaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            SecondaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
