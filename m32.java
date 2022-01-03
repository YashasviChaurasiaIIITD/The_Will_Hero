import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

//no exeptions or shit is handled it is raw code
public class m32 implements Initializable {

    @FXML
    private Rectangle under;
    @FXML
    private Rectangle deathline;

    @FXML
    private ImageView island;
    @FXML
    private ImageView ORC;
    @FXML
    private Label willhero;
    @FXML
    private Label coincounter;
    @FXML
    private Label scorelLabel;
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
    private ImageView bigorc11;
    @FXML
    private Pane pane;
    @FXML
    private Pane initt;
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

    int scorecount = 0;
    int loadflag = 0;
    int y;

    int weaponflag = -1;// -1 is no weapon 0 is shuri 1 is knife
    weapon w1;
    weapon w2;

    windmill blade;
    windmill blade1;
    windmill blade2;
    windmill blade3;
    int knife = 0;
    int shuri = 0;// keeps levels of weapons //update them too while updating weapon objects in
                  // code

    orc orc;
    save svfile2;
    save ldfile;
    MouseEvent mousie;
    ArrayList<island> ISLAND1 = new ArrayList<island>();
    int setpowerup = 0;
    int ressurect = 0;
    ArrayList<island> ISLAND2 = new ArrayList<island>();
    ArrayList<island> ISLAND3 = new ArrayList<island>();
    ArrayList<Node> WeaponNode = new ArrayList<Node>();
    Group group;
    ArrayList<weapon> shoot_weapon = new ArrayList<weapon>();
    ArrayList<weapon> shoot_weapon2 = new ArrayList<weapon>();
    ArrayList<TranslateTransition> shoot_trans = new ArrayList<TranslateTransition>();
    ArrayList<TranslateTransition> shoot_trans2 = new ArrayList<TranslateTransition>();
    ArrayList<TranslateTransition> shoot_trans21 = new ArrayList<TranslateTransition>();

    TranslateTransition trans1 = new TranslateTransition();
    TranslateTransition trans = new TranslateTransition();
    TranslateTransition trans2 = new TranslateTransition();
    TranslateTransition trans3 = new TranslateTransition();
    TranslateTransition trans4 = new TranslateTransition();
    TranslateTransition trans5 = new TranslateTransition();
    int jump = 1;
    int coincount = 0;

    // private double x;
    // private double y;
    // public void initial() {

    // }

    public void serialize() throws IOException {
        ObjectOutputStream out = null;
        svfile2 = new save(avatar.getLayoutX(), avatar.getLayoutY(), coincount, scorecount, ressurect, knife, shuri,
                weaponflag, scenePane.getLayoutX(), pane.getLayoutX(), pane2.getLayoutX(), settings.getLayoutX(),
                coincounter.getLayoutX(), scorelLabel.getLayoutX());// weaponflag =0 is shuri
        try {
            out = new ObjectOutputStream(new FileOutputStream("out.txt"));
            out.writeObject(svfile2);
        } finally {
            out.close();

        }
    }

    public void saving_progress() throws IOException {
        serialize();
        System.out.println("success ih");
    }

    public void shooting(int i) {
        if (i == 0) {

            shoot_weapon.add(new weapon(scenePane, 20, 20, avatar.getLayoutX(), avatar.getLayoutY(),
                    "The_Will_Hero-main/w1.png"));
            // if (shoot_weapon.get(shoot_weapon.size() - 1).getlvl() == 0){
            // return;
            // }
            if (shoot_weapon.get(shoot_weapon.size() - 1).getlvl() == 1) {
                shoot_weapon.get(shoot_weapon.size() - 1).setinp(scenePane);
                shoot_trans.add(new TranslateTransition());
                shoot_trans.get(shoot_trans.size() - 1).setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans.get(shoot_trans.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans.get(shoot_trans.size() - 1).setByX(avatar.getX() + 500);

                shoot_trans.get(shoot_trans.size() - 1).play();
            }
            if (shoot_weapon.get(shoot_weapon.size() - 1).getlvl() == 2) {
                shoot_weapon2.add(new weapon(scenePane, 20, 20, avatar.getLayoutX(), avatar.getLayoutY(),
                        "The_Will_Hero-main/w1.png"));
                shoot_weapon2.get(shoot_weapon2.size() - 1).setinp(scenePane);
                shoot_trans.add(new TranslateTransition());
                shoot_trans.get(shoot_trans.size() - 1).setNode(shoot_weapon2.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans.get(shoot_trans.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans.get(shoot_trans.size() - 1).setByX(avatar.getX() + 500);

                shoot_trans2.add(new TranslateTransition());
                shoot_trans2.get(shoot_trans2.size() - 1).setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans2.get(shoot_trans2.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans2.get(shoot_trans2.size() - 1).setByX(avatar.getX() + 500);

                shoot_trans21.add(new TranslateTransition());
                shoot_trans21.get(shoot_trans21.size() - 1)
                        .setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans21.get(shoot_trans21.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans21.get(shoot_trans21.size() - 1).setByY(avatar.getY() - 100);

                shoot_trans.get(shoot_trans.size() - 1).play();
                shoot_trans2.get(shoot_trans2.size() - 1).play();
                shoot_trans21.get(shoot_trans21.size() - 1).play();
            }

        } else {
            try {
                shoot_weapon.add(new weapon(scenePane, 20, 5, avatar.getLayoutX(), avatar.getLayoutY() + 26,
                        "The_Will_Hero-main/w2.png"));
            } catch (Exception e) {
                System.out.println("hi");
            }
            if (shoot_weapon.get(shoot_weapon.size() - 1).getlvl() == 1) {
                shoot_weapon.get(shoot_weapon.size() - 1).setinp(scenePane);
                shoot_trans.add(new TranslateTransition());
                shoot_trans.get(shoot_trans.size() - 1).setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans.get(shoot_trans.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans.get(shoot_trans.size() - 1).setByX(avatar.getX() + 500);

                shoot_trans.get(shoot_trans.size() - 1).play();
            }
            if (shoot_weapon.get(shoot_weapon.size() - 1).getlvl() == 2) {
                try {
                    shoot_weapon2.add(new weapon(scenePane, 20, 5, avatar.getLayoutX(), avatar.getLayoutY() + 18,
                            "The_Will_Hero-main/w2.png"));
                } catch (Exception e) {
                    System.out.println("go");
                }
                shoot_weapon2.get(shoot_weapon2.size() - 1).setinp(scenePane);
                shoot_trans.add(new TranslateTransition());
                shoot_trans.get(shoot_trans.size() - 1).setNode(shoot_weapon2.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans.get(shoot_trans.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans.get(shoot_trans.size() - 1).setByX(avatar.getX() + 500);

                shoot_trans2.add(new TranslateTransition());
                shoot_trans2.get(shoot_trans2.size() - 1).setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans2.get(shoot_trans2.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans2.get(shoot_trans2.size() - 1).setByX(avatar.getX() + 500);

                shoot_trans21.add(new TranslateTransition());
                shoot_trans21.get(shoot_trans21.size() - 1)
                        .setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans21.get(shoot_trans21.size() - 1).setDuration(Duration.millis(500));
                shoot_trans21.get(shoot_trans21.size() - 1).setByY(avatar.getY() - 100);

                shoot_trans.get(shoot_trans.size() - 1).play();
                shoot_trans2.get(shoot_trans2.size() - 1).play();
                // shoot_trans21.get(shoot_trans21.size() - 1).play();
            }

            // shootcheck.start();

        }
        // trans4.stop();
    }

    public void magicpower(int k, int n) throws InterruptedException {
        // TimeUnit.MILLISECONDS.sleep(50);
        // change_skin();
        // TimeUnit.MILLISECONDS.sleep(50);

        for (int i = 0; i < n; i++) {

            shooting(k);

            TimeUnit.MILLISECONDS.sleep(50);
        }

        // TimeUnit.MILLISECONDS.sleep(50);
        // change_skin2();
    }

    public void change_skin() {
        avatar.setImage(new Image("The_Will_Hero-main/Helmet2.png"));
    }

    public void change_skin2() {
        avatar.setImage(new Image("The_Will_Hero-main/avatar1.png"));
    }

    public void magicpower2() {
        setpowerup = 1;
    }

    public void play(MouseEvent m2) throws IOException, InterruptedException {
        // avatar.setTranslateX(avatar.getX() + 50);
        // avatar.setLayoutX(avatar.getLayoutX() + 50);
        Stage stage;
        Scene scene;
        mousie = m2;

        int prevX = (int) avatar.getLayoutX();
        willhero.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("load.fxml"));

        stage = (Stage) ((Node) m2.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("bg.css").toExternalForm();
        scene.getStylesheets().add(css);

        avatar.setLayoutX(avatar.getLayoutX() + 50);
        pane.setLayoutX(pane.getLayoutX() + 50);
        scenePane.setLayoutX(scenePane.getLayoutX() - 50);
        settings.setLayoutX(settings.getLayoutX() + 50);
        pane2.setLayoutX(pane2.getLayoutX() + 50);
        coincounter.setLayoutX(coincounter.getLayoutX() + 50);
        scorelLabel.setLayoutX(scorelLabel.getLayoutX() + 50);
        // jumping.start();
        // magicpower2();
        // change_skin();
        try {
            if (setpowerup == 0) {
                shooting(0);// 0 is for shuriken 1 is for knife
            }
            if (setpowerup == 1) {
                shooting(0);
                shooting(1);
            }

            // magicpower(0, 5);

            // shooting(0);

            if (avatar.getLayoutX() > prevX) {
                scorecount++;
            }
            scorelLabel.setText("" + scorecount);
            if (scorecount > 100) {
                change_skin();
            }
        } catch (Exception e) {
            System.out.println("fo");
        }
        // shooting.start();
        // trans4.setNode(knife.getIsl1());
        // trans4.setDuration(Duration.millis(100));
        // trans4.setByX(avatar.getY() + 90);
        // // trans4.setCycleCount(TranslateTransition.INDEFINITE);
        // // trans4.setAutoReverse(true);
        // trans4.play();
        // // trans4.stop();
        // knife.getIsl1().relocate(avatar.getLayoutX(), avatar.getLayoutY());

        // stage.setX(stage.getX() + 50);

    }

    public void gear() {
        // init(m);
        trans.pause();
        jumping.stop();
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
        jumping.start();
        // trans1.play();
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
        mousie = c;
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

    AnimationTimer shootcheck = new AnimationTimer() {

        @Override
        public void handle(long now) {

            if (shoot_weapon.get(shoot_weapon.size() - 1).getlvl() == 1) {
                for (int i = 0; i < shoot_trans.size(); i++) {
                    if (shoot_trans.get(i).getStatus() == Animation.Status.STOPPED) {
                        shoot_weapon.get(i).getIsl1().setVisible(false);
                        scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                    }
                    if (shoot_trans.get(i).getStatus() == Animation.Status.RUNNING) {
                        if (checkCollision(ORC, shoot_weapon.get(i).getIsl1())) {
                            shoot_weapon.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                            // shoot_weapon2.get(i).getIsl1().setVisible(false);
                            // scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                        }
                    }
                }
            }
            if (shoot_weapon.get(shoot_weapon.size() - 1).getlvl() == 2) {// level check from shoot weapon only
                for (int i = 0; i < shoot_trans2.size(); i++) {
                    if (shoot_trans2.get(i).getStatus() == Animation.Status.STOPPED) {
                        shoot_weapon.get(i).getIsl1().setVisible(false);
                        scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                        shoot_weapon2.get(i).getIsl1().setVisible(false);
                        scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                    }
                    if (shoot_trans2.get(i).getStatus() == Animation.Status.RUNNING) {
                        if (checkCollision(ORC, shoot_weapon.get(i).getIsl1())) {
                            shoot_weapon.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                            shoot_weapon2.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                        }
                    }
                }
            }

        };
    };
    AnimationTimer jumping2 = new AnimationTimer() {
        double time = 0;
        double velocityY = 0;
        double velocityX = 0;

        int counter = 0;

        @Override
        public void handle(long timestamp) {
            double x = ORC.getLayoutX();
            double y = ORC.getLayoutY();

            velocityY += 12 * 0.5 * Math.pow(time, 2);
            y = y + velocityY;
            x = x + velocityX;

            for (int k = 0; k < ISLAND1.size(); k++) {
                if (checkCollision(ORC, ISLAND1.get(k).getIsl1())) {
                    velocityY = -4.5;

                    coincount++;
                    velocityX = 0;
                    coincounter.setText("Coins " + coincount);
                    // System.out.println("vsl set to 0 by isl1");
                    time = .13;
                }
            }

            for (int k = 0; k < ISLAND2.size(); k++) {
                if (checkCollision(ORC, ISLAND2.get(k).getIsl1())) {
                    velocityY = -4.5;
                    velocityX = 0;
                    // System.out.println("vx set to 0 by isl2");
                    time = .13;
                }
            }
            for (int k = 0; k < shoot_weapon.size(); k++) {
                if (checkCollision(ORC, shoot_weapon.get(k).getIsl1())) {
                    velocityX = 0;
                    // System.out.println("vslset3");
                    time = .13;

                }
            }
            for (int k = 0; k < shoot_weapon2.size(); k++) {
                if (checkCollision(ORC, shoot_weapon2.get(k).getIsl1())) {
                    velocityX = 0;
                    time = .13;
                    // System.out.println("vslset2");
                    // velocityY = 0;

                }
            }

            if (checkCollision(ORC, avatar)) {// || checkCollision(avatar,
                // ISLAND1.get(1).getIsl1())) {
                velocityX = 0;
                // System.out.println("vslset1");
                time = .13;
            }

            ORC.relocate(x, y);
            // time+=0.001;
        }
    };

    AnimationTimer jumping = new AnimationTimer() {
        double time = 0;
        double velocityY = 0;
        int counter = 0;

        @Override
        public void handle(long timestamp) {
            double x = avatar.getLayoutX();
            double y = avatar.getLayoutY();

            velocityY += 12 * 0.5 * Math.pow(time, 2);
            y = y + velocityY;

            for (int k = 0; k < ISLAND1.size(); k++) {
                if (checkCollision(avatar, ISLAND1.get(k).getIsl1())) {// || checkCollision(avatar,
                                                                       // ISLAND1.get(1).getIsl1())) {
                    velocityY = -4.5;
                    time = .13;
                    coincount++;
                    coincounter.setText("Coins " + coincount);
                }
            }
            for (int k = 0; k < ISLAND2.size(); k++) {
                if (checkCollision(avatar, ISLAND2.get(k).getIsl1())) {// || checkCollision(avatar,
                                                                       // ISLAND1.get(1).getIsl1())) {
                    velocityY = -4.5;
                    time = .13;
                }
            }
            // if (checkOrcCrush(avatar, deathline)) {
            // gear();
            // }
            avatar.relocate(x, y);
            // time+=0.001;
        }
    };

    // public void up(ActionEvent e) {
    // // System.out.println("t1");

    // }
    RotateTransition rotate = new RotateTransition();
    RotateTransition rot2 = new RotateTransition();
    RotateTransition rot3 = new RotateTransition();
    RotateTransition rot4 = new RotateTransition();
    Rotate rotate2 = new Rotate();
    Rotate rotate3 = new Rotate();
    Rotate rotate4 = new Rotate();
    Rotate rotate5 = new Rotate();

    AnimationTimer rot = new AnimationTimer() {
        Group group;

        @Override
        public void handle(long timestamp) {

            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(360000);
            rotate.setCycleCount(Animation.INDEFINITE);
            rotate.setDuration(Duration.millis(1000000));
            // rotate.setAutoReverse(true);
            rotate.setRate(1);
            rotate.setNode(blade.getwindmill());
            rotate.play();

            rot2.setAxis(Rotate.Z_AXIS);
            rot2.setByAngle(360000);
            // rot2.currentRateProperty(10);
            // rot2.cycleDurationProperty(1000000);
            rot2.setRate(1);
            rot2.setCycleCount(Animation.INDEFINITE);
            rot2.setDuration(Duration.millis(1000000));
            // rotate.setAutoReverse(true);
            rot2.setNode(blade1.getwindmill());
            rot2.play();

            rot3.setAxis(Rotate.Z_AXIS);
            rot3.setByAngle(360000);
            // rot2.currentRateProperty(10);
            // rot2.cycleDurationProperty(1000000);
            rot3.setRate(1);
            rot3.setCycleCount(Animation.INDEFINITE);
            rot3.setDuration(Duration.millis(1000000));
            // rotate.setAutoReverse(true);
            rot3.setNode(blade2.getwindmill());
            rot3.play();

            rot4.setAxis(Rotate.Z_AXIS);
            rot4.setByAngle(360000);
            // rot2.currentRateProperty(10);
            // rot2.cycleDurationProperty(1000000);
            rot4.setRate(1);
            rot4.setCycleCount(Animation.INDEFINITE);
            rot4.setDuration(Duration.millis(1000000));
            // rotate.setAutoReverse(true);
            rot4.setNode(blade3.getwindmill());
            rot4.play();

        }
    };

    public void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {

            in = new ObjectInputStream(new FileInputStream("out.txt"));

            ldfile = (save) in.readObject();
            System.out.println("sucess");

        } finally {
            in.close();
        }
    }

    public void init(MouseEvent m) throws ClassNotFoundException, IOException {
        deserialize();
        avatar.setLayoutX(ldfile.player_x);
        avatar.setLayoutY(ldfile.player_y);
        coincount = ldfile.coins;
        scorecount = ldfile.moves_done;
        System.out.println(scorecount + " " + ldfile.moves_done);
        ressurect = ldfile.ressurect;
        knife = ldfile.knife_lvl;
        shuri = ldfile.shuriken_lvl;
        weaponflag = ldfile.weapon_flag;
        scenePane.setLayoutX(ldfile.ap_x);
        pane.setLayoutX(ldfile.p1_x);
        pane2.setLayoutX(ldfile.p2_x);
        settings.setLayoutX(ldfile.gear);
        coincounter.setLayoutX(ldfile.coinscounter);
        scorelLabel.setLayoutX(avatar.getLayoutX());

        //orc = new orc(scenePane, 75, 75, 300, 270, avatar);
        blade = new windmill(scenePane, 180, 20, 400, 80, avatar);
        blade1 = new windmill(scenePane, 180, 20, 400, 80, avatar);

        blade2 = new windmill(scenePane, 180, 20, 400, 80, avatar);
        blade3 = new windmill(scenePane, 180, 20, 400, 80, avatar);
        // blade2 = new windmill(scenePane, 100, 20, 400, 100, avatar);
        // blade3 = new windmill(scenePane, 100, 20, 400, 100, avatar);
        blade1.getwindmill().setRotate(90);
        // blade2.getwindmill().setRotate(180);
        blade3.getwindmill().setRotate(90);
        rot.start();
        // blade.getwindmill().setRotate(360);

        // blade.getwindmill().getTransforms().
        // rotate2.setPivotX(510);
        // rotate2.setPivotY(110);
        // rotate3.setPivotX(510);
        // rotate3.setPivotY(110);

        // Timeline timeline = new Timeline(
        // new KeyFrame(Duration.ZERO, new KeyValue(rotate2.angleProperty(), 0)),
        // new KeyFrame(Duration.seconds(20), new KeyValue(rotate2.angleProperty(),
        // 360)));
        // Timeline timeline2 = new Timeline(
        // new KeyFrame(Duration.ZERO, new KeyValue(rotate3.angleProperty(), 0)),
        // new KeyFrame(Duration.seconds(20), new KeyValue(rotate3.angleProperty(),
        // 360)));
        // blade.getwindmill().getTransforms().add(rotate2);
        // blade1.getwindmill().getTransforms().add(rotate3);
        // // blade2.getwindmill().getTransforms().add(rotate2);
        // // blade3.getwindmill().getTransforms().add(rotate2);
        // timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline2.setCycleCount(Timeline.INDEFINITE);
        for (int i = 0; i < 13; i++) {
            ISLAND1.add(new island(scenePane, 184, 143, 195 + (400 * i), 245));
            ISLAND1.get(ISLAND1.size() - 1).getIsl1().toBack();
            // if (i % 2 == 0) {
            // ISLAND1.add(new island(scenePane, 100, 70, 600 + (1500 * i), 245));
            // } else {
            // ISLAND1.add(new island(scenePane, 160, 90, 195 + (337 * i), 250));
            // }

        }
        for (int i = 0; i < 9; i++) {
            ISLAND2.add(new island(scenePane, 150, 100, 400 + (720 * i), 245));
            ISLAND2.get(ISLAND2.size() - 1).getIsl1().toBack();
            // if (i % 2 == 0) {
            // ISLAND2.add(new island(scenePane, 140, 120, 561 + (439 * i), 245));
            // } else {
            // ISLAND1.add(new island(scenePane, 160, 90, 195 + (337 * i), 290));
            // }

        }
        ISLAND2.add(new island(scenePane, 800, 50, 5660, 245));
        ISLAND2.get(ISLAND2.size() - 1).getIsl1().toBack();

        try {
            shootcheck.start();
            rot.start();
            jumping.start();
            jumping2.start();
            initt.setDisable(true);
            // timeline.play();
            // timeline2.play();
        } catch (Exception e) {
            System.out.println("yo");
        }
        System.out.println("Game Initialized ! ");

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("Default init :Input Recieved ");

    }

    public boolean checkCollision(ImageView avatar, Group obj) {
        if (avatar.getBoundsInParent().intersects(obj.getBoundsInParent()) == true) {

            // System.out.println("collisiion");
            return true;
        }

        return false;

    }

    public boolean checkCollision(ImageView avatar, ImageView obj) {
        if (avatar.getBoundsInParent().intersects(obj.getBoundsInParent()) == true) {

            // System.out.println("C");
            return true;
        }

        return false;

    }

    public boolean checkOrcCrush(ImageView avatar, Rectangle obj) {
        if (avatar.getBoundsInParent().intersects(obj.getBoundsInParent()) == true) {

            // System.out.println("crushed by orc");

            return true;
        }

        return false;
    }
}
