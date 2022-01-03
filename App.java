import javafx.application.Application;
import javafx.fxml.FXMLLoader;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.scene.*;
// import javafx.scene.control.Button;
// import javafx.scene.layout.Background;
// import javafx.scene.layout.StackPane;
// import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.InputStream;

// import javafx.scene.control.Label;
// import javafx.scene.control.ProgressBar;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.image.ImageView;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("m2.fxml"));

            Scene scene = new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("bg.css").toExternalForm());
            // stage.setTitle("Hello!");
            String css = this.getClass().getResource("bg.css").toExternalForm();
            scene.getStylesheets().add(css);
            // stage.setScene(scene);
            // stage.show();

            // Image img = new Image("girl.png");ulimii
            // ImageView imgview=new ImageView(img);
            // Group root = new Group();
            // root.getChildren().addAll(imgview);
            // Scene scene = new Scene(root);
            // stage.setTitle("Displaying Image");
            // stage.getIcons().add(img);
            stage.setResizable(false);

            stage.setWidth(800);
            stage.setHeight(450);
            // stage.setResizable(false);
            // stage.setX(50);//stage is basically the app which opens and scene is inside
            // app stuff
            // stage.setY(50);

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        launch();

    }
}