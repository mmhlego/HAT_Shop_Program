package CommonPages.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Settings implements Initializable {
	@FXML
	private Button PersonalizationBTN;
	@FXML
	private Button AboutUsBTN;
	@FXML
	private ScrollPane ContentPane;
	@FXML
	private ImageView BackBTN;

	// 769FCD//

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BackBTN.setOnMouseClicked(e -> {
			((AnchorPane) ((AnchorPane) ((AnchorPane) BackBTN.getParent()).getParent()).getParent()).getChildren()
					.remove((((AnchorPane) ((AnchorPane) BackBTN.getParent()).getParent())));
		});
		FXMLLoader loaders = new FXMLLoader(getClass().getResource("../Visual/Component/SettingsPersonalization.fxml"));
		try {
			ContentPane.setContent(loaders.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		buttonsAnimation(PersonalizationBTN);
		PersonalizationBTN.setOnAction(e -> {
			try {
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("../Visual/Component/SettingsPersonalization.fxml"));
				ContentPane.setContent(loader.load());
				buttonsAnimation(PersonalizationBTN);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		AboutUsBTN.setOnAction(e -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../Visual/Component/SettingsAbout.fxml"));
				ContentPane.setContent(loader.load());
				buttonsAnimation(AboutUsBTN);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

	private void buttonsAnimation(Button b) {
		KeyValue value1 = new KeyValue(b.styleProperty(),
				"-fx-background-color:#769FCD;-fx-background-radius: 0 20 20 0;");
		KeyValue value2 = new KeyValue(b.prefWidthProperty(), 110);
		KeyFrame frame = new KeyFrame(Duration.seconds(0.5), value1, value2);
		Timeline timeline = new Timeline(frame);
		timeline.play();
		if (b.equals(PersonalizationBTN)) {
			KeyValue value3 = new KeyValue(AboutUsBTN.styleProperty(),
					"-fx-background-color: #B9D7EA;-fx-background-radius: 0 20 20 0;");
			KeyValue value4 = new KeyValue(AboutUsBTN.prefWidthProperty(), 95);
			KeyFrame frame1 = new KeyFrame(Duration.seconds(0.5), value3, value4);
			Timeline timeline1 = new Timeline(frame1);
			timeline1.play();
		} else {
			KeyValue value3 = new KeyValue(PersonalizationBTN.styleProperty(),
					"-fx-background-color: #B9D7EA;-fx-background-radius: 0 20 20 0;");
			KeyValue value4 = new KeyValue(PersonalizationBTN.prefWidthProperty(), 95);
			KeyFrame frame1 = new KeyFrame(Duration.seconds(0.5), value3, value4);
			Timeline timeline1 = new Timeline(frame1);
			timeline1.play();
		}

	}

}
