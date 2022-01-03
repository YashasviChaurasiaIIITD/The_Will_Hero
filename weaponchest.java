import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

import com.oracle.javafx.scenebuilder.kit.library.util.JarReportEntry.Status;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;

public class weaponchest implements chest {

    private int weapon_flag;// 0 for shuri 1 for knife
    private int health;
    private Image oimg;
    private ImageView orc;
    private AnchorPane pane1;
    private TranslateTransition transy;
    private TranslateTransition transx;
    private TranslateTransition transz;
    private ImageView avataView;
    private int x;
    private int y;
    private Rectangle b;
    private ArrayList<island> ISLAND1;
    private ArrayList<island> ISLAND2;

    private ArrayList<boundary> topboundaries = new ArrayList<boundary>();
    private ArrayList<boundary> bottomboundaries = new ArrayList<boundary>();

    public weaponchest(AnchorPane p1, int x, int y, int X, int Y, String s) {

        // avataView=avatar;
        oimg = new Image(s);
        health = 2;
        transy = new TranslateTransition();
        transx = new TranslateTransition();
        transz = new TranslateTransition();
        pane1 = p1;
        orc = new ImageView(oimg);
        orc.setFitHeight(y);
        orc.setFitWidth(x);
        x = X;
        y = Y;
        orc.setLayoutX(X);
        orc.setLayoutY(Y);
        // pane1 =pane;
        p1.getChildren().add(orc);

        int max = 1;
        int min = 0;
        int range = max - min + 1;
        int rand = 0;
        // generate random numbers within 1 to 10
        rand = (int) (Math.random() * range) + min;
        weapon_flag = 0;
    }

    public ImageView getOrc() {
        return orc;
    }

    @Override
    public int openchest() {
        // TODO Auto-generated method stub
        oimg = new Image("The_Will_Hero-main/ChestOpen.png");
        System.out.println("weapon flag " + weapon_flag);
        return weapon_flag;

    }

}
