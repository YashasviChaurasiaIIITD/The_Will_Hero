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

public class weapon {
    private Image weapon;// = new Image("The_Will_Hero-main/w1.png");
    private ImageView weapon1;
    private int level = 2;
    // private AnchorPane pane1;

    public weapon(AnchorPane pane, int x, int y, double d, double e, String s) {
        weapon = new Image(s);
        weapon1 = new ImageView(weapon);

        weapon1.setFitHeight(y);
        weapon1.setFitWidth(x);
        level = 2;
        weapon1.setX(d);
        weapon1.setY(e);
        // pane1 =pane;
        // pane.getChildren().add(weapon1);

    }

    public void upgradelvl() {
        level++;
    }

    public int getlvl() {
        return level;
    }

    public void setlayout(double d, double e) {
        weapon1.setLayoutX(d);
        weapon1.setLayoutY(e);

    }

    public void setinp(AnchorPane pane) {
        pane.getChildren().add(weapon1);
    }
    // public weapon(AnchorPane scenePane, int x, int y, double layoutX, double
    // layoutY) {
    // }

    public ImageView getIsl1() {
        return weapon1;
    }
}
