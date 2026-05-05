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

        Circle circle = new Circle(43);
        circle.setFill(Color.BLACK);

        javafx.scene.image.Image image = new Image("https://random-d.uk/api/randomimg");
        ImageView imageViewer = new ImageView(image);
        imageViewer.setFitWidth(80);
        imageViewer.setFitHeight(80);

        Circle clip = new Circle(40,40,40);
        imageViewer.setClip(clip);
        StackPane profilePic = new StackPane(circle, imageViewer);
        DatabaseManager db = DatabaseManager.getInstance();

        Rectangle box = new Rectangle(200, 100);
        box.setFill(Color.WHITE);
        Button settingsBtn = new Button("Settings");
        settingsBtn.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.SETTINGS));
        db.insertTestPost(1);
        int postCount = db.getUserPostCount(1);
        Label postNumber = new Label(String.valueOf(postCount));
        Label post = new Label("Post: ");
        VBox Post = new VBox(5,post,postNumber);

        Post.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");
        Post.setAlignment(Pos.CENTER);

        Button home = new Button("Home");
        home.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.MAIN));
        home.setAlignment(Pos.BOTTOM_RIGHT);

        VBox layout = new VBox(20, title, profilePic, settingsBtn,Post,home);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);
    }
}
