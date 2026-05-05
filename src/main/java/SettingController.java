import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class SettingController {

    private final UserManager userManager = UserManager.getInstance(); ;


    public Scene buildScene(){
//        TITLE
        Label settingLabel = new Label("Setting");
        settingLabel.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");

//        Username display (current)
        Label currentUsernameLabel = new Label("Current Username: " + userManager.getCurrentUser());
        currentUsernameLabel.setStyle("-fx-text-fill: white; -fx-padding: 16px;");
//        username update field
        TextField newUsername = new TextField();
        newUsername.setPromptText("Enter new username");
        newUsername.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");

        Button updateUsernameBtn = new Button("Update Username");
        updateUsernameBtn.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");

        Label usernameMessage = new Label("");
        usernameMessage.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
//        update button
        updateUsernameBtn.setOnAction(e->
                handleUpdate(newUsername, usernameMessage, currentUsernameLabel));

//        password update field



//       back Button
        Button backBtn = new Button ("back");
        backBtn.setOnAction(e-> {
            SceneManager.getInstance().navigateTo(SceneType.MAIN);
        });

        VBox layout = new VBox(20, settingLabel, currentUsernameLabel,newUsername,updateUsernameBtn,usernameMessage,backBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #141414");
        return new Scene(layout, 800, 600);

    }

    public void handleUpdate(TextField newUsername, Label usernameMessage, Label currentUsernameLabel){
        if(newUsername.getText().trim().isEmpty()){
            usernameMessage.setText("Username cannot be Empty!");
            return;
        }
        boolean successfulUpdate = userManager.updateUsername(newUsername.getText().trim());
        if(successfulUpdate){
            usernameMessage.setStyle("-fx-text-fill: #4CAF50;");
            usernameMessage.setText("Username updated successfully!");
            currentUsernameLabel.setText("Current Username: " + userManager.getCurrentUser());
        }else{
            usernameMessage.setStyle("-fx-text-fill: red;");
            usernameMessage.setText("Failed to update | Username taken");
        }
    }




//    @FXML
//    private TextField usernameField; //passed in
//
//    @FXML
//    private PasswordField oldPassword;
//    @FXML
//    private PasswordField newPassword;
//    @FXML
//    private PasswordField confirmPassword;
//    @FXML
//    private Label status;


/**
 * Passed in user from SceneFactory to update usernameField
 * able display on UI
 * User is from userManager class.
 */
//    public void setuser(User user){
//
//    }
}
