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
import javafx.scene.control.Label;
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

	OpenSide sideBarController;
	Parent root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/OpenSide.fxml"));
		FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../../Customer/Visual/CustomerMainPage.fxml"));

		try {
			MainPanel.getChildren().add(loader2.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		menu.setCursor(Cursor.HAND);
		imageBox.setCursor(Cursor.HAND);
		try {
			root = loader.load();
			sideBarController = loader.getController();
			MainPanel.getChildren().add(root);
			root.setTranslateX(1080);
			menu.setOnMouseClicked(e -> {
				sideBarAnimaton(root);
			});

			sideBarController.getMenuLBL().setOnMouseClicked(e -> {
				sideBarAnimaton(root);
			});

			imageBox.setOnMouseClicked(e -> Platform.exit());
			sideBarController.getExitLBL().setOnMouseClicked(e -> Platform.exit());
		} catch (IOException e) {
			e.printStackTrace();
		}
		AddButton("../../Customer/Visual/ProductsViewer.fxml", "All Products");
	}

	private void AddButton(String fxml, String name) {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/Component/SidePic.fxml"));
			VBox root = loader.load();
			// ((ImageView) root.getChildren().get(0))
			// .setImage(new Image(new FileInputStream(new File("../../pictures/" + fxml +
			// ".png"))));
			SideBar.getChildren().add(root);

			Label label = new Label(name);
			label.setPrefHeight(60);
			label.setPrefWidth(190);
			System.out.println(sideBarController);
			sideBarController.getSideBar().getChildren().add(label);
			root.setOnMouseClicked(e -> sideClickAction(fxml));
			label.setOnMouseClicked(e -> sideClickAction(fxml));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sideClickAction(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			/*
			 * if (MainPanel.getChildren().size() >= 2) {
			 * MainPanel.getChildren().remove(MainPanel.getChildren().size() - 1); }
			 */
			MainPanel.getChildren().add(loader.load());
			root.toFront();
		} catch (Exception e) {
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
