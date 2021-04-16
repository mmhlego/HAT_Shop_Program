package CommonPages.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class OpenSide implements Initializable {

	@FXML
	private AnchorPane SideBarPanel;

	@FXML
	private AnchorPane MainPanel;

	@FXML
	private VBox SideBar;

	@FXML
	private Label menuLBL;

	@FXML
	private VBox SideBar1;

	public Label getMenuLBL() {
		return menuLBL;
	}

	public void setMenuLBL(Label menuLBL) {
		this.menuLBL = menuLBL;
	}

	public Label getExitLBL() {
		return exitLBL;
	}

	public void setExitLBL(Label exitLBL) {
		this.exitLBL = exitLBL;
	}

	@FXML
	private VBox exit;

	@FXML
	private Label exitLBL;

	@FXML
	private VBox imageBox;

	@FXML
	private ImageView img;

	public AnchorPane getSideBarPanel() {
		return SideBarPanel;
	}

	public void setSideBarPanel(AnchorPane sideBarPanel) {
		SideBarPanel = sideBarPanel;
	}

	public AnchorPane getMainPanel() {
		return MainPanel;
	}

	public void setMainPanel(AnchorPane mainPanel) {
		MainPanel = mainPanel;
	}

	public VBox getSideBar() {
		return SideBar;
	}

	public void setSideBar(VBox sideBar) {
		SideBar = sideBar;
	}

	public VBox getSideBar1() {
		return SideBar1;
	}

	public void setSideBar1(VBox sideBar1) {
		SideBar1 = sideBar1;
	}

	public VBox getExit() {
		return exit;
	}

	public void setExit(VBox exit) {
		this.exit = exit;
	}

	public VBox getImageBox() {
		return imageBox;
	}

	public void setImageBox(VBox imageBox) {
		this.imageBox = imageBox;
	}

	public ImageView getImg() {
		return img;
	}

	public void setImg(ImageView img) {
		this.img = img;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
