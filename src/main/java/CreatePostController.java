import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreatePostController {

    @FXML
    private TextField titleInput;

    @FXML
    private TextArea bodyInput;

    @FXML
    public void createPost() {
        String title = titleInput.getText();
        String body = bodyInput.getText();

        if(title == null || title.isEmpty() || body.isEmpty()) {
            return;
        }

        System.out.println("Title: " + title);
        System.out.println("Body: " + body);

        SceneManager.getInstance().navigateTo(SceneType.POST);
    }

    @FXML
    public void back() {
        SceneManager.getInstance().navigateTo(SceneType.POST);
    }

    public static Scene buildScene() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneFactory.class.getResource("/CreatePostScene.fxml")
            );
            return new Scene(loader.load(), 800, 600);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}