import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

public class PostController {
    public PostController(){

    }
    @FXML
    private VBox postFeedBox;

    private int selectedPost = 1;

    @FXML
    public void initialize() {
        showEmptyState();
    }

    @FXML
    public void back() {
        SceneManager.getInstance().navigateTo(SceneType.MAIN);
    }
// ToDo: REPLACE THIS PROFILE BUTTON METHOD WITH CREATE POST BUTTON METHOD WHEN CREATED
    @FXML
    public void profile() {
        SceneManager.getInstance().navigateTo(SceneType.PROFILE);
    }

    private void showEmptyState() {
        postFeedBox.getChildren().clear();

        Label empty = new Label("Zero Posts Yet!");
        empty.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        postFeedBox.getChildren().add(empty);
    }

    private VBox createPost(String username, String title, String body) {
        Label postUsernameLabel = new Label(username);
        Label commentsLabel = new Label("Comments:");
        Label postTierLabel = new Label("Tier");
        postTierLabel.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-padding: 5 10; -fx-background-radius: 10; -fx-font-weight: bold;");

        Label postHeadLabel = new Label(title);
        postHeadLabel.setStyle("-fx-font-weight: bold;");

        Label postBodyLabel = new Label(body);

        Button likeBtn = new Button("Like");
        Label likeCountLabel = new Label("0 Likes");
        Button commentBtn = new Button("Create Comment");

        commentBtn.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.COMMENT)
        );

        ListView<String> commentsListView = new ListView<>();
        commentsListView.setPrefHeight(120);

        CommentDAO commentDAO = new CommentDAO();
        commentsListView.getItems().addAll(commentDAO.getCommentsByPost(selectedPost));

        HBox topRow = new HBox(10, postUsernameLabel, postTierLabel);
        HBox actionRow = new HBox(10, likeBtn, likeCountLabel, commentBtn);

        VBox card = new VBox(8, topRow, postHeadLabel, postBodyLabel, actionRow, commentsLabel, commentsListView);
        card.setStyle("-fx-border-color: gray; -fx-padding: 10;");

        return card;
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