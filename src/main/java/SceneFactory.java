/**
 * created: 4/21/26
 * @since Assignment: Inferior
 **/
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class SceneFactory{
//    method is the public entry point method creates scene by SceneType in enum class
    public static Scene create(SceneType type, Stage stage){
        return switch(type){
            //ase LOGIN -> buildLoginScene(stage);
            case LOGIN -> new LoginController().buildScene();
            case SIGNUP -> new SignupController().buildScene();
            case MAIN -> new MainController().buildScene();
//            case MAIN -> buildMAINScene(stage);
            case PROFILE -> buildProfilePage(stage);
            case SETTINGS -> new SettingController().buildScene();
//                    buildSettingPage(stage);
            case POST -> buildPostScene(stage);
        };
    }

    public static Scene buildLoginScene(Stage stage) {
//            DatabaseManager db = DatabaseManager.getInstance();
            Label title = new Label("Inferior");
            title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
            title.setAlignment(Pos.TOP_CENTER);

            Label logWelcome = new Label("Log into Inferior");
            logWelcome.setStyle("-fx-font-size:20px; -fx-font-weight: bold;");
            logWelcome.setAlignment(Pos.CENTER_LEFT);

            //FOR TESTING PURPOSES
            Button test = new Button("Test");
            test.setOnAction(e ->
                    SceneManager.getInstance().navigateTo(SceneType.MAIN));
            test.setAlignment(Pos.TOP_LEFT);

            GridPane textLayout = new GridPane();
            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");

            TextField passwordField = new PasswordField();
            passwordField.setPromptText("Password");

            Button loginbutton = new Button( "      Log in     ");
            Button signinButton = new Button("      Sign up page    ");
            signinButton.setOnAction(e ->
                    SceneManager.getInstance().navigateTo(SceneType.SIGNUP));

            Label loginStatus = new Label();
            loginbutton.setOnAction(e -> {
                String username = usernameField.getText();
                String password = passwordField.getText();

                UserDAO dbFunction = new UserDAO();
                boolean loggedIn = dbFunction.userLogin(username, password);

                if (loggedIn) {
                    SceneManager.getInstance().navigateTo(SceneType.MAIN);
//                stage.setScene((create(SceneType.MAIN, stage)));
                }else{
                    loginStatus.setText("Incorrect username or password");
                }
            });

            textLayout.add(usernameField, 0, 0);
            textLayout.add(passwordField, 0, 1);
            textLayout.add(loginStatus, 0, 2);
            textLayout.setAlignment(Pos.CENTER);

            VBox layout = new VBox(25, title, logWelcome, textLayout, loginbutton, signinButton,test);
            layout.setAlignment(Pos.CENTER);

            return new Scene(layout, 800, 600);
//
    }

//    public static Scene buildSIGNUPScene(Stage stage){
//        DatabaseManager db = DatabaseManager.getInstance();
//        //Only gets called when user clicks on Sign Up with a new page
//        Label title = new Label("Inferior");
//        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
//        title.setAlignment(Pos.TOP_CENTER);
//
//        Label signUp = new Label("Create account");
//        signUp.setStyle("-fx-font-size:20px; -fx-font-weight: bold;");
//        signUp.setAlignment(Pos.CENTER_RIGHT);
//
//        TextField usernameField = new TextField();
//        GridPane textLayout = new GridPane();
//        usernameField.setPromptText("Username");
//        TextField passwordField = new PasswordField();
//        passwordField.setPromptText("Password");
//
//        Button signupButton = new Button("     Sign Up     ");
//        signupButton.setStyle("-fx-border-color: red;");
//        Label status = new Label();
//        signupButton.setOnAction(e-> {
//            if(usernameField.getText().isEmpty()||passwordField.getText().isEmpty()){
//                status.setText("Please fill out all fields");
//                return;
//            }
//            db.insertItems(usernameField.getText(), passwordField.getText());
//
//            SceneManager.getInstance().navigateTo(SceneType.LOGIN);
////            stage.setScene(create(SceneType.LOGIN, stage));
//        });
//        textLayout.add(usernameField, 0, 0);
//        textLayout.add(passwordField, 0, 1);
//        textLayout.add(status, 0, 2);
//        textLayout.setAlignment(Pos.CENTER);
//
//        Button backTologinpage = new Button("Back to Login");
//        backTologinpage.setOnAction(e->
//
//                SceneManager.getInstance().navigateTo(SceneType.LOGIN));
////                stage.setScene(create(SceneType.LOGIN,stage)));
//        backTologinpage.setAlignment(Pos.BOTTOM_RIGHT);
//
//        VBox layout = new VBox(25, title, signUp, textLayout, signupButton,backTologinpage);
//        layout.setAlignment(Pos.CENTER);
//        return new Scene(layout, 800, 600);
//    }
    public static Scene buildProfilePage(Stage stage){
        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");

        Circle circle = new Circle(50);
        circle.setFill(Color.WHITE);

        DatabaseManager db = DatabaseManager.getInstance();

        Rectangle box = new Rectangle(200, 100);
        box.setFill(Color.WHITE);
        Label Post = new Label("Post: "+db.getUserPostCount(2));
        StackPane infoBox = new StackPane(box, Post);
        infoBox.setAlignment(Pos.CENTER);

        Button home = new Button("Home");
        home.setOnAction(e ->
                stage.setScene(create(SceneType.MAIN, stage)));
        home.setAlignment(Pos.BOTTOM_RIGHT);

        VBox layout = new VBox(20, title, circle, infoBox, home);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);
    }

    public static Scene buildSettingPage(Stage stage){
        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");

        Button home = new Button("Home");
        home.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.MAIN));
        home.setAlignment(Pos.BOTTOM_RIGHT);

        VBox layout = new VBox(20, title, home);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);
    }

    public static Scene buildPostScene(Stage stage) {
        try {
            FXMLLoader load = new FXMLLoader(SceneFactory.class.getResource("/PostScene.fxml"));
            return new Scene(load.load(), 800, 600);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
