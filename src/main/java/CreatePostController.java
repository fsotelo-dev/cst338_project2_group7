/**
 * @author Freddy Sotelo
 * created: 5/5/26
 * @since Assignment: App
 **/
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CreatePostController {

    public CreatePostController() {}

    public Scene buildScene() {
        Label title = new Label("Create a Post");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        TextField titleField = new TextField();
        titleField.setPromptText("Post title");

        TextArea bodyField = new TextArea();
        bodyField.setPromptText("What's on your mind?");
        bodyField.setPrefHeight(150);

        Label statusLabel = new Label();
        Button submitBtn = new Button("Post");
        submitBtn.setOnAction(e -> {
            String postTitle = titleField.getText().trim();
            String postBody  = bodyField.getText().trim();
            if (postTitle.isEmpty() || postBody.isEmpty()) {
                statusLabel.setText("Please fill out both fields.");
                return;
            }
            String username = UserManager.getInstance().getCurrentUser();
            PostDAO postDAO = new PostDAO();
            boolean success = postDAO.addPost(username, postTitle, postBody);
            if (success) {
                SceneManager.getInstance().navigateTo(SceneType.POST);
            } else {
                statusLabel.setText("Failed to post. Try again.");
            }
        });

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(e ->
                SceneManager.getInstance().navigateTo(SceneType.POST));

        VBox layout = new VBox(15, title, titleField, bodyField, statusLabel, submitBtn, cancelBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 40;");
        return new Scene(layout, 800, 600);
    }
}