package LoginPage.Controller.Register;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FirstRegisterPage implements Initializable {

	@FXML
	private AnchorPane loginAnchor;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField OTP;

	@FXML
	private JFXButton sendOTP;

	@FXML
	private ImageView backBTN;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		backBTN.setCursor(Cursor.HAND);
		backBTN.setOnMouseClicked(e -> Platform.exit());
	}

}
