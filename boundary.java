import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

public class boundary extends controller {
    private int health;
    private Image oimg = new Image("The_Will_Hero-main/bigorc.jpeg");
    private ImageView orc;
    private AnchorPane pane1;
    private TranslateTransition transy;
    private TranslateTransition transx;
    private TranslateTransition transz;
    private ImageView avataView;
    private Double x;
    private Double y;

    private Rectangle bound;
    private ArrayList<island> ISLAND1;

    public boundary(AnchorPane p1, int x, int y, int X, int Y) {
        bound = new Rectangle();
        pane1 = p1;
        bound.setHeight(y);
        bound.setWidth(x);

        bound.setLayoutX(X);
        bound.setLayoutY(Y);
        // pane1 =pane;
        p1.getChildren().add(bound);
        // bound.setVisible(false);
    }

    public boundary(AnchorPane p1, int x, int y, Double X, int Y) {
        bound = new Rectangle();
        pane1 = p1;
        bound.setHeight(y);
        bound.setWidth(x);

        bound.setLayoutX(X);
        bound.setLayoutY(Y);
        // pane1 =pane;
        p1.getChildren().add(bound);
        // bound.setVisible(false);
    }

    public ImageView getOrc() {
        return orc;
    }

    // public int getX()
    // {
    // return x;
    // }
    // public int getY()
    // {
    // return y;
    // }
    public Rectangle gRectangle() {
        return bound;
    }
}
