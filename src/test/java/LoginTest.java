/**
 * @author Freddy Sotelo
 * created: 5/4/26
 * @since Assignment: App
 **/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.stage.Stage;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;


public class LoginTest extends ApplicationTest{
    @Override
    public void start(Stage stage){
        SceneManager.init(stage);
        SceneManager.getInstance().navigateTo(SceneType.LOGIN);
        stage.show();
    }

    @Test
    void testButtonClickededON(){
        clickOn("loginBtn");
        verifyThat("loginBtn", hasText("Login"));
    }

    @Test
    void testLoginSuccess(){
        clickOn("usernameField").write("admin");
        clickOn("passwordField").write("12345");
        clickOn("loginBtn");

        verifyThat("loginBtn",hasText("Login successful"));

    }
    @Test
    void testInvalidLoginShowsErrorMessage() {
        clickOn("usernameField").write("wrongUser");
        clickOn("passwordField").write("wrongPass");
        clickOn("loginButton");

        verifyThat("loginStatus", hasText("Incorrect username or password"));
    }
}
