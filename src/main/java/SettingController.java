import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SettingController {
    @FXML
    private TextField usernameField; //passed in

    @FXML
    private PasswordField oldPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label status;


/**
 * Passed in user from SceneFactory to update usernameField
 * able display on UI
 * User is from userManager class.
 */
//    public void setuser(User user){
//
//    }
}
