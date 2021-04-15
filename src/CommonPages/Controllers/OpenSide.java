package CommonPages.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class OpenSide {

	@FXML
	private AnchorPane SideBarPanel;

	@FXML
	private AnchorPane MainPanel;

	@FXML
	private VBox SideBar;

	@FXML
	private VBox SideBar1;

	@FXML
	private VBox exit;

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

}
