import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.EnumMap;
import java.util.Map;


/**
 * without this it creates a Scene from scratch
 */
public class SceneManager {
    private static SceneManager instance;

    private final Stage stage;
    private final Map<SceneType, Scene> cache =
            new EnumMap<>(SceneType.class);
    /**
     * singleton but doesn't have to be
     */
    private SceneManager(Stage stage){
        this.stage = stage;
    }
    public static void init(Stage stage){
        if(instance == null) instance = new SceneManager(stage);
    }

    public static SceneManager getInstance(){
        if(instance==null) {
            throw new IllegalStateException
                    ("SceneManager not initialized");
        }
        return instance;
    }
    public void navigateTo(SceneType type){

        Scene scene = SceneFactory.create(type, stage);
        stage.setScene(scene);
    }
}
