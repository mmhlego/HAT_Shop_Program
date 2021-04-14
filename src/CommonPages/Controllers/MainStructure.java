package CommonPages.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
	private VBox imageBox;

	@FXML
	private ImageView img;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(1);
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/OpenSide.fxml"));
		try {
			Parent root = loader.load();
			OpenSide sideBarController = loader.getController();
			MainPanel.getChildren().add(root);
			root.setTranslateX(1080);
			SideBar.setOnMouseClicked(e -> {
				sideBarAnimaton(root);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

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
