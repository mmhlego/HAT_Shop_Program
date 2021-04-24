import DataController.DBConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	public static void main(String[] args) {
		//long start = System.currentTimeMillis();

		// System.out.println(DBConnector.Connect());

		launch(args);
		/*
		 * DBConnector.Connect(); Random random = new Random(); ArrayList<Product>
		 * products = ProductChecker.LoadAllProducts(); int productSize =
		 * products.size(); Order sample = new Order("owner id", "order id",
		 * OrderStatus.PENDING); for (int i = 0; i < 50; i++) { Product p =
		 * products.get(random.nextInt(productSize)); int count = random.nextInt(5) + 1;
		 * sample.addProduct(p, count); sample.PrintDetails(); }
		 */

		// System.out.println(DataChecker.CheckLogin("cyberGhost", "HAT_Cyber"));
		//PrintEstimatedTime(start);
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
