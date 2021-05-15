package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CommonPages.Controllers.MainStructure;
import DataController.UserGetter;
import Model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ShippingList {
    @FXML
    private VBox MainPanel;
    @FXML
    private TextField SearchTXF;
    @FXML
    private Button SearchBTN;
    @FXML
    private Button RefreshPageBTN;

    ArrayList<Customer> AllTransactions;

    int i = 0;

    private void search(String s) throws Exception {
        //ArrayList<Customer> searchResult = new ArrayList<>();
        //for (Customer customer : AllTransactions) {
        //    if (customer.Address.toLowerCase().contains(s) || customer.Email.toLowerCase().contains(s)
        //            || customer.FirstName.toLowerCase().contains(s) || customer.ID.toLowerCase().contains(s)
        //            || customer.LastName.toLowerCase().contains(s) || customer.Phone.toLowerCase().contains(s)
        //            || customer.Username.toLowerCase().contains(s)
        //            || String.valueOf(customer.Mode).toLowerCase().contains(s)
        //            || String.valueOf(customer.Value).toLowerCase().contains(s)) {
        //        searchResult.add(customer);
        //    }
        //}
        //MainPanel.getChildren().clear();
        //i = 0;
        //if (searchResult.size() == 0) {
        //    FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/NoResults.fxml"));
        //    MainPanel.getChildren().add(loader.load());
        //} else {
        //    ShowAllCustomers(searchResult);
        //}
    }

    //private void ShowAllCustomers(ArrayList<Customer> customers) throws Exception {
    //    for (Customer customer : customers) {
    //        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/EachCustomer.fxml"));
    //        Parent c = loader.load();
    //        EachCustomer controller = loader.getController();
    //        AnchorPane.setTopAnchor(c, (double) (35 + i * 115));
    //        AnchorPane.setLeftAnchor(c, (double) 32);
    //        controller.getCustomerIDLBL().setText(customer.ID);
    //        // controller.getCustomerNameLBL().setText(customer.FirstName + " " +
    //        // customer.LastName);
    //        controller.getCustomerNameLBL().setText(customer.Username);
    //        switch (customer.Mode) {
    //            case PREMIUM:
    //                controller.getPremiumLBL().setVisible(true);
    //                break;
    //            case PREMIUMBANNED:
    //                controller.getBannedLBL().setVisible(true);
    //                break;
    //            case REGULAR:
    //                controller.getRegularLBL().setVisible(true);
    //                break;
    //            case REGULARBANNED:
    //                controller.getBannedLBL().setVisible(true);
    //                break;
    //        }
    //        MainPanel.getChildren().add(c);
    //    }
    //}
}
