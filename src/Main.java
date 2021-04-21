import DataController.DBConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);

		//DBConnector.Connect();
		//SampleCreator.CustomerCreator.CustomerAdder(1);

		//System.out.println(DataChecker.CheckLogin("cyberGhost", "HAT_Cyber"));
		// DBConnector.Connect();
		// System.out.println(DataChecker.CheckLogin("CyberGhost", "HAT_Cyber"));
		// 8.0.171
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("Start Connecting ...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(DBConnector.Connect());
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
