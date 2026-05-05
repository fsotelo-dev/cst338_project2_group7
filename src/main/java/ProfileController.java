import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author Freddy Sotelo
 * created: 5/4/26
 * @since Assignment: App
 **/
public class ProfileController {
    public ProfileController() {

    }
    public static Scene buildScene(){

        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");


        Circle avatarBackground = new Circle(43);
        avatarBackground.setFill(Color.BLACK);

        Image avatarImage = new Image("https://random-d.uk/api/randomimg");
        ImageView avatarView = new ImageView(avatarImage);
        avatarView.setFitWidth(80);
        avatarView.setFitHeight(80);
        avatarView.setClip(new Circle(40, 40, 40));

        StackPane profilePic = new StackPane(avatarBackground, avatarView);

        String currentUser = UserManager.getInstance().getCurrentUser();
        Label helloLabel = new Label("Hello, " + currentUser + "!");
        helloLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        int postCount = DatabaseManager.getInstance().getUserPostCount();

        Label postCountLabel = new Label("Posts: " + postCount);
        postCountLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");


        Button settingsBtn = new Button("Settings");
        settingsBtn.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.SETTINGS));

        Button homeBtn = new Button("Home");
        homeBtn.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.MAIN));


        VBox layout = new VBox(20, title, profilePic, helloLabel, postCountLabel, settingsBtn, homeBtn);
        layout.setAlignment(Pos.CENTER);

        return new Scene(layout, 800, 600);
    }

}
