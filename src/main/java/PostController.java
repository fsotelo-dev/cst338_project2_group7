import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PostController {

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

    @FXML
    public void initialize() {
        postUsernameLabel.setText("Devin");
        postTierLabel.setText("Rich");

        postHeadLabel.setText("Test Post Title");
        postBodyLabel.setText("This is a test post loaded from PostController.");

        commentsListView.getItems().add("Freddy: nice post");
        commentsListView.getItems().add("Angel: this comment loaded correctly");
        commentsListView.getItems().add("Job: comments are showing");
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

//    @FXML void createComment(){
//        SceneManager.getInstance().navigateTo(SceneType.COMMENT);
//    }
}
