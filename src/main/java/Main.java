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

    public static UserManager userManager;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage){

        DatabaseManager.getInstance();
        userManager = UserManager.getInstance();
//        userManager = new UserManager(new UserDAO());
        SceneManager.init(stage); //initialize singleton
        SceneManager.getInstance().navigateTo(SceneType.LOGIN);
        stage.setTitle("Inferior app");
//        stage.setScene(scenes.SceneFactory.create(SceneType.LOGIN, stage));
//        stage.setFullScreen(true);
        stage.show();
    }
}