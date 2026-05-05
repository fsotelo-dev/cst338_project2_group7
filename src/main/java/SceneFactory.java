/**
 * created: 4/21/26
 * @since Assignment: Inferior
 **/
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.Objects;

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
        };
    }
}
