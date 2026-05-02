/**
 * @author Freddy Sotelo
 * created: 4/20/26
 * @since Assignment: Default (Template) Project
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javafx.application.Application;
import javafx.stage.Stage;

//private DatabaseManager db;

public class Main extends Application{
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage){
        SceneManager.init(stage); //initialize singleton
        SceneManager.getInstance().navigateTo(SceneType.LOGIN);
        stage.setTitle("Inferior app");
//        stage.setScene(SceneFactory.create(SceneType.LOGIN, stage));
//        stage.setFullScreen(true);
        stage.show();
    }
}