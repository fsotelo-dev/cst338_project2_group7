import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CommentController {
    @FXML
    private TextArea commentInput;

    private int selectedPost;

    public void setSelectedPost(int postID){
        selectedPost = postID;
    }

    @FXML
    public void postComment() {
        String text = commentInput.getText();

        if (text == null || text.isEmpty()) {
            return;
        }

        CommentDAO commentDAO = new CommentDAO();
        commentDAO.addComment(selectedPost, "Devin", text);

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
}