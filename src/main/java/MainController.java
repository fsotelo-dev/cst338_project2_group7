import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author App
 * created: 5/4/26
 * @since Assignment: App
 **/
public class MainController {

    public Scene buildScene() {
                Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");

        HBox topBar = new HBox(title);
        topBar.setStyle("-fx-background-color: #1a1a1a; -fx-border-color: #2a2a2a; -fx-border-width: 0 0 1 0;");

        Button homeBtn = new Button("🏠 Home");
        Button profileBtn = new Button("👤 Profile");
        Button settingsBtn = new Button("⚙️ Settings");
        Button logoutBtn = new Button("⏻  Log Out");
        for(Button btn: new Button[]{homeBtn, profileBtn, settingsBtn, logoutBtn}){
            btn.setStyle("-fx-text-fill: black; " +
                    "-fx-font-size: 14px; -fx-padding: 12 16;");
        }
        homeBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.LOGIN));
        profileBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.PROFILE));
        settingsBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.SETTINGS));
        logoutBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.LOGIN));

        StackPane mainContent =  new StackPane();
        mainContent.setStyle("-fx-background-color: #141414;");
        BorderPane root = new BorderPane();

        root.setCenter(mainContent);
        VBox layout =  new VBox(25, title, homeBtn, profileBtn, settingsBtn, logoutBtn);
        return new Scene(layout, 800, 600);
    }
//    public static Scene buildMAINScene(Stage stage) {
//        Label title = new Label("Inferior");
//        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
//
//
//        HBox topBar = new HBox(title);
//        topBar.setStyle("-fx-background-color: #1a1a1a; -fx-border-color: #2a2a2a; -fx-border-width: 0 0 1 0;");
//
//        // Left SIDEBAR
//        Button homeBtn = new Button("⌂ Home");
//        Button profileBtn = new Button("👤  Profile");
//        Button settingsBtn = new Button("⚙   Settings");
//        Button logoutBtn = new Button("⏻ Log Out");
//
//        for (Button btn : new Button[]{homeBtn, profileBtn, settingsBtn, logoutBtn}) {
//            btn.setMaxWidth(Double.MAX_VALUE);
//            btn.setStyle("-fx-text-fill: black; " +
//                    "-fx-font-size: 14px; -fx-padding: 12 16;");
//        }
//
//        homeBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.LOGIN));
//        profileBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.PROFILE));
//        settingsBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.SETTINGS));
//        logoutBtn.setOnAction(e -> SceneManager.getInstance().navigateTo(SceneType.LOGIN));
//
//
//        VBox sidebar = new VBox();
//        sidebar.setPrefWidth(200);
//        sidebar.setStyle("-fx-background-color: #1a1a1a; -fx-border-color: #2a2a2a; -fx-border-width: 0 1 0 0;");
//
//        // SideBar Buttons
////        Button homeBtn = new Button("🏠  Home");
////        Button profileBtn = new Button("👤  Profile");
////        Button settingsBtn = new Button("⚙️   Settings");
////        Button logoutBtn = new Button("↩  Log Out");
//
//        //Buttons Funtionality
//        homeBtn.setOnAction(e ->
//                SceneManager.getInstance().navigateTo(SceneType.SIGNUP));
////                stage.setScene(create(SceneType.SIGNUP, stage)));
//        homeBtn.setMaxWidth(Double.MAX_VALUE);
////        profileBtn.setMaxWidth(Double.MAX_VALUE);
////        profileBtn.setOnAction(e ->
////                stage.setScene(create(SceneType.PROFILE, stage)));
//
//        settingsBtn.setMaxWidth(Double.MAX_VALUE);
//
//
//        logoutBtn.setMaxWidth(Double.MAX_VALUE);
//        logoutBtn.setOnAction(e ->
//                stage.close());
//
//        StackPane mainContent = new StackPane();
//        mainContent.setStyle("-fx-background-color: #141414;");
//        BorderPane root = new BorderPane();
//
//        root.setTop(topBar);
//        root.setLeft(sidebar);
//        root.setCenter(mainContent);
//
//        VBox layout = new VBox(25, title, homeBtn, profileBtn, settingsBtn, logoutBtn);
//        layout.setAlignment(Pos.CENTER);
//        return new Scene(layout, 800, 600);
//    }
}
