/**
 * created: 4/21/26
 * @since Assignment: Inferior
 **/
import javafx.stage.Stage;
import javafx.scene.Scene;

public class SceneFactory {

//    method is the public entry point method creates scene by SceneType in enum class

    public static Scene create(SceneType type, Stage stage){
        return switch(type){
            case LOGIN -> buildLoginScene(stage);
        };
    }



}
