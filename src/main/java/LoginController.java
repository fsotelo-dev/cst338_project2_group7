import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LoginController {
    private final UserManager userManager = UserManager.getInstance();
    public Scene buildScene(){
            Image logo = new Image(getClass().getResource("/ImagesInferior/logo3.png").toExternalForm());
            ImageView logoView = new ImageView(logo);
            logoView.setFitWidth(320);
            logoView.setPreserveRatio(true);
            logoView.setSmooth(true);

            //Label logWelcome = new Label("Log into Inferior");
            //logWelcome.setStyle("-fx-font-size:20px; -fx-font-weight: bold; -fx-text-fill: red");
            //logWelcome.setAlignment(Pos.CENTER_LEFT);

            //FOR TESTING PURPOSES
            Button test = new Button("Test");
            test.setOnAction(e ->
                    SceneManager.getInstance().navigateTo(SceneType.MAIN));
            test.setAlignment(Pos.TOP_LEFT);

            GridPane textLayout = new GridPane();
            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");
            usernameField.setStyle("-fx-text-fill: black");

            TextField passwordField = new PasswordField();
            passwordField.setPromptText("Password");
            passwordField.setStyle("-fx-text-fill: black");

            Button loginbutton = new Button( "      Log in     ");
            loginbutton.setStyle("-fx-border-color: red;");
            Button signinButton = new Button("      Sign up page    ");
            signinButton.setStyle("-fx-border-color: red;");
            signinButton.setOnAction(e ->
                    SceneManager.getInstance().navigateTo(SceneType.SIGNUP));

            Label loginStatus = new Label();
            loginbutton.setOnAction(e -> {
                String username = usernameField.getText();
                String password = passwordField.getText();

                boolean loggedIn = userManager.login(username, password);

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

            VBox layout = new VBox(25,logoView, textLayout, loginbutton, signinButton,test);
            layout.setStyle("-fx-background-color: #090909");
            layout.setAlignment(Pos.CENTER);

            return new Scene(layout, 800, 600);

    }
}
