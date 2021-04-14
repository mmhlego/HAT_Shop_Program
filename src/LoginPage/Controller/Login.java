package LoginPage.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Login implements Initializable {

	@FXML
	private AnchorPane loginAnchor;

	@FXML
	private TextField usernameField;

	@FXML
	private TextField passwordField;

	@FXML
	private JFXButton enterBTN;

	@FXML
	private AnchorPane registerAnchor;

	@FXML
	private ImageView plusImage;

	private final double duration = 2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		plusImage.setCursor(Cursor.HAND);
		plusImage.setOnMouseClicked(e -> registerPageAnimation());

	}

	private void registerPageAnimation() {
		firstTransition();

		for (Node childern : loginAnchor.getChildren()) {
			if (!childern.equals(registerAnchor)) {
				childern.setVisible(false);
			}

		}
	}

	private void firstTransition() {
		TranslateTransition translate = new TranslateTransition(Duration.millis(100), registerAnchor);
		translate.setByX(40);
		translate.setCycleCount(1);
		translate.play();
		translate.setOnFinished(e -> secondTransition());
	}

	private void secondTransition() {
		TranslateTransition translate = new TranslateTransition(Duration.millis(100), registerAnchor);
		translate.setByY(-92);
		translate.setCycleCount(1);
		translate.play();
		translate.setOnFinished(i -> {
			try {
				thirdTransition();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

	int i;

	private void thirdTransition() throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("../../LoginPage/View/Register/FirstRegisterPage.fxml"));
		AnchorPane register = (AnchorPane) loader.load();
		registerAnchor.getChildren().clear();
		/*
		 * AnchorPane.setTopAnchor(register, 0.0); AnchorPane.setBottomAnchor(register,
		 * 500.0); AnchorPane.setTopAnchor(registerAnchor, 0.0);
		 * AnchorPane.setBottomAnchor(registerAnchor, 500.0);
		 */
		registerAnchor.setStyle("-fx-background-color:#769FCD;");
		registerAnchor.getParent().setStyle("-fx-background-radius:20;");

		Timeline timeline = new Timeline();
		KeyValue keyValue1 = new KeyValue(registerAnchor.prefHeightProperty(), 500);
		KeyValue keyValue2 = new KeyValue(registerAnchor.prefWidthProperty(), 450);
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValue1, keyValue2);
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (i = 5000; i >= 100; i -= 60) {
					try {
						Thread.sleep((long) (duration / 81));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							registerAnchor.setStyle("-fx-background-color:#769FCD;-fx-background-radius:" + i + ";");

						}
					});

				}
			}
		});

		thread.start();

		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		timeline.setOnFinished(e -> {
			registerAnchor.getChildren().add(register);
			registerAnchor.getParent().setStyle("-fx-background-radius:20;");
			AnchorPane pane = (AnchorPane) registerAnchor.getParent();
			pane.setStyle("-fx-background-color:transparent;");
		});

		/*
		 * ScaleTransition scale = new
		 * ScaleTransition(Duration.seconds(2),registerAnchor); scale.setFromX(0);
		 * scale.setToX(1); scale.setFromY(0); scale.setToY(1); scale.play();
		 * 
		 * TranslateTransition transition1 = new
		 * TranslateTransition(Duration.seconds(2),registerAnchor);
		 * transition1.setFromX(-450); transition1.setToX(40);
		 * transition1.setFromY(-500); transition1.setToY(-92); transition1.play();
		 */

	}

}
