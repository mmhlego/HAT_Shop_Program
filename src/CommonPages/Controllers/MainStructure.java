package CommonPages.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.UserController;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
	static AnchorPane main;
	boolean HasOverlay = false, isSideOpen = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		main = MainPanel;
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/OpenSide.fxml"));
		FXMLLoader loader2;

		try {
			root = loader.load();
			sideBarController = loader.getController();
			MainPanel.getChildren().add(root);
			root.setTranslateX(1080);

			menu.setOnMouseClicked(e -> {
				ToggleSidebar(root);
			});

			sideBarController.getMenuLBL().setOnMouseClicked(e -> {
				ToggleSidebar(root);
			});

			imageBox.setOnMouseClicked(e -> System.exit(0));
			sideBarController.getExitLBL().setOnMouseClicked(e -> System.exit(0));
		} catch (IOException e) {
			e.printStackTrace();
		}

		root.toFront();
		menu.setCursor(Cursor.HAND);
		imageBox.setCursor(Cursor.HAND);

		AddButton("../../CommonPages/Visual/Profile.fxml", "پروفایل", "profile", true);

		if (UserController.Mode.equals(UserController.UserMode.Customer)) {
			loader2 = new FXMLLoader(this.getClass().getResource("../../Customer/Visual/MainPage.fxml"));

			AddButton("../../Customer/Visual/ProductsViewer.fxml", "تمام محصولات", "AllProducts", false);
			AddButton("../../Customer/Visual/Cart.fxml", "سبد خرید", "cart", false);
			AddButton("../../Customer/Visual/OrderHistory.fxml", "تاریخچه خرید", "OrderHistory", false);
		} else if (UserController.Mode.equals(UserController.UserMode.Manager)) {
			loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/CustomerList.fxml"));

			AddButton("../../Manager/Visual/CustomerList.fxml", "لیست مشتریان", "", false);
			AddButton("../../Manager/Visual/EmployeeList.fxml", "لیست کارکنان", "", false);

		} else {
			loader2 = new FXMLLoader(this.getClass().getResource("../../Employee/Visual/MainPage.fxml"));
		}

		AddButton("../../CommonPages/Visual/Settings.fxml", "تنضیمات", "Settings", true);

		try {
			MainPanel.getChildren().add(loader2.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void AddButton(String fxml, String name, String Image, boolean overlay) {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/Component/SidePic.fxml"));
			VBox root = loader.load();

			try {
				((ImageView) root.getChildren().get(0)).setImage(new Image(new FileInputStream(
						new File(System.getProperty("user.dir") + "/src/pictures/icons/" + Image + ".png"))));
			} catch (Exception e) {
				System.out.println("Image not found (" + Image + ".png)");
				// e.printStackTrace();
			}

			SideBar.getChildren().add(root);

			Label label = new Label(name);
			label.setStyle(
					"-fx-alignment:center; -fx-font-family: 'B Koodak'; -fx-font-size: 20px; -fx-text-fill: white;");
			label.setPrefHeight(60);
			label.setPrefWidth(190);

			sideBarController.getSideBar().getChildren().add(label);
			root.setOnMouseClicked(e -> {
				OpenMenuItem(fxml, overlay);
			});
			label.setOnMouseClicked(e -> {
				OpenMenuItem(fxml, overlay);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void OpenMenuItem(String fxml, boolean overlay) {
		if (overlay && HasOverlay) {
			RemoveLastPage();
		} else if (!overlay) {
			if (HasOverlay) {
				RemoveLastPage();
			}
			RemoveLastPage();
		}

		HasOverlay = overlay;

		if (isSideOpen) {
			CloseSidebar();
		}

		sideClickAction(fxml);
	}

	private void RemoveLastPage() {
		try {
			HasOverlay = false;

			int len = MainPanel.getChildren().size();

			if (MainPanel.getChildren().indexOf(root) == len - 1) {
				MainPanel.getChildren().remove(len - 2);
			} else {
				MainPanel.getChildren().remove(len - 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object addPage(String url) {
		Object Controller = null;
		try {
			FXMLLoader loader = new FXMLLoader(new File(url).toURI().toURL());
			main.getChildren().add(loader.load());
			Controller = loader.getController();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Controller;
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

	private void ToggleSidebar(Parent root) {
		root.toFront();
		if (!isSideOpen) {
			OpenSidebar();
		} else {
			CloseSidebar();
		}
	}

	private void OpenSidebar() {
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), root);
		SideBar.toFront();
		transition.setCycleCount(1);
		transition.setByX(-1080);
		transition.play();
		isSideOpen = true;
	}

	private void CloseSidebar() {
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), root);
		SideBar.toFront();
		transition.setCycleCount(1);
		transition.setByX(1080);
		transition.play();
		isSideOpen = false;
	}
}
