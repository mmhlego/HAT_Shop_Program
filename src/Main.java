import java.util.Arrays;

import DataController.DBConnector;
import DataController.DataAdder;
import Model.Product;
import SampleCreator.ProductCreator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
		// DBConnector.Connect();
		// ProductCreator.Create();
		//System.out.println("Done");
		// 8.0.171

		//String[][] s=Product.ParseToArray( "[[حافظه داخلی ,128 گیگابایت],[شبکه های ارتباطی , 2G/3G/4G],[دوربین‌های پشت گوشی  ,4 ماژول دوربین],[سیستم عامل  ,Android]]");
	
		/*String[][] s=Product.ParseToArray(
                                                "[[حافظه داخلی ,128 گیگابایت],[شبکه های ارتباطی , 2G/3G/4G],[دوربین‌های پشت گوشی  ,4 ماژول دوربین],[سیستم عامل  ,Android]]");

                Product P1 = new Product("Samsung Galaxy A71"," گوشی موبایل گلکسی A71 سامسونگ یکی از قدرتمندترین محصولات میان‌رده موجود در بازار است که حسگر انگشت زیرصفحه نمایش و دوربین چهار‌گانه روانه بازار شده است ",s,10299000, 20, Product.PHONE, 20, Product.GenerateID());

		System.out.println(P1);*/
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
