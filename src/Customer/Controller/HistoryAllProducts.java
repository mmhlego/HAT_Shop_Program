package Customer.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class HistoryAllProducts {
    @FXML
    private ImageView BackBTN;
    @FXML
    private VBox AllProductPanel;

    public ImageView getBackBTN() {
        return BackBTN;
    }

    public void setBackBTN(ImageView backBTN) {
        BackBTN = backBTN;
    }

    public VBox getAllProductPanel() {
        return AllProductPanel;
    }

    public void setAllProductPanel(VBox allProductPanel) {
        AllProductPanel = allProductPanel;
    }

}
