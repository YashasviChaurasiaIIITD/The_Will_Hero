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

public class coin {
    private int health;
    private Image cimg = new Image("assets/Coin.png");
    private ImageView coin;
    private AnchorPane pane1;
    private TranslateTransition transy;
    private TranslateTransition transx;

    public coin(AnchorPane p1, int x, int y, int X, int Y) {
        health = 2;
        transy = new TranslateTransition();
        transx = new TranslateTransition();
        pane1 = p1;
        coin = new ImageView(cimg);
        coin.setFitHeight(y);
        coin.setFitWidth(x);

        coin.setX(X);
        coin.setY(Y);
        // pane1 =pane;
        p1.getChildren().add(coin);
    }

    public ImageView getCoin() {
        return coin;
    }

    public int getVal() {
        return health;
    }

    public void setVal() {
        health--;
    }
}
