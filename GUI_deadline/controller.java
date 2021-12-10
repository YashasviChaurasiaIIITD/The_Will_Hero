import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
//import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;

//no exeptions or shit is handled it is raw code
public class controller implements Initializable {
    @FXML
    private ImageView island;
    @FXML
    private Label willhero;
    @FXML
    private ImageView avatar;
    @FXML
    private ImageView cloud;
    @FXML
    private ImageView cloud2;

    @FXML
    private ImageView settings;
    @FXML
    private ImageView crest;
    @FXML
    private ImageView isl1;
    @FXML
    private ImageView isl2;
    @FXML
    private ImageView rorc3;

    @FXML
    private ImageView bigorc1;
    @FXML
    private Pane pane;
    @FXML
    private Pane pane2;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label pause;// resume
    @FXML
    private Label save;
    @FXML
    private Label restart;
    @FXML
    private Label exitm;// to main menu

    TranslateTransition trans1 = new TranslateTransition();
    TranslateTransition trans = new TranslateTransition();
    TranslateTransition trans2 = new TranslateTransition();
    TranslateTransition trans3 = new TranslateTransition();
    int jump = 1;
    // private double x;
    // private double y;

    public void play(MouseEvent m2) throws IOException {
        // avatar.setTranslateX(avatar.getX() + 50);
        // avatar.setLayoutX(avatar.getLayoutX() + 50);
        Stage stage;
        Scene scene;
        willhero.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        stage = (Stage) ((Node) m2.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("bg.css").toExternalForm();
        scene.getStylesheets().add(css);

        avatar.setLayoutX(avatar.getLayoutX() + 50);
        pane.setLayoutX(pane.getLayoutX() + 50);
        scenePane.setLayoutX(scenePane.getLayoutX() - 50);
        settings.setLayoutX(settings.getLayoutX() + 50);
        pane2.setLayoutX(pane2.getLayoutX() + 50);

        // stage.setX(stage.getX() + 50);

    }

    public void gear(MouseEvent m) {
        trans.pause();
        trans1.pause();
        trans2.pause();
        trans3.pause();
        pane.setDisable(true);
        pane2.setDisable(false);

        pane2.setOpacity(1);
        pause.setVisible(true);
        restart.setVisible(true);
        exitm.setVisible(true);
        save.setVisible(true);
    }

    public void resume(MouseEvent a) {
        pane2.setDisable(true);
        pane.setDisable(false);
        pause.setVisible(false);
        restart.setVisible(false);
        exitm.setVisible(false);
        save.setVisible(false);
        trans.play();
        trans1.play();
        trans2.play();
        trans3.play();
    }

    public void restart(MouseEvent b) throws IOException {
        Stage stage;
        Scene scene;

        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.rgb(80, 200, 255)) };
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);

        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        stage = (Stage) ((Node) b.getSource()).getScene().getWindow();
        scene = new Scene(root, lg1);
        String css = this.getClass().getResource("bg.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }

    public void exit(MouseEvent c) throws IOException {

        Stage stage;
        Scene scene;

        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.rgb(80, 200, 255)) };
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);

        Parent root = FXMLLoader.load(getClass().getResource("m2.fxml"));
        stage = (Stage) ((Node) c.getSource()).getScene().getWindow();
        scene = new Scene(root, lg1);
        String css = this.getClass().getResource("bg.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }

    // public void up(ActionEvent e) {
    // // System.out.println("t1");

    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        // TranslateTransition trans1 = new TranslateTransition();
        trans1.setNode(avatar);
        trans1.setDuration(Duration.millis(450));
        trans1.setByY(avatar.getY() - 45);
        trans1.setCycleCount(TranslateTransition.INDEFINITE);
        trans1.setAutoReverse(true);
        trans1.play();// band rakh untill others are tested

        trans3.setNode(rorc3);
        trans3.setDuration(Duration.millis(400));
        trans3.setByY(avatar.getY() - 90);
        trans3.setCycleCount(TranslateTransition.INDEFINITE);
        trans3.setAutoReverse(true);
        trans3.play();// band rakh untill others are tested

        // cloud
        // TranslateTransition trans = new TranslateTransition();
        trans.setNode(cloud);
        trans.setDuration(Duration.seconds(60));
        trans.setByX(-700);
        trans.setCycleCount(TranslateTransition.INDEFINITE);
        trans.play();// band rakh untill others are tested

        // TranslateTransition trans2 = new TranslateTransition();
        trans2.setNode(cloud2);
        trans2.setDuration(Duration.seconds(60));
        trans2.setByX(-500);
        trans2.setCycleCount(TranslateTransition.INDEFINITE);
        trans2.play();// band rakh untill others are tested

    }
}
