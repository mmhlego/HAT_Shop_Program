import DataController.DBConnector;
import DataController.DataChecker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);

		// DataAdder.AddManager("Kamyab", "Tabani", "CyberGhost", "HAT_Cyber",
		// "0914655912", "K.tabani82@gmail.com");
		// DataAdder.AddEmployee("Puya", "Afraz", "P.A", "VLB", 1, "09148303766",
		// "Pouyaafraz@gmail.com", "E-0001");
		// DataAdder.AddCustomer("MohammadMahdi", "Hejazi", "M.M.H", "M.M.H Lego",
		// "09144571245", "mmhlego@gmail.com", "Sahand - kuye sahanad", 0, 1, "C-0001");
		// System.out.println(DataChecker.UserExists("CyberGhost"));
		// DataAdder.AddProduct("Samsung Galaxy A51", "Samsung", "Nothing", 10000000,
		// 10, "Phone", 5, "P-0001");

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
				System.out.println(DataChecker.GetAmountOf("Manager"));
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
