package CommonPages.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MainStructure implements Initializable {

	@FXML
	private AnchorPane MainPanel;

	@FXML
	private VBox SideBar;

	@FXML
	private VBox menu;

	@FXML
	private ImageView menuImg;

	@FXML
	private VBox imageBox;

	@FXML
	private ImageView img;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/OpenSide.fxml"));
		menu.setCursor(Cursor.HAND);
		imageBox.setCursor(Cursor.HAND);
		try {
			Parent root = loader.load();
			OpenSide sideBarController = loader.getController();
			MainPanel.getChildren().add(root);
			root.setTranslateX(1080);
			menu.setOnMouseClicked(e -> {
				sideBarAnimaton(root);
			});

			imageBox.setOnMouseClicked(e -> Platform.exit());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void AddButton(String fxml, String name) {
		// FXMLLoader loader = new
		// FXMLLoader(this.getClass().getResource("../Visual/"));

	}

	boolean isSideOpen = false;

	private void sideBarAnimaton(Parent root) {
		if (!isSideOpen) {
			TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), root);
			transition.setCycleCount(1);
			transition.setByX(-1080);
			transition.play();
			isSideOpen = true;
		} else {
			TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), root);
			transition.setCycleCount(1);
			transition.setByX(1080);
			transition.play();
			isSideOpen = false;
		}

	}

}
