import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

import java.util.Objects;

public class CommentController {
    @FXML
    private TextArea commentInput;

    private int selectedPost;

    public void setSelectedPost(int postID){
        selectedPost = postID;
    }
    public CommentController(){

    }

    @FXML
    public void postComment() {
        String text = commentInput.getText();

        if (text == null || text.isEmpty()) {
            return;
        }

        CommentDAO commentDAO = new CommentDAO();
        String username = Main.userManager.getCurrentUser();
        commentDAO.addComment(selectedPost, username, text);

        // after comment uploaded go back to post scene
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

    public Scene buildScene(){
        try {
            return new Scene(
                    FXMLLoader.load(Objects.requireNonNull(SceneFactory.class.getResource("/CommentScene.fxml"))),
                    800, 600
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}