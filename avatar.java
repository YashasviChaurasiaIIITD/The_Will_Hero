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

public class avatar extends controller {
    private int health;
    private Image oimg = new Image("The_Will_Hero-main/avatar1.png");
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

    private ArrayList<orc> orcs = new ArrayList<orc>();
    private ArrayList<coin> coins = new ArrayList<coin>();
    private int tcoins;
    private ArrayList<windmill> blade = new ArrayList<windmill>();
    private ArrayList<boundary> topboundaries = new ArrayList<boundary>();
    private ArrayList<boundary> bottomboundaries = new ArrayList<boundary>();

    public avatar(AnchorPane p1, int x, int y, int X, int Y, Rectangle b1, ArrayList<boundary> tb,
            ArrayList<boundary> bb, ArrayList<island> isl1, ArrayList<island> isl2, ArrayList<coin> coin,
            ArrayList<windmill> blades) {
        blade = blades;
        coins = coin;
        topboundaries = tb;
        bottomboundaries = bb;
        b = b1;
        ISLAND1 = isl1;
        ISLAND2 = isl2;
        // avataView=avatar;
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

    public void setHealth() {
        health--;
    }

    public int getscore() {
        return tcoins;
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

            velocityY += 12 * 0.5 * Math.pow(time, 2);
            y = y + velocityY;
            x = x + velocityX;
            for (int k = 0; k < coins.size(); k++) {
                if (checkCollision(orc, coins.get(k).getCoin())) {
                    tcoins++;
                    coins.get(k).getCoin().setVisible(false);
                }
            }
            for (windmill blade : blade) {
                if (checkCollision(orc, blade.getwindmill())) {
                    // orc.setVisible(false);
                }
            }
            for (int k = 0; k < ISLAND1.size(); k++) {
                if (checkCollision(orc, ISLAND1.get(k).getIsl1())) {
                    velocityY = -4.5;

                    coincount++;
                    velocityX = 0;
                    // coincounter.setText("Coins " + coincount);
                    // System.out.println("player touch ground");
                    // orc.getOrc().relocate(x, y);
                    time = .13;
                }

            }
            for (int j = 0; j < topboundaries.size(); j++) {
                if (checkOrcCrush(orc, topboundaries.get(j).gRectangle())) {
                    velocityY = -4.5;

                    coincount++;
                    velocityX = 0;
                    // coincounter.setText("Coins " + coincount);
                    // System.out.println("player bounce off orc");
                    // orc.getOrc().relocate(x, y);
                    time = .13;
                }
                for (int o = 0; o < bottomboundaries.size(); o++) {
                    if (checkOrcCrush(orc, bottomboundaries.get(o).gRectangle())) {
                        // orc.setVisible(false);
                        // coincounter.setText("Coins " + coincount);
                        // System.out.println("player died");
                        // orc.getOrc().relocate(x, y);
                        time = .13;

                    }
                }
            }
            for (int k = 0; k < ISLAND2.size(); k++) {
                if (checkCollision(orc, ISLAND2.get(k).getIsl1())) {
                    velocityY = -4.5;
                    velocityX = 0;
                    // System.out.println("vx set to 0 by isl2");
                    time = .13;
                }
            }
            if (checkOrcCrush(orc, b)) {
                // orc.setVisible(false);
                // pane1.getChildren().remove(orc);
            }
            orc.relocate(x, y);
            ;
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

}