import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Inferior
 * created: 5/4/26
 * @since Assignment: App
 **/
public class SignupController {
    private final DatabaseManager db = DatabaseManager.getInstance();

    public Scene buildScene() {
                Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
        title.setAlignment(Pos.TOP_CENTER);

                Label signUp = new Label("Create account");
        signUp.setStyle("-fx-font-size:20px; -fx-font-weight: bold;");
        signUp.setAlignment(Pos.CENTER_RIGHT);

                TextField usernameField = new TextField();
        GridPane textLayout = new GridPane();
        usernameField.setPromptText("Username");
        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

                Button signupButton = new Button("     Sign Up     ");
        signupButton.setStyle("-fx-border-color: red;");
        Label status = new Label();
        signupButton.setOnAction(e-> {
            if(usernameField.getText().isEmpty()||passwordField.getText().isEmpty()){
                status.setText("Please fill out all fields");
                return;
            }
            db.insertItems(usernameField.getText(), passwordField.getText());

            SceneManager.getInstance().navigateTo(SceneType.LOGIN);
        });
        textLayout.add(usernameField, 0, 0);
        textLayout.add(passwordField, 0, 1);
        textLayout.add(status, 0, 2);
        textLayout.setAlignment(Pos.CENTER);

                Button backTologinpage = new Button("Back to Login");
        backTologinpage.setOnAction(e->
                SceneManager.getInstance().navigateTo(SceneType.LOGIN));
        backTologinpage.setAlignment(Pos.BOTTOM_RIGHT);

        VBox layout = new VBox(25, title, signUp, textLayout, signupButton,backTologinpage);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);

    }
//    public static Scene buildSIGNUPScene(Stage stage){
//        DatabaseManager db = DatabaseManager.getInstance();
//        //Only gets called when user clicks on Sign Up with a new page
//
//
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
}
