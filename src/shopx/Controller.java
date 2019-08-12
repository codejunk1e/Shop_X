package shopx;

import com.jfoenix.controls.JFXTabPane;
import javafx.application.Platform;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;

public class Controller {

    @FXML
    private JFXTabPane tabContainer;

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


    private double tabWidth = 120;
    public static int lastSelectedTabIndex = 0;

    /// Life cycle

    @FXML
    public void initialize() {
        configureView();
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
