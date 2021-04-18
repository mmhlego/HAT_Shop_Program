package LoginPage.Controller.Register;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import DataController.SMSSender;
import Model.Limitter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.*;

public class FirstRegisterPage implements Initializable {

	@FXML
	private AnchorPane loginAnchor;

	@FXML
	private TextField phoneNumber;

	@FXML
	private JFXButton sendOTP;

	@FXML
	private ImageView backBTN;

	public static String Phone;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Limitter.Limit(phoneNumber, 11, true);
		backBTN.setCursor(Cursor.HAND);
		backBTN.setOnMouseClicked(e -> System.exit(0));

		sendOTP.setOnAction((e) -> {
			if (phoneNumber.getText().length() == 11 && phoneNumber.getText().substring(0, 2).equals("09")) {
				Phone = phoneNumber.getText();
				SMSSender.SendOTP(phoneNumber.getText());
				FXMLLoader loader;
				try {
					loader = new FXMLLoader(
							new File("src\\LoginPage\\View\\Register\\SecondRegisterPage.fxml").toURI().toURL());
					loginAnchor.getChildren().add(loader.load());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				Alert(AlertType.ERROR, "شماره تلفن وارد شده اشتباه است !");
			}
		});
	}

	private void Alert(AlertType AlertType, String Content) {
		Alert alert = new Alert(AlertType);
		alert.setHeaderText(null);
		alert.setContentText(Content);
		alert.show();
	}

}
