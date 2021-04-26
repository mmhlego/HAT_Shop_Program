import DataController.DBConnector;
import DataController.DataChecker;
import DataController.ProductChecker;
import DataController.UserUpdator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class Main extends Application {
	public static void main(String[] args) {
		// long start = System.currentTimeMillis();

		launch(args);
	
		// PrintEstimatedTime(start);
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
				try {
					Thread.sleep(1000);
					System.out.println("Connecting ...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (DBConnector.Connect()) {
					UserUpdator.Update();
				}
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
}
