import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class PostController {

    public static int selectedPostId = -1;

    public PostController() {}

    public Scene buildScene() {
        Label title = new Label("Inferior");
        title.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
        VBox postFeedBox = new VBox(10);
        postFeedBox.setStyle("-fx-padding: 10;");

        PostDAO postDAO = new PostDAO();
        List<String[]> posts = postDAO.getAllPosts();

        if (posts.isEmpty()) {
            Label empty = new Label("There Are Zero Posts Currently!");
            empty.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            postFeedBox.getChildren().add(empty);
            postFeedBox.setAlignment(Pos.CENTER);
        } else {
            for (String[] post : posts) {
                int postId = Integer.parseInt(post[0]);
                postFeedBox.getChildren().add(buildPostCard(post[1], post[2], post[3], postId));
            }
        }
        ScrollPane scrollPane = new ScrollPane(postFeedBox);
        scrollPane.setFitToWidth(true);
        Button backBtn = new Button("Back");
        backBtn.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.MAIN));


        Button createPostBtn = new Button("Create Post");
        createPostBtn.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.CREATE_POST));

        HBox navRow = new HBox(10, backBtn, createPostBtn);
        navRow.setAlignment(Pos.CENTER);
        navRow.setStyle("-fx-padding: 10;");
        VBox layout = new VBox(10, title, navRow, scrollPane);
        layout.setAlignment(Pos.TOP_CENTER);

        return new Scene(layout, 800, 600);
    }

    private VBox buildPostCard(String username, String title, String body, int postId) {
        Label postUsernameLabel = new Label(username);

        Label postTitleLabel = new Label(title);
        postTitleLabel.setStyle("-fx-font-weight: bold;");
        Label postBodyLabel = new Label(body);


        Label likeCountLabel = new Label("0 Likes");
        Button likeBtn = new Button("Like");
        likeBtn.setOnAction(e -> {
            int current = Integer.parseInt(likeCountLabel.getText().split(" ")[0]);
            likeCountLabel.setText((current + 1) + " Likes");
        });

        Button commentBtn = new Button("Comment");
        commentBtn.setOnAction(e -> {
            selectedPostId = postId;
            SceneManager.getInstance().navigateTo(SceneType.COMMENT);
        });

        HBox topRow = new HBox(10, postUsernameLabel);
        HBox actionRow = new HBox(10, likeBtn, likeCountLabel, commentBtn);
        Label commentsLabel = new Label("Comments:");
        ListView<String> commentsListView = new ListView<>();
        commentsListView.setPrefHeight(100);

        CommentDAO commentDAO = new CommentDAO();
        commentsListView.getItems().addAll(commentDAO.getCommentsByPost(postId));
        VBox card = new VBox(8, topRow, postTitleLabel, postBodyLabel, actionRow, commentsLabel, commentsListView);
        card.setStyle("-fx-border-color: gray; -fx-padding: 10;");

        return card;
    }
}