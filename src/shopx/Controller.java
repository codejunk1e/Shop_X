package shopx;

import com.jfoenix.controls.JFXTabPane;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;

public class Controller {

    private final  DList dList = new DList();
    private final ObservableList<DList> lister =
            FXCollections.observableArrayList(
                    new DList(1, 1, "Cheese Burger", 20, "$40", "10-29-1029"),
                    new DList(2, 10, "Burger", 20, "$40", "10-29-1029"),
                    new DList(3, 11, "Burger", 20, "$40", "10-29-1029"),
                    new DList(4, 100, "Burger", 20, "$40", "10-29-1029"),
                    new DList(5, 101, "Burger", 20, "$40", "10-29-1029"),
                    new DList(6, 110, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029"),
                    new DList(7, 111, "Burger", 20, "$40", "10-29-1029")
            );
    @FXML
    private JFXTabPane tabContainer;

    @FXML
    private TableView <DList> taskstable;

    @FXML
    private Tab userProfileTab;

    @FXML
    private AnchorPane userProfileContainer;

    @FXML
    private Tab settingsTab;

    @FXML
    private Tab AboutTab;

    @FXML
    private Tab sales;

    @FXML
    private AnchorPane settingsContainer;

    @FXML
    private AnchorPane AboutContainer;

    @FXML
    private AnchorPane salesContainer;

    @FXML
    private TableColumn<DList, Integer> sncolumn;

    @FXML
    private TableColumn<DList, Integer> codecolumn;

    @FXML
    private TableColumn<DList, String> descriptioncolumn;

    @FXML
    private TableColumn<DList, Integer> availableStockColumn;

    @FXML
    private TableColumn<DList, String> priceColumn;

    @FXML
    private TableColumn <DList, String>expiryDateColumn;


    private double tabWidth = 120;
    public static int lastSelectedTabIndex = 0;

    /// Life cycle

    @FXML
    public void initialize() {
        configureView();

        sncolumn.setCellValueFactory(
                new PropertyValueFactory<DList, Integer>("sn"));
        codecolumn.setCellValueFactory(
                new PropertyValueFactory<DList, Integer>("code"));
        descriptioncolumn.setCellValueFactory(
                new PropertyValueFactory<DList, String>("Description"));
        availableStockColumn.setCellValueFactory(
                new PropertyValueFactory<DList, Integer>("availableStock"));
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<DList, String>("price"));
        expiryDateColumn.setCellValueFactory(
                new PropertyValueFactory<DList, String>("expiryDate"));

        taskstable.setItems(lister);
    }

    /// Private

    private void configureView() {
        tabContainer.setTabMinWidth(tabWidth);
        tabContainer.setTabMaxWidth(tabWidth);
        tabContainer.setTabMinHeight(tabWidth);
        tabContainer.setTabMaxHeight(tabWidth);
        tabContainer.setRotateGraphic(true);

        EventHandler<Event> replaceBackgroundColorHandler = event -> {
            lastSelectedTabIndex = tabContainer.getSelectionModel().getSelectedIndex();

            Tab currentTab = (Tab) event.getTarget();
            if (currentTab.isSelected()) {
                currentTab.setStyle("-fx-background-color: -fx-focus-color;");
            } else {
                currentTab.setStyle("-fx-background-color: -fx-accent;");
            }
        };

        EventHandler<Event> logoutHandler = event -> {
            Tab currentTab = (Tab) event.getTarget();
            if (currentTab.isSelected()) {
                tabContainer.getSelectionModel().select(lastSelectedTabIndex);

                // TODO: logout action
                // good place to show Dialog window with Yes / No question
                System.out.println("Logging out!");
            }
        };

        configureTab(userProfileTab, "Inventory", "/shopx/resources/images/ic_shopping_cart_black_36dp.png", userProfileContainer, getClass().getResource("inventory.fxml"), replaceBackgroundColorHandler);
        configureTab(sales, "Sales", "/shopx/resources/images/ic_attach_money_36pt.png", salesContainer, getClass().getResource("sales.fxml"), replaceBackgroundColorHandler  );
        configureTab(settingsTab, "Settings", "/shopx/resources/images/ic_settings_black_36dp.png", settingsContainer, getClass().getResource("settings.fxml"), replaceBackgroundColorHandler);
        configureTab(AboutTab, "About", "/shopx/resources/images/ic_question_answer_36pt.png", AboutContainer, getClass().getResource("About.fxml"), replaceBackgroundColorHandler);

        userProfileTab.setStyle("-fx-background-color: -fx-focus-color;");
    }

    private void configureTab(Tab tab, String title, String iconPath, AnchorPane containerPane, URL resourceURL, EventHandler<Event> onSelectionChangedEvent) {
        double imageWidth = 36;

        ImageView imageView = new ImageView(new Image(iconPath));
        imageView.setFitHeight(imageWidth);
        imageView.setFitWidth(imageWidth);

        Label label = new Label(title);
        label.setPadding(new Insets(5, 0, 0, 0));
        label.setStyle("-fx-text-fill: black; -fx-font-weight: normal;");
        label.setTextAlignment(TextAlignment.CENTER);

        BorderPane tabPane = new BorderPane();
        tabPane.setRotate(90.0);
        tabPane.setMaxWidth(tabWidth);
        tabPane.setCenter(imageView);
        tabPane.setBottom(label);

        tab.setText("");
        tab.setGraphic(tabPane);

        tab.setOnSelectionChanged(onSelectionChangedEvent);

        if (containerPane != null && resourceURL != null) {
            try {
                Parent contentView = FXMLLoader.load(resourceURL);
                containerPane.getChildren().add(contentView);
                AnchorPane.setTopAnchor(contentView, 0.0);
                AnchorPane.setBottomAnchor(contentView, 0.0);
                AnchorPane.setRightAnchor(contentView, 0.0);
                AnchorPane.setLeftAnchor(contentView, 0.0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
