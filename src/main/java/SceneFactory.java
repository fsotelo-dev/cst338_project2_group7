/**
 * created: 4/21/26
 * @since Assignment: Inferior
 **/

import javafx.stage.Stage;
import javafx.scene.Scene;

public class SceneFactory{
//    method is the public entry point method creates scene by SceneType in enum class
    public static Scene create(SceneType type, Stage stage){
        return switch(type){
            case LOGIN -> new LoginController().buildScene();
            case SIGNUP -> new SignupController().buildScene();
            case MAIN -> new MainController().buildScene();
            case PROFILE -> new ProfileController().buildScene();
            case SETTINGS -> new SettingController().buildScene();
            case POST -> new PostController().buildScene();
            case COMMENT -> new CommentController().buildScene();
            case LOGOUT -> new LogoutController().buidScene();
            case CREATE_POST -> new CreatePostController().buildScene();
        };
    }
}
