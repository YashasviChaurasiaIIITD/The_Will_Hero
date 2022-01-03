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

public class windmill 
{
    private int health;
    private Image oimg= new Image("The_Will_Hero-main/bladefinal.png");
    private ImageView orc;
    private AnchorPane pane1;
    private TranslateTransition transy ;
    private TranslateTransition transx ;
    private TranslateTransition transz ;
    private ImageView avataView;
    private double x;
    private double y;
    public windmill(AnchorPane p1, int x, int y, int X, int Y)
    {
        //avataView=avatar;
        health =2;
        transy = new TranslateTransition();
        transx = new TranslateTransition();
        transz = new TranslateTransition();
        pane1=p1;
        orc = new ImageView(oimg);
        orc.setFitHeight(y);
        orc.setFitWidth(x);
        orc.setX(X);
        orc.setY(Y);
        // pane1 =pane;
        p1.getChildren().add(orc);
        orc.toBack();
    }
    public ImageView getwindmill()
    {
        return orc;
    }

}
