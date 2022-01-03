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

public class orc extends controller {
    private int health;
    private Image oimg = new Image("assets/Orc1.png");
    private Image oimg1 = new Image("assets/RedOrc1.png");
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
    private boundary top;
    private boundary bottom;
    private ArrayList<weapon> shoot1;
    private ArrayList<weapon> shoot2;
    private int aliveflag;

    public orc(AnchorPane p1, int x, int y, int X, int Y, ImageView avatar, ArrayList<island> isl1, Rectangle b1,
            ArrayList<weapon> s1, ArrayList<weapon> s2, boundary tb, boundary bb) {
        aliveflag = 1;
        top = tb;
        bottom = bb;
        shoot1 = s1;
        shoot2 = s2;
        b = b1;
        ISLAND1 = isl1;
        avataView = avatar;
        health = 12;
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
    }

    public orc(AnchorPane p1, int x, int y, Double X, int Y, ImageView avatar, ArrayList<island> isl1, Rectangle b1,
            ArrayList<weapon> s1, ArrayList<weapon> s2, boundary tb, boundary bb) {
        aliveflag = 1;
        top = tb;
        bottom = bb;
        shoot1 = s1;
        shoot2 = s2;
        b = b1;
        ISLAND1 = isl1;
        avataView = avatar;
        health = 12;
        transy = new TranslateTransition();
        transx = new TranslateTransition();
        transz = new TranslateTransition();
        pane1 = p1;
        orc = new ImageView(oimg);
        orc.setFitHeight(y);
        orc.setFitWidth(x);

        orc.setLayoutX(X);
        orc.setLayoutY(Y);
        // pane1 =pane;
        p1.getChildren().add(orc);
    }

    public ImageView getOrc() {
        return orc;
    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setImg() {
        orc.setImage(oimg1);
    }

    public void setHealth() {
        // System.out.println("ORC HLAETJ " + health);
        health--;
    }

    AnimationTimer move = new AnimationTimer() {
        double time = 0;
        double velocityY = 0;
        double velocityX = 0;

        int counter = 0;

        @Override
        public void handle(long timestamp) {
            double x = orc.getLayoutX();
            double y = orc.getLayoutY();

            double tx = top.gRectangle().getLayoutX();
            double ty = top.gRectangle().getLayoutY();

            double bx = bottom.gRectangle().getLayoutX();
            double by = bottom.gRectangle().getLayoutY();

            velocityY += 12 * 0.5 * Math.pow(time, 2);
            y = y + velocityY;
            x = x + velocityX;

            ty = ty + velocityY;
            tx = tx + velocityX;

            by = by + velocityY;
            bx = bx + velocityX;

            for (int k = 0; k < ISLAND1.size(); k++) {
                if (checkCollision(orc, ISLAND1.get(k).getIsl1())) {
                    velocityY = -5.5;

                    coincount++;
                    velocityX = 0;
                    // coincounter.setText("Coins " + coincount);
                    // System.out.println("Orc touch ground");
                    // orc.getOrc().relocate(x, y);
                    time = .13;
                }
                if (checkOrcCrush(ISLAND1.get(k).getIsl1(), bottom.gRectangle())) {
                    velocityY = -5.5;

                    coincount++;
                    velocityX = 0;
                    // coincounter.setText("Coins " + coincount);
                    // System.out.println("Orc touch ground");
                    // orc.getOrc().relocate(x, y);
                    time = .13;
                }

            }

            for (int k = 0; k < ISLAND2.size(); k++) {
                if (checkCollision(orc, ISLAND2.get(k).getIsl1())) {
                    velocityY = -5.5;
                    velocityX = 0;
                    // System.out.println("vx set to 0 by isl2");
                    time = .13;
                }
                if (checkOrcCrush(ISLAND1.get(k).getIsl1(), bottom.gRectangle())) {
                    velocityY = -8.5;

                    coincount++;
                    velocityX = 0;
                    // coincounter.setText("Coins " + coincount);
                    // System.out.println("Orc touch ground");
                    // orc.getOrc().relocate(x, y);
                    time = .13;
                }
            }
            for (int k = 0; k < shoot1.size(); k++) {
                if (checkCollision(orc, shoot1.get(k).getIsl1())) {
                    // velocityX = 1.5
                    setHealth();
                    if (health == 0) {
                        // aliveflag=0;
                        // orc.setVisible(false);
                    }
                    // System.out.println("vslset3");
                    time = .13;
                }
            }
            for (int k = 0; k < shoot2.size(); k++) {
                if (checkCollision(orc, shoot2.get(k).getIsl1())) {
                    // velocityX = 0;
                    setHealth();
                    if (health == 0) {
                        // aliveflag=0;
                        // orc.setVisible(false);
                    }
                    time = .13;
                    // System.out.println("vslset2");
                    // velocityY = 0;

                }
            }

            if (checkCollision(orc, avataView)) {// || checkCollision(avatar,
                // ISLAND1.get(1).getIsl1())) {
                velocityX = 1.5;
                // System.out.println("vslset1");
                time = .13;
            }
            // if (checkOrcCrush( avataView,top.gRectangle())) {// || checkCollision(avatar,
            // // ISLAND1.get(1).getIsl1())) {
            // //velocityX = 3.5;
            // System.out.println("vslset1");
            // time = .13;
            // }

            if (checkOrcCrush(orc, b)) {
                aliveflag = 0;
                // pane1.getChildren().remove(orc);
                // orc.setVisible(false);
            }
            orc.relocate(x, y);
            bottom.gRectangle().relocate(bx, by);
            top.gRectangle().relocate(tx, ty);

            // time+=0.001;
        }
    };
    // jumping2.start();

    public AnimationTimer getanim() {
        return move;
    }

    public void Stop() {
        transx.stop();
        transy.stop();
    }

    public int getFlag() {
        return aliveflag;
    }

}
