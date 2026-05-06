import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

/**
 * @author App
 * created: 5/4/26
 * @since Assignment: App
 **/
public class MainController {

    public Scene buildScene() {
        Image fire = new Image(getClass().getResource("/ImagesInferior/logo.png").toExternalForm());
        ImageView logo = new ImageView(fire);
        logo.setFitWidth(100);
        logo.setPreserveRatio(true);

        HBox topBar = new HBox(15, logo);
        topBar.setAlignment(Pos.TOP_CENTER);  // pins logo to top
        topBar.setStyle("-fx-padding: 10 20; " +
                "-fx-border-color: #F35301; -fx-border-width: 0 0 1 0;");

        WeatherService weatherService = new WeatherService();
        Label weatherLabel = new Label();
        weatherLabel.setStyle("-fx-text-fill: white");
        weatherLabel.setText(weatherService.getWeather("Marina"));
        VBox weatherBox = new VBox(5, weatherLabel);
        weatherBox.setAlignment(Pos.TOP_LEFT);
        weatherBox.setStyle("-fx-padding: 15;");

        Button feedBtn = new Button("My Feed");
        Button profileBtn = new Button("👤 Profile");
        Button settingsBtn = new Button("⚙️ Settings");
        Button logoutBtn = new Button("⏻  Log Out");
        for(Button btn: new Button[]{feedBtn, profileBtn, settingsBtn, logoutBtn}){
            btn.setStyle("-fx-text-fill: white;-fx-background-color: #1a1d24;" +
                    "-fx-border-color: #F35301;-fx-font-size: 15px; -fx-padding: 15 45;" +
                    "-fx-background-radius: 12;-fx-border-radius: 12");
        }

        feedBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.POST));
        profileBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.PROFILE));
        settingsBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.SETTINGS));
        logoutBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.LOGOUT));

        VBox content = new VBox(25, weatherBox, feedBtn, profileBtn, settingsBtn, logoutBtn);
        content.setAlignment(Pos.TOP_CENTER);
        content.setStyle("-fx-padding: 20;");

        BorderPane root = new BorderPane();
        root.setTop(topBar);     // logo + title sit here
        root.setCenter(content);   // nav buttons
        root.setStyle("-fx-background-color: #0f1115");

        return new Scene(root, 800, 600);
    }

}
