/**
 * @author Freddy Sotelo
 * created: 5/4/26
 * @since Assignment: App
 **/
import javafx.scene.control.Label;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;


public class LoginTest extends ApplicationTest{
    @Override
    public void start(Stage stage){
        SceneManager.init(stage);
        SceneManager.getInstance().navigateTo(SceneType.LOGIN);
        stage.show();

    }
    @Test
    public void testUserNotInDatabase(){
        clickOn("#usernameField").write("test");
        clickOn("#passwordField").write("test");
        clickOn("#loginButton");
        boolean user = new UserDAO().userLogin("test","test");
        assertFalse(user);
    }
     @Test
    public void testBlankEntries(){
         clickOn("#usernameField").write("test");
         clickOn("#passwordField").write("test");
         clickOn("#loginButton");
         verifyThat("#loginStatus", hasText("Incorrect username or password"));

     }
    @Test
    void testSignupButtonExists() {
        verifyThat("#signinButton", hasText("      Sign up page    "));
    }
    @Test
    void testLoginButtonExists() {
        verifyThat("#loginButton", hasText("      Log in     "));
    }

}
