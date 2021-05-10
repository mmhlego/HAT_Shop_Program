package CommonPages.Controllers.Component;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;

public class SettingsPersonalization implements Initializable {

    @FXML
    private JFXToggleButton ThemeToggleButton;

    @FXML
    private JFXToggleButton LanguageToggleButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ThemeToggleButton.setCursor(Cursor.HAND);
        LanguageToggleButton.setCursor(Cursor.HAND);

        ThemeToggleButton.setOnMouseClicked(e -> {
            ThemeToggleButton.setSelected(false);
            Alert(AlertType.INFORMATION, "این قابلیت در آینده نه چندان دور به برنامه اضافه خواهد شد !", "قابلیت آینده");
        });

        LanguageToggleButton.setOnMouseClicked(e -> {
            LanguageToggleButton.setSelected(true);
            Alert(AlertType.INFORMATION, "این قابلیت در آینده نه چندان دور به برنامه اضافه خواهد شد !", "قابلیت آینده");
        });

    }

    private void Alert(AlertType AlertType, String Content, String Title) {
        Alert alert = new Alert(AlertType);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.showAndWait();
    }

}
