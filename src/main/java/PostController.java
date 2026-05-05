import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PostController {
    public PostController(){

    }
    @FXML
    private Label postUsernameLabel;

    @FXML
    private Label postHeadLabel;

    @FXML
    private Label postBodyLabel;

    @FXML
    private ListView<String> commentsListView;

    @FXML
    private Label postTierLabel;

    @FXML
    private Label likeCountLabel;
            private int likeCount = 0;
    private int selectedPost = 1;

    @FXML
    public void initialize() {
        comments();
    }

    @FXML
    public void back() {
        SceneManager.getInstance().navigateTo(SceneType.MAIN);
    }

    @FXML
    public void profile() {
        SceneManager.getInstance().navigateTo(SceneType.PROFILE);
    }

    @FXML
    public void like(){
        likeCount++;
        likeCountLabel.setText(likeCount + " Likes");
    }

    @FXML void createComment(){
        SceneManager.getInstance().navigateTo(SceneType.COMMENT);
    }

    @FXML
    private void comments() {
        commentsListView.getItems().clear();
        CommentDAO commentDAO = new CommentDAO();
        commentsListView.getItems().addAll(commentDAO.getCommentsByPost(selectedPost));
    }
    public Scene buildScene(){
        try {
            FXMLLoader load = new FXMLLoader(SceneFactory.class.getResource("/PostScene.fxml"));
            return new Scene(load.load(), 800, 600);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}