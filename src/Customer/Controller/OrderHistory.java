package Customer.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class OrderHistory implements Initializable {
    @FXML
    private VBox OrdersPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("created");
    }
}
