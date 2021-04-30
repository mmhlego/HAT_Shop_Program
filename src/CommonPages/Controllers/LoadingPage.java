package CommonPages.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LoadingPage implements Initializable {

	@FXML
	private Label connectLBL;

	int i;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		i = 0;
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
									connectLBL.setText("در حال بروزرسانی");
								} else if (i % 4 == 1) {
									connectLBL.setText("در حال بروزرسانی .");
								} else if (i % 4 == 2) {
									connectLBL.setText("در حال بروزرسانی ..");
								} else if (i % 4 == 3) {
									connectLBL.setText("در حال بروزرسانی ...");
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
	}

}
