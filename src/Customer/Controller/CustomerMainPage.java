package Customer.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class CustomerMainPage {

	@FXML
	private AnchorPane MainPanel;

	@FXML
	private ImageView searchBTN;

	@FXML
	private ImageView nextBTN;

	@FXML
	private AnchorPane phones;

	@FXML
	private AnchorPane accessories;

	@FXML
	private AnchorPane pc;

	@FXML
	private AnchorPane books;

	@FXML
	private AnchorPane supermarket;

	public AnchorPane getMainPanel() {
		return MainPanel;
	}

	public void setMainPanel(AnchorPane mainPanel) {
		MainPanel = mainPanel;
	}

	public ImageView getSearchBTN() {
		return searchBTN;
	}

	public void setSearchBTN(ImageView searchBTN) {
		this.searchBTN = searchBTN;
	}

	public ImageView getNextBTN() {
		return nextBTN;
	}

	public void setNextBTN(ImageView nextBTN) {
		this.nextBTN = nextBTN;
	}

	public AnchorPane getPhones() {
		return phones;
	}

	public void setPhones(AnchorPane phones) {
		this.phones = phones;
	}

	public AnchorPane getAccessories() {
		return accessories;
	}

	public void setAccessories(AnchorPane accessories) {
		this.accessories = accessories;
	}

	public AnchorPane getPc() {
		return pc;
	}

	public void setPc(AnchorPane pc) {
		this.pc = pc;
	}

	public AnchorPane getBooks() {
		return books;
	}

	public void setBooks(AnchorPane books) {
		this.books = books;
	}

	public AnchorPane getSupermarket() {
		return supermarket;
	}

	public void setSupermarket(AnchorPane supermarket) {
		this.supermarket = supermarket;
	}

}
