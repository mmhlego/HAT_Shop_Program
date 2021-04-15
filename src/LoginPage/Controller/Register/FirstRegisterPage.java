package LoginPage.Controller.Register;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class FirstRegisterPage implements Initializable {

	@FXML
	private AnchorPane loginAnchor;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField OTP;

	@FXML
	private JFXButton sendOTP;

	@FXML
	private ImageView backBTN;

	private final double duration = 0.5;
	private int i;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		backBTN.setCursor(Cursor.HAND);
		backBTN.setOnMouseClicked(e -> backTransition());
	}

	private void backTransition() {
		/*
		 * FXMLLoader loader = new
		 * FXMLLoader(getClass().getResource("../../View/Login.fxml"));
		 * loginAnchor.setStyle("-fx-background-radius:20;"); AnchorPane login; try {
		 * login = (AnchorPane) loader.load();
		 * 
		 * AnchorPane registerAnchor = (AnchorPane) backBTN.getScene().getRoot(); //
		 * registerAnchor.getChildren().clear();
		 * 
		 * AnchorPane.setTopAnchor(register, 0.0); AnchorPane.setBottomAnchor(register,
		 * 500.0); AnchorPane.setTopAnchor(registerAnchor, 0.0);
		 * AnchorPane.setBottomAnchor(registerAnchor, 500.0);
		 * 
		 * // registerAnchor.setStyle("-fx-background-color:#769FCD;"); //
		 * registerAnchor.getParent().setStyle("-fx-background-radius:20;");
		 * 
		 * Timeline timeline = new Timeline(); KeyValue keyValue1 = new
		 * KeyValue(((AnchorPane)
		 * registerAnchor.getChildren().get(0)).maxHeightProperty(), 80.0); KeyValue
		 * keyValue2 = new KeyValue(((AnchorPane)
		 * registerAnchor.getChildren().get(0)).maxWidthProperty(), 80); KeyFrame
		 * keyFrame = new KeyFrame(Duration.seconds(duration), keyValue1, keyValue2);
		 * Thread thread = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for (i = 100; i >= 5000; i += 60) { try {
		 * Thread.sleep((long) (duration / 81)); } catch (InterruptedException e) {
		 * e.printStackTrace(); } Platform.runLater(new Runnable() {
		 * 
		 * @Override public void run() {
		 * loginAnchor.setStyle("-fx-background-color:#769FCD;-fx-background-radius:" +
		 * i + ";");
		 * 
		 * } });
		 * 
		 * } } });
		 * 
		 * thread.start();
		 * 
		 * timeline.getKeyFrames().add(keyFrame); // timeline.play();
		 * timeline.setOnFinished(e -> { // ((AnchorPane)
		 * registerAnchor.getParent()).getChildren().clear(); //
		 * registerAnchor.getChildren().clear(); //
		 * registerAnchor.getChildren().add(login); //
		 * login.setStyle("-fx-background-radius:20;"); // login.setTranslateX(-40); //
		 * registerAnchor.setStyle("-fx-background-color:transparent;"); }); } catch
		 * (IOException e1) { e1.printStackTrace(); }
		 */
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/Login.fxml"));
			AnchorPane login;

			AnchorPane registerAnchor = (AnchorPane) backBTN.getScene().getRoot();
			login = (AnchorPane) loader.load();
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							registerAnchor.getChildren().clear();
							registerAnchor.getChildren().add(login);

						}
					});

				}
			});
			ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), registerAnchor);
			scaleTransition.setFromY(1);
			scaleTransition.setToY(0);
			scaleTransition.setCycleCount(2);
			scaleTransition.setAutoReverse(true);
			scaleTransition.play();
			/*
			 * FadeTransition fade = new FadeTransition(Duration.seconds(2),
			 * registerAnchor); fade.setCycleCount(2); fade.setFromValue(1);
			 * fade.setAutoReverse(true); fade.setToValue(0); fade.play();
			 */
			thread.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
