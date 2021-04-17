import DataController.DBConnector;
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	public static void main(String[] args) {
		//launch(args);
		// 8.0.171
		/*DBConnector.Connect();
		DataAdder.AddEmployee("MohammadMahdi", "Hejazi", "M.M.H", "M.M.H Lego",0 , "09146501380", "mmhlego@gmail.com",
				"E-00001");
		DataAdder.AddEmployee("Kamyab", "Tabani", "CyberGhost", "HAT_Cyber", 0 , "09394397528", "K.tabani82@gmail.com" ,
				"E-00002" );
		DataAdder.AddEmployee("Pouya", "Afraz", "Pouya", "VLB", 0, "09148303766", "Pouyaafraz@gmail.com", "E-00003");*/

		for (int i = 0; i < 100; i++) {
			System.out.println(Transaction.GenerateID());
		}
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
