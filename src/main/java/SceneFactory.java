/**
 * created: 4/21/26
 * @since Assignment: Inferior
 **/
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.awt.*;

public class SceneFactory {

//    method is the public entry point method creates scene by SceneType in enum class

    public static Scene create(SceneType type, Stage stage){
        return switch(type){
            case LOGIN -> buildLoginScene(stage);
            case SIGNUP -> buildSIGNUPScene(stage);
            case MAIN -> buildMAINScene(stage);
            case Profile -> buildProfilePage(stage);
        };
    }

    private static Scene buildLoginScene(Stage stage){
        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
        title.setAlignment(Pos.TOP_CENTER);

        Label logWelcome = new Label("Log into Inferior");
        logWelcome.setStyle("-fx-font-size:20px; -fx-font-weight: bold;");
        logWelcome.setAlignment(Pos.CENTER_LEFT);

        Button loginbutton = new Button( "      Log in     ");
        Button signinButton = new Button("      Sign up     ");
        signinButton.setOnAction(e ->
                stage.setScene(create(SceneType.SIGNUP, stage)));
        loginbutton.setOnAction(e ->
                stage.setScene((create(SceneType.MAIN, stage)))
        );
        GridPane textLayout = new GridPane();
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        textLayout.add(usernameField, 0, 0);
        textLayout.add(passwordField, 0, 1);
        textLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(25, title, logWelcome, textLayout, loginbutton, signinButton);
        layout.setAlignment(Pos.CENTER);

        return new Scene(layout, 800, 600);
    }

    public static Scene buildSIGNUPScene(Stage stage){
        //Only gets called when user clicks on Sign Up with a new page
        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
        title.setAlignment(Pos.TOP_CENTER);

        Label signUp = new Label("Create account");
        signUp.setStyle("-fx-font-size:20px; -fx-font-weight: bold;");
        signUp.setAlignment(Pos.CENTER_RIGHT);

        Button signupButton = new Button("     Sign Up     ");
        signupButton.setStyle("-fx-border-color: red;");
        Button loginpage = new Button("Login page");
        loginpage.setOnAction(e->
                stage.setScene(create(SceneType.LOGIN,stage)));
        loginpage.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane textLayout = new GridPane();
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        textLayout.add(usernameField, 0, 0);
        textLayout.add(passwordField, 0, 1);
        textLayout.setAlignment(Pos.CENTER);
//        textLayout.add(new TextField("Username"), 0, 0);
//        textLayout.add(new TextField("Password"),0, 1);
//        textLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(25, title, signUp, textLayout, signupButton,loginpage);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);
    }
    public static Scene buildMAINScene(Stage stage){
        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");

        HBox topBar = new HBox(title);
        topBar.setStyle("-fx-background-color: #1a1a1a; -fx-border-color: #2a2a2a; -fx-border-width: 0 0 1 0;");

        // SIDEBAR
        VBox sidebar = new VBox();
        sidebar.setPrefWidth(200);
        sidebar.setStyle("-fx-background-color: #1a1a1a; -fx-border-color: #2a2a2a; -fx-border-width: 0 1 0 0;");
        // SideBar Buttons
        Button homeBtn     = new Button("🏠  Home");
        Button profileBtn  = new Button("👤  Profile");
        Button settingsBtn = new Button("⚙️   Settings");
        Button logoutBtn   = new Button("↩  Log Out");

        //Buttons Funtionality
        homeBtn.setOnAction(e->
                stage.setScene(create(SceneType.SIGNUP,stage)));
        homeBtn.setMaxWidth(Double.MAX_VALUE);


        profileBtn.setMaxWidth(Double.MAX_VALUE);
        profileBtn.setOnAction(e ->
                stage.setScene(create(SceneType.Profile, stage)));

        settingsBtn.setMaxWidth(Double.MAX_VALUE);


        logoutBtn.setMaxWidth(Double.MAX_VALUE);
        logoutBtn.setOnAction(e ->
                stage.close());

        StackPane mainContent = new StackPane();
        mainContent.setStyle("-fx-background-color: #141414;");
        BorderPane root = new BorderPane();

        root.setTop(topBar);
        root.setLeft(sidebar);
        root.setCenter(mainContent);

        VBox layout = new VBox(25, title,homeBtn,profileBtn,settingsBtn,logoutBtn);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);
    }
    public static Scene buildProfilePage(Stage stage){
        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");

        Circle circle = new Circle(50);
        circle.setFill(Color.WHITE);


        Rectangle box = new Rectangle(200, 100);
        box.setFill(Color.WHITE);

        Button home = new Button("Home");
        home.setOnAction(e ->
                stage.setScene(create(SceneType.MAIN, stage)));
        home.setAlignment(Pos.BOTTOM_RIGHT);

        VBox layout = new VBox(20, title, circle, box, home);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);
    }

}
