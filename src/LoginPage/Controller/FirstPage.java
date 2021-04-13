
package LoginPage.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
		engilshLBL.setTranslateY(550);
		persianLBL.setTranslateY(550);
		powerLBL.setTranslateY(550);
		connect.setTranslateY(550);
		connectLBL.setTranslateY(550);
		Thread thread = new Thread(this);
		thread.start();
	}

	private void firstPageTransition(Node label) {
		TranslateTransition transition = new TranslateTransition();
		transition.setByY(-550);
		transition.setNode(label);
		transition.setCycleCount(1);
		transition.setInterpolator(Interpolator.EASE_BOTH);
		transition.setDuration(Duration.seconds(1));
		transition.play();
		transition.setOnFinished(e -> {
			if (label.equals(engilshLBL)) {
				firstPageTransition(persianLBL);
			} else if (label.equals(persianLBL)) {
				firstPageTransition(connect);
			} else if (label.equals(connect)) {
				firstPageTransition(connectLBL);
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
											connectLBL.setText("در حال اتصال ..");
										} else if (i % 4 == 3) {
											connectLBL.setText("در حال اتصال ...");
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
				firstPageTransition(powerLBL);
			} else {
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(3000);
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
					firstPageTransition(engilshLBL);

				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
