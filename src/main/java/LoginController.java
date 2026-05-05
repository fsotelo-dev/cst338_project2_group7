import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LoginController {
    private final UserManager userManager = UserManager.getInstance();
    public Scene buildScene(){
//            UserManager userManager = UserManager.getInstance();
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

//                UserDAO dbFunction = new UserDAO();
                boolean loggedIn = userManager.login(username, password);
//                boolean loggedIn = dbFunction.userLogin(username, password);

                if (loggedIn) {
                    SceneManager.getInstance().navigateTo(SceneType.MAIN);
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

    }

//    public static Scene buildScene(){
//            DatabaseManager db = DatabaseManager.getInstance();
//            Label title = new Label("Inferior");
//            title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
//            title.setAlignment(Pos.TOP_CENTER);
//
//            Label logWelcome = new Label("Log into Inferior");
//            logWelcome.setStyle("-fx-font-size:20px; -fx-font-weight: bold;");
//            logWelcome.setAlignment(Pos.CENTER_LEFT);
//
//            //FOR TESTING PURPOSES
//            Button test = new Button("Test");
//            test.setOnAction(e ->
//                    SceneManager.getInstance().navigateTo(SceneType.MAIN));
//            test.setAlignment(Pos.TOP_LEFT);
//
//            GridPane textLayout = new GridPane();
//            TextField usernameField = new TextField();
//            usernameField.setPromptText("Username");
//
//            TextField passwordField = new PasswordField();
//            passwordField.setPromptText("Password");
//
//            Button loginbutton = new Button( "      Log in     ");
//            Button signinButton = new Button("      Sign up page    ");
//            signinButton.setOnAction(e ->
//                    SceneManager.getInstance().navigateTo(SceneType.SIGNUP));
//
//            Label loginStatus = new Label();
//            loginbutton.setOnAction(e -> {
//                String username = usernameField.getText();
//                String password = passwordField.getText();
//
//                UserDAO dbFunction = new UserDAO(db.getConnection());
//                boolean loggedIn = dbFunction.userLogin(username, password);
//
//                if (loggedIn) {
//                    SceneManager.getInstance().navigateTo(SceneType.MAIN);
////                stage.setScene((create(SceneType.MAIN, stage)));
//                }else{
//                    loginStatus.setText("Incorrect username or password");
//                }
//            });
//
//            textLayout.add(usernameField, 0, 0);
//            textLayout.add(passwordField, 0, 1);
//            textLayout.add(loginStatus, 0, 2);
//            textLayout.setAlignment(Pos.CENTER);
//
//            VBox layout = new VBox(25, title, logWelcome, textLayout, loginbutton, signinButton,test);
//            layout.setAlignment(Pos.CENTER);
//
//            return new Scene(layout, 800, 600);
//

}
