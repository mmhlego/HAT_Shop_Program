package CommonPages.Controllers;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import CommonPages.Controllers.Component.ProfileAccount;
import CommonPages.Controllers.Component.ProfileContact;
import CommonPages.Controllers.Component.ProfilePersonal;
import Controller.UserController;
import Controller.UserController.UserMode;
import Customer.Controller.Payment;
import DataController.UserUpdator;
import Model.Customer.CustomerMode;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Profile implements Initializable {
    @FXML
    private Label PremiumLBL;
    @FXML
    private Button PersonalBTN;
    @FXML
    private Button ContactBTN;
    @FXML
    private Button AccountBTN;
    @FXML
    private ScrollPane ContentPane;
    @FXML
    private ImageView BackBTN;

    public static Stage pStage;
    public static boolean ChargeEntered;
    public static String ChargeAmount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackBTN.setOnMouseClicked(e -> {
            ((AnchorPane) ((AnchorPane) ((AnchorPane) BackBTN.getParent()).getParent()).getParent()).getChildren()
                    .remove((((AnchorPane) ((AnchorPane) BackBTN.getParent()).getParent())));
        });
        ProfilePersonal p = (ProfilePersonal) loadPage("../Visual/Component/ProfilePersonal.fxml");
        goAnimation(PersonalBTN);
        backAnimation(AccountBTN);
        backAnimation(ContactBTN);
        if (UserController.Mode.equals(UserMode.Customer)) {
            if (UserController.customer.Mode.equals(CustomerMode.PREMIUM)) {
                PremiumLBL.setVisible(true);
            }
            p.getFirstNameLBL().setText(UserController.customer.FirstName);
            p.getLastNameLBL().setText(UserController.customer.LastName);
        } else if (UserController.Mode.equals(UserMode.Employee)) {
            p.getFirstNameLBL().setText(UserController.employee.FirstName);
            p.getLastNameLBL().setText(UserController.employee.LastName);
        } else if (UserController.Mode.equals(UserMode.Manager)) {
            p.getFirstNameLBL().setText(UserController.manager.FirstName);
            p.getLastNameLBL().setText(UserController.manager.LastName);
        }

        PersonalBTN.setOnAction(e -> {
            ProfilePersonal personal = (ProfilePersonal) loadPage("../Visual/Component/ProfilePersonal.fxml");
            goAnimation(PersonalBTN);
            backAnimation(AccountBTN);
            backAnimation(ContactBTN);
            if (UserController.Mode.equals(UserMode.Customer)) {
                personal.getFirstNameLBL().setText(UserController.customer.FirstName);
                personal.getLastNameLBL().setText(UserController.customer.LastName);
            } else if (UserController.Mode.equals(UserMode.Employee)) {
                personal.getFirstNameLBL().setText(UserController.employee.FirstName);
                personal.getLastNameLBL().setText(UserController.employee.LastName);
            } else if (UserController.Mode.equals(UserMode.Manager)) {
                personal.getFirstNameLBL().setText(UserController.manager.FirstName);
                personal.getLastNameLBL().setText(UserController.manager.LastName);
            }
        });

        AccountBTN.setOnAction(e -> {
            ProfileAccount account = (ProfileAccount) loadPage("../Visual/Component/ProfileAccount.fxml");
            goAnimation(AccountBTN);
            backAnimation(ContactBTN);
            backAnimation(PersonalBTN);
            if (UserController.Mode.equals(UserMode.Customer)) {
                account.getIDLBL().setText(UserController.customer.ID);
                account.getModeLBL().setText(String.valueOf(UserController.customer.Mode));
                account.getUsernameLBL().setText(UserController.customer.Username);
                account.getChargeBalanceBTN().setOnMouseClicked(e2 -> {
                    TextInputDialog td = new TextInputDialog();
                    td.setTitle("مبلغ شارژ را وارد نمایید");
                    td.setHeaderText(null);
                    td.setContentText(" : مبلغ");
                    Optional<String> result = td.showAndWait();
                    if (result.isPresent()) {
                        if (td.getEditor().getText().equals("")) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("خطا");
                            alert.setContentText("مبلغی را وارد کنید !");
                            alert.show();
                        } else {
                            ChargeAmount = td.getEditor().getText();
                            ChargeEntered = true;
                        }
                        if (ChargeEntered) {
                            try {

                                FXMLLoader loader = new FXMLLoader(
                                        new File("src/Customer/Visual/Payment.fxml").toURI().toURL());

                                Scene scene = new Scene(loader.load());
                                scene.setFill(Color.TRANSPARENT);
                                Stage stage = new Stage(StageStyle.TRANSPARENT);
                                stage.setScene(scene);
                                pStage = stage;
                                stage.show();
                                Payment.TransactionMode = false;

                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
                if (!UserController.customer.Mode.equals(CustomerMode.REGULAR)) {
                    account.getUpgradeAccountBTN().setVisible(false);
                    ((AnchorPane) account.getUpgradeAccountBTN().getParent()).setPrefHeight(180);
                }
                account.getUpgradeAccountBTN().setOnMouseClicked(e2 -> {
                    UserUpdator.UpdateValue(UserController.customer.Username, -1000000);
                    if (UserUpdator.IsBalanceEnough) {
                        UserUpdator.MakePremium(UserController.customer.Username);
                    }
                });
            } else if (UserController.Mode.equals(UserMode.Employee)) {
                account.getIDLBL().setText(UserController.employee.ID);
                account.getModeLBL().setText(String.valueOf(UserController.employee.Mode));
                account.getUsernameLBL().setText(UserController.employee.Username);
                account.getChargeBalanceBTN().setVisible(false);
                account.getUpgradeAccountBTN().setVisible(false);
                ((AnchorPane) account.getUpgradeAccountBTN().getParent()).setPrefHeight(180);
            } else if (UserController.Mode.equals(UserMode.Manager)) {
                account.getIDTitleLBL().setVisible(false);
                account.getIDLBL().setVisible(false);
                account.getModeTitleLBL().setVisible(false);
                account.getModeLBL().setVisible(false);
                account.getUsernameLBL().setText(UserController.manager.Username);
                account.getChargeBalanceBTN().setVisible(false);
                account.getUpgradeAccountBTN().setVisible(false);
                ((AnchorPane) account.getUpgradeAccountBTN().getParent()).setPrefHeight(180);
            }
        });

        ContactBTN.setOnAction(e -> {
            ProfileContact contact = (ProfileContact) loadPage("../Visual/Component/ProfileContact.fxml");

            goAnimation(ContactBTN);
            backAnimation(AccountBTN);
            backAnimation(PersonalBTN);

            if (UserController.Mode.equals(UserMode.Customer)) {
                contact.getMailLBL().setText(UserController.customer.Email);
                contact.getPhoneLBL().setText(UserController.customer.Phone);
            } else if (UserController.Mode.equals(UserMode.Employee)) {
                contact.getMailLBL().setText(UserController.employee.Email);
                contact.getPhoneLBL().setText(UserController.employee.Phone);
            } else if (UserController.Mode.equals(UserMode.Manager)) {
                contact.getMailLBL().setText(UserController.manager.Email);
                contact.getPhoneLBL().setText(UserController.manager.Phone);
            }
        });
    }

    private Object loadPage(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            ContentPane.setContent(loader.load());
            return loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void goAnimation(Button b) {
        KeyValue value1 = new KeyValue(b.styleProperty(),
                "-fx-background-color:#769FCD;-fx-background-radius: 0 20 20 0;");
        KeyValue value2 = new KeyValue(b.prefWidthProperty(), 105);
        KeyFrame frame = new KeyFrame(Duration.seconds(0.5), value1, value2);
        Timeline timeline = new Timeline(frame);
        timeline.play();

    }

    private void backAnimation(Button b) {
        KeyValue value1 = new KeyValue(b.styleProperty(),
                "-fx-background-color: #B9D7EA;-fx-background-radius: 0 20 20 0;");
        KeyValue value2 = new KeyValue(b.prefWidthProperty(), 95);
        KeyFrame frame = new KeyFrame(Duration.seconds(0.5), value1, value2);
        Timeline timeline = new Timeline(frame);
        timeline.play();
    }
}
