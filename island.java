import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;

public class island {
    private Image isl = new Image("The_Will_Hero-main/island_empty.png");
    private ImageView isl1;
    private AnchorPane pane1;

    public island(Pane pane, int x, int y, int X, int Y) {

        isl1 = new ImageView(isl);
        isl1.setFitHeight(y);
        isl1.setFitWidth(x);

        isl1.setX(X);
        isl1.setY(Y);
        // pane1 =pane;
        pane.getChildren().add(isl1);
    }

    public island() {
        isl1 = new ImageView(isl);
    }

    public ImageView getIsl1() {
        return isl1;
    }
}
