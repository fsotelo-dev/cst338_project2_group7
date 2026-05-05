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

    public Scene buildScene(){
        Label settingLabel = new Label("Setting");
        settingLabel.setStyle("-fx-text-fill: 16px; -fx-padding: 10 20;");


        Button backBtn = new Button ("back");
        backBtn.setOnAction(e-> {
            SceneManager.getInstance().navigateTo(SceneType.MAIN);
        });

        VBox layout = new VBox(25, backBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #141414");
        return new Scene(layout, 800, 600);
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
