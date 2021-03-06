package CommonPages.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.UserController;
import Model.Employee.EmployeeMode;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MainStructure implements Initializable {
    @FXML
    private AnchorPane MainPanel;
    @FXML
    private VBox SideBar;
    @FXML
    private VBox menu;
    @FXML
    private ImageView menuImg;
    @FXML
    private VBox imageBox;
    @FXML
    private ImageView img;

    OpenSide sideBarController;
    Parent root;
    public static AnchorPane main;
    boolean HasOverlay = false, isSideOpen = false;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        main = MainPanel;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/OpenSide.fxml"));
        FXMLLoader loader2;

        try {
            root = loader.load();
            sideBarController = loader.getController();
            MainPanel.getChildren().add(root);
            root.setTranslateX(1080);

            menu.setOnMouseClicked(e -> {
                ToggleSidebar(root);
            });

            sideBarController.getMenuLBL().setOnMouseClicked(e -> {
                ToggleSidebar(root);
            });

            imageBox.setOnMouseClicked(e -> OpenLoginPage());
            sideBarController.getExitLBL().setOnMouseClicked(e -> OpenLoginPage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.toFront();
        menu.setCursor(Cursor.HAND);
        imageBox.setCursor(Cursor.HAND);

        AddButton("../../CommonPages/Visual/Profile.fxml", "??????????????", "profile", true);

        if (UserController.Mode.equals(UserController.UserMode.Customer)) {
            loader2 = new FXMLLoader(this.getClass().getResource("../../Customer/Visual/MainPage.fxml"));

            AddButton("../../Customer/Visual/ProductsViewer.fxml", "???????? ??????????????", "AllProducts", false);
            AddButton("../../Customer/Visual/Cart.fxml", "?????? ????????", "cart", false);
            AddButton("../../Customer/Visual/OrderHistory.fxml", "?????????????? ????????", "OrderHistory", false);
        } else if (UserController.Mode.equals(UserController.UserMode.Manager)) {
            loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/CustomerList.fxml"));

            AddButton("../../Manager/Visual/CustomerList.fxml", "???????? ??????????????", "CustomerList", false);
            AddButton("../../Manager/Visual/EmployeeList.fxml", "???????? ??????????????", "EmployeeList", false);
            AddButton("../../Manager/Visual/ProductsList.fxml", "???????? ???????? ????", "AllProducts", false);
            AddButton("../../Manager/Visual/TransactionList.fxml", "???????? ??????????????", "AllTransactions", false);
            AddButton("../../Manager/Visual/ShippingList.fxml", "???????? ?????????????? ", "AllShippings", false);
        } else {
            loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/EmployeeList.fxml"));

            if (UserController.employee.Mode.equals(EmployeeMode.ASSISTANT)) {
                loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/EmployeeList.fxml"));

                AddButton("../../Manager/Visual/CustomerList.fxml", "???????? ??????????????", "CustomerList", false);
                AddButton("../../Manager/Visual/EmployeeList.fxml", "???????? ??????????????", "EmployeeList", false);
                AddButton("../../Manager/Visual/ProductsList.fxml", "???????? ???????? ????", "AllProducts", false);
                AddButton("../../Manager/Visual/TransactionList.fxml", "???????? ??????????????", "AllTransactions", false);
                AddButton("../../Manager/Visual/ShippingList.fxml", "???????? ?????????????? ", "AllShippings", false);
            } else if (UserController.employee.Mode.equals(EmployeeMode.ACCOUNTANT)) {
                loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/TransactionList.fxml"));

                AddButton("../../Manager/Visual/EmployeeList.fxml", "???????? ??????????????", "EmployeeList", false);
                AddButton("../../Manager/Visual/ProductsList.fxml", "???????? ???????? ????", "AllProducts", false);
                AddButton("../../Manager/Visual/TransactionList.fxml", "???????? ??????????????", "AllTransactions", false);
            } else if (UserController.employee.Mode.equals(EmployeeMode.QUALITYCONTROL)) {
                loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/EmployeeList.fxml"));

                AddButton("../../Manager/Visual/EmployeeList.fxml", "???????? ??????????????", "EmployeeList", false);
            } else if (UserController.employee.Mode.equals(EmployeeMode.REGULAR)) {
                loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/CustomerList.fxml"));

                AddButton("../../Manager/Visual/CustomerList.fxml", "???????? ??????????????", "CustomerList", false);
                AddButton("../../Manager/Visual/ProductsList.fxml", "???????? ???????? ????", "AllProducts", false);
            } else if (UserController.employee.Mode.equals(EmployeeMode.SUPPLIER)) {
                loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/ProductsList.fxml"));

                AddButton("../../Manager/Visual/ProductsList.fxml", "???????? ???????? ????", "AllProducts", false);
            } else if (UserController.employee.Mode.equals(EmployeeMode.STOREKEEPER)) {
                loader2 = new FXMLLoader(this.getClass().getResource("../../Manager/Visual/ProductAmountList.fxml"));

                AddButton("../../Manager/Visual/ProductAmountList.fxml", "?????????? ???????? ????", "AllProductsAmounts", false);
                AddButton("../../Manager/Visual/TransactionList.fxml", "???????? ??????????????", "AllTransactions", false);
                AddButton("../../Manager/Visual/ShippingList.fxml", "???????? ?????????????? ", "AllShippings", false);
            }
        }

        AddButton("../../CommonPages/Visual/Settings.fxml", "??????????????", "Settings", true);

        try {
            MainPanel.getChildren().add(loader2.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void OpenLoginPage() {
        ((Stage) main.getParent().getScene().getWindow()).close();

        try {
            Stage LoginPAge = new Stage();
            FXMLLoader loader = new FXMLLoader(
                    new File(System.getProperty("user.dir") + "/src/LoginPage/View/Login.fxml").toURI().toURL());
            //FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../LoginPage/View/Login.fxml"));
            Scene scene = new Scene(loader.load());
            scene.setFill(Color.TRANSPARENT);
            LoginPAge.initStyle(StageStyle.TRANSPARENT);
            LoginPAge.setScene(scene);
            LoginPAge.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void AddButton(String fxml, String name, String Image, boolean overlay) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Visual/Component/SidePic.fxml"));
            VBox root = loader.load();
            root.setCursor(Cursor.HAND);

            try {
                ((ImageView) root.getChildren().get(0)).setImage(new Image(new FileInputStream(
                        new File(System.getProperty("user.dir") + "/src/pictures/icons/" + Image + ".png"))));
            } catch (Exception e) {
                System.out.println("Image not found (" + Image + ".png)");
            }

            SideBar.getChildren().add(root);

            Label label = new Label(name);
            label.setStyle(
                    "-fx-alignment:center; -fx-font-family: 'B Koodak'; -fx-font-size: 20px; -fx-text-fill: white; -fx-cursor: hand;");
            label.setPrefHeight(60);
            label.setPrefWidth(190);

            sideBarController.getSideBar().getChildren().add(label);

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    DeselectAll();
                    SelectBTN(root, label);
                }
            };

            root.setOnMouseClicked(e -> {
                OpenMenuItem(fxml, overlay);
                r.run();
            });

            label.setOnMouseClicked(e -> {
                OpenMenuItem(fxml, overlay);
                r.run();
            });

            root.setOnMouseEntered(e -> r.run());
            label.setOnMouseEntered(e -> r.run());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SelectBTN(VBox box, Label label) {
        box.setStyle("-fx-background-color:#6887C5;");
        label.setStyle(
                "-fx-alignment:center; -fx-font-family: 'B Koodak'; -fx-font-size: 20px; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color:#6887C5; ");
    }

    private void DeselectAll() {
        for (Node n : SideBar.getChildren()) {
            n.setStyle("-fx-background-color:transparent;");
        }
        for (Node n : sideBarController.getSideBar().getChildren()) {
            n.setStyle(
                    "-fx-alignment:center; -fx-font-family: 'B Koodak'; -fx-font-size: 20px; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color:transparent; ");
        }
    }

    private void OpenMenuItem(String fxml, boolean overlay) {
        if (!overlay) {
            MainPanel.getChildren().clear();
            MainPanel.getChildren().add(root);
        }

        if (isSideOpen) {
            CloseSidebar();
        }

        sideClickAction(fxml);
    }

    public static Object addPage(String url) {
        Object Controller = null;
        try {
            FXMLLoader loader = new FXMLLoader(new File(url).toURI().toURL());
            main.getChildren().add(loader.load());
            Controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Controller;
    }

    private void sideClickAction(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            /*
             * if (MainPanel.getChildren().size() >= 2) {
             * MainPanel.getChildren().remove(MainPanel.getChildren().size() - 1); }
             */
            MainPanel.getChildren().add(loader.load());
            root.toFront();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ToggleSidebar(Parent root) {
        root.toFront();
        if (!isSideOpen) {
            OpenSidebar();
        } else {
            CloseSidebar();
        }
    }

    private void OpenSidebar() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), root);
        SideBar.toFront();
        transition.setCycleCount(1);
        transition.setByX(-1080);
        transition.play();
        isSideOpen = true;
    }

    private void CloseSidebar() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), root);
        SideBar.toFront();
        transition.setCycleCount(1);
        transition.setByX(1080);
        transition.play();
        isSideOpen = false;
    }
}
