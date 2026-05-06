import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Inferior
 * created: 5/4/26
 * @since Assignment: App
 **/
public class SignupController {
//    private final DatabaseManager db = DatabaseManager.getInstance();
    private final UserManager userManager = UserManager.getInstance();


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

        Label incomeChoice = new Label("Income Range:");
        incomeChoice.setStyle("-fx-font-size: 14px;");

        ChoiceBox<String> incomeBox = new ChoiceBox<>();
        incomeBox.getItems().addAll("Low", "Middle", "High");
        incomeBox.setValue("Low");
        incomeBox.setStyle("-fx-font-size:14px; -fx-text-fill: white");

        Label status = new Label();
        status.setStyle("-fx-text-fill: orange;");

                Button signupButton = new Button("     Sign Up     ");
        signupButton.setStyle("-fx-border-color: orange;");
        signupButton.setOnAction(e-> {
            if(usernameField.getText().isEmpty()||passwordField.getText().isEmpty()){
                status.setText("Please fill out all fields");
                return;
            }

            String selectedIncome = incomeBox.getValue();
            if(selectedIncome == null){
                status.setText("Please select an income range");
                return;
            }

            userManager.signup(usernameField.getText(), passwordField.getText(), selectedIncome);

            SceneManager.getInstance().navigateTo(SceneType.LOGIN);
        });
        textLayout.add(usernameField, 0, 0);
        textLayout.add(passwordField, 0, 1);
        textLayout.add(incomeChoice,   0, 2);  // ← income label
        textLayout.add(incomeBox,     0, 3);  // ← income dropdown
        textLayout.add(status,        0, 4);
        textLayout.setAlignment(Pos.CENTER);

                Button backTologinpage = new Button("Back to Login");
        backTologinpage.setOnAction(e->
                SceneManager.getInstance().navigateTo(SceneType.LOGIN));
        backTologinpage.setAlignment(Pos.BOTTOM_RIGHT);

        VBox layout = new VBox(25, title, signUp, textLayout, signupButton,backTologinpage);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: red");
        return new Scene(layout, 800, 600);

    }

}
