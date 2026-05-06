import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

import java.util.Objects;

public class CommentController {

    @FXML
    private TextArea commentInput;

    public CommentController() {}

    @FXML
    public void postComment() {
        String text = commentInput.getText().trim();

        if (text.isEmpty()) return;

        String username = UserManager.getInstance().getCurrentUser();
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.addComment(PostController.selectedPostId, username, text);

        SceneManager.getInstance().navigateTo(SceneType.POST);
    }

    @FXML
    public void back() {
        SceneManager.getInstance().navigateTo(SceneType.POST);
    }

    @FXML
    public void profile() {
        SceneManager.getInstance().navigateTo(SceneType.PROFILE);
    }

    public Scene buildScene() {
        try {
            return new Scene(
                    FXMLLoader.load(Objects.requireNonNull(
                            SceneFactory.class.getResource("/CommentScene.fxml"))),
                    800, 600
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}