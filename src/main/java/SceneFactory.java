/**
 * created: 4/21/26
 * @since Assignment: Inferior
 **/
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SceneFactory {

//    method is the public entry point method creates scene by SceneType in enum class

    public static Scene create(SceneType type, Stage stage){
        return switch(type){
            case LOGIN -> buildLoginScene(stage);
//            case MAIN -> buildMAINScene(stage);
        };
    }
    private static Scene buildLoginScene(Stage stage){
        Label title = new Label("Inferior");
        title.setStyle("-fx-font-size:50px; -fx-font-weight: bold;");
        title.setAlignment(Pos.TOP_CENTER);

        Label logWelcome = new Label("Log into Inferior");
        logWelcome.setStyle("-fx-font-size:20px; -fx-font-weight: bold;");
        logWelcome.setAlignment(Pos.CENTER_LEFT);

        Button loginbutton = new Button( "      Log in     ");
        Button signinButton = new Button("      Sign up     ");
//        loginbutton.setOnAction(e ->
//                stage.setScene((create(SceneType.MAIN, stage)))
//        );
        GridPane textLayout = new GridPane();
        textLayout.add(new TextField("Username"), 0, 0);
        textLayout.add(new TextField("Password"),0, 1);
        textLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(25, title, logWelcome, textLayout, loginbutton, signinButton);
        layout.setAlignment(Pos.CENTER);

        return new Scene(layout, 800, 600);
    }



}
