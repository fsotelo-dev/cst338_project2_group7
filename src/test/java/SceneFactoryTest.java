import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Angel Magana
 * created: 4/26/26
 * @since Assignment: INFERIOR APP
 **/
public class SceneFactoryTest {

    @BeforeEach
    public void setUo(){
        try{
            Platform.startup(() -> {});
        } catch (IllegalStateException e){

        }
    }

    @Test
    public void testLogIn(){
        Stage stage = new Stage();
        Scene logIn = SceneFactory.create(SceneType.LOGIN, stage);
        assertNotNull(logIn);

    }
    @Test
    public void testSignIn(){
        Stage stage = new Stage();
        Scene signIN = SceneFactory.create(SceneType.SIGNUP, stage);
        assertNotNull(signIN);

    }
    @Test
    public void testMain(){
        Stage stage = new Stage();
        Scene main = SceneFactory.create(SceneType.MAIN, stage);
        assertNotNull(main);

    }
    @Test
    public void testProfile(){
        Stage stage = new Stage();
        Scene profile = SceneFactory.create(SceneType.SIGNUP, stage);
        assertNotNull(profile);

    }
    @Test
    //Compare the contents of the scenes
    public void testNotEqualSignInLogIn(){
        Stage stage = new Stage();
        Scene logIn = SceneFactory.create(SceneType.LOGIN, stage);
        Scene signUp = SceneFactory.create(SceneType.SIGNUP, stage);
        assertEquals(logIn.getRoot().getClass(), signUp.getRoot().getClass());
    }
    @Test
    public void testLogInTitle() {
        Stage stage = new Stage();
        Scene login = SceneFactory.create(SceneType.LOGIN, stage);
        VBox root = (VBox) login.getRoot();
        Label title = (Label) root.getChildren().get(1); //first spot has title
        assertEquals("Inferior", title.getText());
    }

}
