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

    private final UserManager userManager = UserManager.getInstance();



    public Scene buildScene() {
//        TITLE
        Label settingLabel = new Label("Inferior");
        settingLabel.setStyle("-fx-font-size: 35px; -fx-padding: 10; -fx-text-fill: white; -fx-font-weight: bold;");

//        Username display (current)
        Label currentUsernameLabel = new Label("Current Username: " + userManager.getCurrentUser());
        currentUsernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");

        Label currentPasswordLabel = new Label("Current Password: " + userManager.getCurrentUserPassword());
        currentPasswordLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");

//        username update field
        TextField newUsername = new TextField();
        newUsername.setPromptText("Enter new username");
        newUsername.setStyle("-fx-font-size: 16px; -fx-padding: 10 10;");

        TextField newPassword = new TextField();
        newPassword.setPromptText("Enter new password");
        newPassword.setStyle("-fx-font-size: 16px; -fx-padding: 10 10;");

        Button updatePasswordBtn = new Button("Update Password");
        updatePasswordBtn.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        Button updateUsernameBtn = new Button("Update Username");
        updateUsernameBtn.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        Button backBtn = new Button("back");
        backBtn.setStyle("-fx-font-size: 16px; -fx-padding: 10 65;");

        Label usernameMessage = new Label("");
        usernameMessage.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
        Label passwordMessage = new Label("");
        passwordMessage.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
//        update button




        updateUsernameBtn.setOnAction(e ->
                handleUpdate(newUsername, usernameMessage, currentUsernameLabel));
//        password update field
        updatePasswordBtn.setOnAction(e ->
                handlePasswordUpdate(newPassword, passwordMessage, currentPasswordLabel));
//       back Button
        backBtn.setOnAction(e -> {
            SceneManager.getInstance().navigateTo(SceneType.MAIN);
        });
        VBox layout = new VBox(20, settingLabel, currentUsernameLabel, currentPasswordLabel, newUsername, newPassword,
                updateUsernameBtn, updatePasswordBtn, usernameMessage, passwordMessage, backBtn);
        layout.setAlignment(Pos.CENTER);

        layout.setStyle("-fx-background-color: #141414");
        return new Scene(layout, 800, 600);
    }


    public void handleUpdate(TextField newUsername, Label usernameMessage, Label currentUsernameLabel) {
        if (newUsername.getText().trim().isEmpty()) {
            usernameMessage.setText("Username cannot be Empty!");
            return;
        }
        boolean successfulUpdate = userManager.updateUsername(newUsername.getText().trim());
        if (successfulUpdate) {
            usernameMessage.setStyle("-fx-text-fill: #4CAF50;");
            usernameMessage.setText("Username updated successfully!");
            currentUsernameLabel.setText("Current Username: " + userManager.getCurrentUser());
        } else {
            usernameMessage.setStyle("-fx-text-fill: red;");
            usernameMessage.setText("Failed to update | Username taken");
        }
    }

    public void handlePasswordUpdate(TextField newPassword, Label passwordMessage, Label currentPasswordLabel) {
        if (newPassword.getText().trim().isEmpty()) {
            passwordMessage.setText("Password cannot be Empty!");
            return;
        }
        boolean successfulUpdate = userManager.updatePassword(newPassword.getText().trim());
        if (successfulUpdate) {
            passwordMessage.setStyle("-fx-text-fill: #4CAF50;");
            passwordMessage.setText("Password updated successfully!");
            currentPasswordLabel.setText("Current Password: " + userManager.getCurrentUserPassword());
        } else {
            passwordMessage.setStyle("-fx-text-fill: red;");
            passwordMessage.setText("Failed to update | Password taken");
        }
    }
}


