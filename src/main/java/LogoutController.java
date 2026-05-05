import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;


public class LogoutController {

    private final UserManager userManager = UserManager.getInstance();

    public Scene buidScene(){
        Image logo = new Image(getClass().getResource("/ImagesInferior/Inferior2.png").toExternalForm());
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(450);
        logoView.setPreserveRatio(true);

        Label label = new Label("Inferior");
        label.setStyle("-fx-text-fill: red; -fx-font-size: 50px; -fx-font-weight: bold;");
        Label title = new Label("Logout");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 50px; -fx-font-weight: bold;");
        Label username = new Label(userManager.getCurrentUser());
//        username.setStyle("-fx-text-fill: white; -fx-padding: 16px; -fx-font-size: 20;");
        Label logoutStmt = new Label("Leaving us already " + username.getText().trim() + "!");
        logoutStmt.setStyle("-fx-text-fill: white; -fx-padding: 16px;-fx-font-size: 20;");

//        Buttons
        Button logoutBtn = new Button("Logout");
        Button gobackBtn = new Button("back");
        logoutBtn.setStyle("-fx-font-size: 10px; -fx-padding: 10px 45px;");
        gobackBtn.setStyle("-fx-font-size: 10px; -fx-padding: 10px 48px;");

        logoutBtn.setOnAction(e->{
            SceneManager.getInstance().navigateTo(SceneType.LOGIN);
        });
        gobackBtn.setOnAction(e->{
            SceneManager.getInstance().navigateTo(SceneType.MAIN);
        });


        VBox root = new VBox(20, title,logoutStmt, logoutBtn, gobackBtn);
        root.setAlignment(Pos.CENTER);
//        root.setStyle("-fx-background-color: #141414");

        HBox frame = new HBox(50, logoView, root);
        frame.setAlignment(Pos.CENTER);
        frame.setStyle("-fx-background-color: #141414;");

//        logoView.fitHeightProperty().bind(frame.widthProperty().multiply(0.40));
//        logoView.setPreserveRatio(true);
//        root.prefWidthProperty().bind(frame.widthProperty().multiply(0.60));
//
//        title.styleProperty().bind(frame.widthProperty().multiply(0.03).asString(
//                "-fx-text-fill: white; -fx-font-weight:bold;"));
//        logoutStmt.styleProperty().bind(frame.widthProperty().multiply(0.03).asString(
//                "-fx-text-fill: white;"));
//
//        logoutBtn.prefWidthProperty().bind(root.widthProperty().multiply(0.));
//        logoutBtn.prefHeightProperty().bind(root.heightProperty().multiply(0.08));
//
//        gobackBtn.prefWidthProperty().bind(root.widthProperty().multiply(0.2));
//        gobackBtn.prefHeightProperty().bind(root.heightProperty().multiply(0.18));
//
//



        return new Scene(frame, 800, 700);
    }

}
