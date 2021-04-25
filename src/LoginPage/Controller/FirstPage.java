
package LoginPage.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Duration;

public class FirstPage implements Initializable, Runnable {
	@FXML
	private Label engilshLBL;
	@FXML
	private Label persianLBL;
	@FXML
	private Label powerLBL;
	@FXML
	private ProgressIndicator connect;
	@FXML
	private Label connectLBL;

	int i = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		engilshLBL.setTranslateY(600);
		persianLBL.setTranslateY(550);
		connect.setTranslateY(400);
		connectLBL.setTranslateY(300);
		powerLBL.setTranslateY(100);
		Thread thread = new Thread(this);
		thread.start();
	}

	private void firstPageTransition(Node label, int amount) {
		TranslateTransition transition = new TranslateTransition();
		transition.setByY(-amount);
		transition.setNode(label);
		transition.setCycleCount(1);
		transition.setInterpolator(Interpolator.EASE_BOTH);
		transition.setDuration(Duration.millis(1000.0 * amount / 500));
		transition.play();
		transition.setOnFinished(e -> {
			if (label.equals(engilshLBL)) {
				firstPageTransition(persianLBL, 550);
			} else if (label.equals(persianLBL)) {
				firstPageTransition(connect, 400);
			} else if (label.equals(connect)) {
				firstPageTransition(connectLBL, 300);
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						while (true) {
							try {
								Thread.sleep(500);
								Platform.runLater(new Runnable() {

									@Override
									public void run() {
										if (i % 4 == 0) {
											connectLBL.setText("در حال اتصال");
										} else if (i % 4 == 1) {
											connectLBL.setText("در حال اتصال .");
										} else if (i % 4 == 2) {
											connectLBL.setText("در حال اتصال . .");
										} else if (i % 4 == 3) {
											connectLBL.setText("در حال اتصال . . .");
										}
										i++;
									}
								});
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
				thread.start();
			} else if (label.equals(connectLBL)) {
				firstPageTransition(powerLBL, 100);
			} else {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								try {
									FXMLLoader loader = new FXMLLoader(
											getClass().getResource("../../LoginPage/View/Login.fxml"));
									Stage PrimaryStage = ((Stage) engilshLBL.getScene().getWindow());
									PrimaryStage.close();
									Stage SecondaryStage = new Stage(StageStyle.TRANSPARENT);
									Scene scene;
									scene = new Scene(loader.load());
									SecondaryStage.setScene(scene);
									scene.setFill(Color.TRANSPARENT);
									SecondaryStage.show();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
				thread.start();
			}
		});
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					firstPageTransition(engilshLBL, 600);

				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
