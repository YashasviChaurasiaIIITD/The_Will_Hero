import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

//no exeptions or shit is handled it is raw code
public class m2control implements Initializable {
    @FXML
    private ImageView island;
    @FXML
    private ImageView avatar;
    @FXML
    private ImageView cloud;
    @FXML
    private ImageView cloud2;

    @FXML
    private ImageView settings;
    @FXML
    private Label mb1;
    @FXML
    private Label mb2;
    @FXML
    private Label mb3;
    @FXML
    private ImageView crest;
    @FXML
    private ImageView isl1;
    @FXML
    private ImageView isl2;

    @FXML
    private ImageView bigorc1;

    int jump = 1;
    // private double x;
    // private double y;
    Stage stageog;
    @FXML
    private AnchorPane scenePane;
    // Scene scene;

    public void play(MouseEvent m2) throws IOException {
        // avatar.setTranslateX(avatar.getX() + 50);
        // avatar.setLayoutX(avatar.getLayoutX() + 50);
        Stage stage;
        Scene scene;

        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.rgb(80, 200, 255)) };
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);

        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        stage = (Stage) ((Node) m2.getSource()).getScene().getWindow();
        scene = new Scene(root, lg1);
        String css = this.getClass().getResource("bg.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        // controller c = new controller();
        // c.init();
        stage.show();
    }

    public void exit(MouseEvent m) {
        // System.out.println("mouse");
        stageog = (Stage) scenePane.getScene().getWindow();
        stageog.close();

    }

    public void load(MouseEvent m2) throws IOException {
        Stage stage;
        Scene scene;

        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.rgb(80, 200, 255)) };
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);

        Parent root = FXMLLoader.load(getClass().getResource("load.fxml"));
        stage = (Stage) ((Node) m2.getSource()).getScene().getWindow();
        scene = new Scene(root, lg1);
        String css = this.getClass().getResource("bg.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        // controller c = new controller();
        // c.init();
        stage.show();
    }

    // public void up(ActionEvent e) {
    // // System.out.println("t1");

    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        TranslateTransition trans1 = new TranslateTransition();
        trans1.setNode(avatar);
        trans1.setDuration(Duration.millis(2000));
        trans1.setByY(avatar.getY() - 10);
        trans1.setCycleCount(TranslateTransition.INDEFINITE);
        trans1.setAutoReverse(true);
        trans1.play();// band rakh untill others are tested

        // cloud
        TranslateTransition trans = new TranslateTransition();
        trans.setNode(cloud);
        trans.setDuration(Duration.seconds(60));
        trans.setByX(-700);
        trans.setCycleCount(TranslateTransition.INDEFINITE);
        trans.play();// band rakh untill others are tested

        TranslateTransition trans2 = new TranslateTransition();
        trans2.setNode(cloud2);
        trans2.setDuration(Duration.seconds(60));
        trans2.setByX(-500);
        trans2.setCycleCount(TranslateTransition.INDEFINITE);
        trans2.play();// band rakh untill others are tested

        TranslateTransition trans3 = new TranslateTransition();
        trans3.setNode(settings);
        trans3.setDuration(Duration.seconds(1));
        trans3.setByY(settings.getY() + 5);
        trans3.setAutoReverse(true);
        trans3.setCycleCount(TranslateTransition.INDEFINITE);
        trans3.play();// band rakh untill others are tested

        TranslateTransition trans4 = new TranslateTransition();
        trans4.setNode(bigorc1);
        trans4.setDuration(Duration.seconds(1));
        trans4.setByY(bigorc1.getY() - 5);
        trans4.setAutoReverse(true);
        trans4.setCycleCount(TranslateTransition.INDEFINITE);
        trans4.play();// band rakh untill others are tested

    }
}
