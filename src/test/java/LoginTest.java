/**
 * @author Freddy Sotelo
 * created: 5/4/26
 * @since Assignment: App
 **/
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class LoginTest extends ApplicationTest{
    @Override
    public void start(Stage stage){
        SceneManager.getInstance().navigateTo(SceneType.LOGIN);
    }

    @Test
    void loginScene_hasTitle(){
        verifyThat("Inferior", hasText("Inferior"));
    }
}
