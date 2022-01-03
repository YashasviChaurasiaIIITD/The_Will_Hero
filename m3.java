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
import javafx.scene.control.Button;
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
public class m3 implements Initializable {

    @FXML
    private Rectangle under;
    @FXML
    private Rectangle deathline;
    @FXML
    private Pane p3;

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
    private ImageView shurimg;
    @FXML
    private ImageView knifimg;
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
    private Button b1;

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
    private Label playagain;
    @FXML
    private Label gameover;
    @FXML
    private Label ressure;
    @FXML
    private Label exittomain;

    @FXML
    private Label exitm;// to main menu

    int scorecount = 0;

    int y;
    ArrayList<coin> coins = new ArrayList<coin>();
    int weaponobtained = 0;// -1 is no weapon 0 is shuri 1 is knife
    weapon w1;
    weapon w2;

    windmill blade;
    windmill blade1;
    windmill blade2;
    windmill blade3;

    weaponchest wchest1;
    weaponchest wchest2;

    int knife = 0;
    int shuri = 0;// keeps levels of weapons //update them too while updating weapon objects in

    public void updateshuri(MouseEvent e) {
        weaponobtained = 0;
        shuri++;
    }
    // code

    orc orc;
    save svfile;
    avatar hero;
    save ldfile;
    cChest coinchest;

    ArrayList<island> ISLAND1 = new ArrayList<island>();
    int setpowerup = 0;
    int ressurect = 0;
    ArrayList<island> ISLAND2 = new ArrayList<island>();
    ArrayList<island> ISLAND3 = new ArrayList<island>();
    ArrayList<Node> WeaponNode = new ArrayList<Node>();
    Group group;
    ArrayList<weapon> shoot_weapon = new ArrayList<weapon>();

    ArrayList<weapon> shoot_weapon1 = new ArrayList<weapon>();
    ArrayList<weapon> shoot_weapon2 = new ArrayList<weapon>();

    ArrayList<TranslateTransition> shoot_trans = new ArrayList<TranslateTransition>();

    ArrayList<TranslateTransition> shoot_trans1 = new ArrayList<TranslateTransition>();
    ArrayList<TranslateTransition> shoot_trans2 = new ArrayList<TranslateTransition>();
    ArrayList<TranslateTransition> shoot_trans21 = new ArrayList<TranslateTransition>();

    ArrayList<orc> orcs = new ArrayList<orc>();
    ArrayList<boundary> topboundaries = new ArrayList<boundary>();
    ArrayList<boundary> bottomboundaries = new ArrayList<boundary>();
    ArrayList<weaponchest> weaponchestsLIST = new ArrayList<weaponchest>();

    ArrayList<Integer> oflags = new ArrayList<Integer>();
    ArrayList<Double> ox = new ArrayList<Double>();
    ArrayList<Double> oy = new ArrayList<Double>();

    ArrayList<Double> tx = new ArrayList<Double>();
    ArrayList<Double> ty = new ArrayList<Double>();

    ArrayList<Double> bx = new ArrayList<Double>();
    ArrayList<Double> by = new ArrayList<Double>();
    ArrayList<windmill> blades = new ArrayList<windmill>();

    TranslateTransition trans1 = new TranslateTransition();
    TranslateTransition trans = new TranslateTransition();
    TranslateTransition trans2 = new TranslateTransition();
    TranslateTransition trans3 = new TranslateTransition();
    TranslateTransition trans4 = new TranslateTransition();
    TranslateTransition trans5 = new TranslateTransition();
    int jump = 1;
    MouseEvent mousie;

    int coincount = 0;

    // private double x;
    // private double y;
    // public void initial() {

    // }
    public void shootarray() throws InterruptedException, IOException {
        magicpower(0, 5);
    }

    public void serialize() throws IOException {
        ObjectOutputStream out = null;
        for (orc orc : orcs) {
            oflags.add(orc.getFlag());
            ox.add(orc.getOrc().getLayoutX());
            oy.add(orc.getOrc().getLayoutY());

        }

        for (boundary top : topboundaries) {
            // oflags.add(orc.getFlag());
            tx.add(top.gRectangle().getLayoutX());
            ty.add(top.gRectangle().getLayoutY());

        }
        for (boundary bottom : bottomboundaries) {

            bx.add(bottom.gRectangle().getLayoutX());
            by.add(bottom.gRectangle().getLayoutY());
        }
        svfile = new save(hero.getOrc().getLayoutX(), hero.getOrc().getLayoutY(), coincount, scorecount, ressurect,
                knife, shuri,
                weaponobtained, scenePane.getLayoutX(), pane.getLayoutX(), pane2.getLayoutX(), settings.getLayoutX(),
                coincounter.getLayoutX(), scorelLabel.getLayoutX(), p3.getLayoutX(), oflags, ox, oy, tx, ty, bx, by);// weaponflag
                                                                                                                     // =0
                                                                                                                     // is
                                                                                                                     // shuri
        try {
            out = new ObjectOutputStream(new FileOutputStream("out.txt"));
            out.writeObject(svfile);
        } finally {
            out.close();
        }
    }

    public void saving_progress(MouseEvent e) throws IOException {
        serialize();
        System.out.println("success serialized!");
    }

    public void shooting(int i) {
        if (i == 0) {// is weapon flag and 0 is shuri 1 is knife

            if (shuri == 1) {// shoot_weapon.get(shoot_weapon.size() - 1).getlvl()
                shoot_weapon.add(new weapon(scenePane, 20, 20, hero.getOrc().getLayoutX(), hero.getOrc().getLayoutY(),
                        "The_Will_Hero-main/w1.png"));// used for lvl 1
                shoot_weapon.get(shoot_weapon.size() - 1).setinp(scenePane);
                shoot_trans.add(new TranslateTransition());
                // weapon and trans added

                shoot_trans.get(shoot_trans.size() - 1).setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans.get(shoot_trans.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans.get(shoot_trans.size() - 1).setByX(hero.getOrc().getX() + 500);

                shoot_trans.get(shoot_trans.size() - 1).play();
                System.out.println(" previous in t: " + shoot_trans.size());
            } else if (shuri == 2) {
                // System.out.println(" previous t: " + shoot_trans.size());
                // System.out.println("next t1: " + shoot_trans1.size());
                // System.out.println("next t2: " + shoot_trans2.size());

                shoot_weapon1.add(new weapon(scenePane, 20, 20, hero.getOrc().getLayoutX(), hero.getOrc().getLayoutY(),
                        "The_Will_Hero-main/w1.png"));// used for lvl 2
                shoot_weapon2.add(new weapon(scenePane, 20, 20, hero.getOrc().getLayoutX(), hero.getOrc().getLayoutY(),
                        "The_Will_Hero-main/w1.png"));// used for lvl 2 but 2nd layer or diagonal

                shoot_weapon1.get(shoot_weapon1.size() - 1).setinp(scenePane);
                shoot_weapon2.get(shoot_weapon2.size() - 1).setinp(scenePane);

                shoot_trans1.add(new TranslateTransition());
                shoot_trans2.add(new TranslateTransition());
                shoot_trans21.add(new TranslateTransition());

                shoot_trans1.get(shoot_trans1.size() - 1)
                        .setNode(shoot_weapon1.get(shoot_weapon1.size() - 1).getIsl1());
                shoot_trans1.get(shoot_trans1.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans1.get(shoot_trans1.size() - 1).setByX(hero.getOrc().getX() + 500);

                shoot_trans2.get(shoot_trans2.size() - 1)
                        .setNode(shoot_weapon2.get(shoot_weapon2.size() - 1).getIsl1());
                shoot_trans2.get(shoot_trans2.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans2.get(shoot_trans2.size() - 1).setByX(hero.getOrc().getX() + 500);

                shoot_trans21.get(shoot_trans21.size() - 1)
                        .setNode(shoot_weapon2.get(shoot_weapon2.size() - 1).getIsl1());
                shoot_trans21.get(shoot_trans21.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans21.get(shoot_trans21.size() - 1).setByY(hero.getOrc().getY() - 100);

                shoot_trans1.get(shoot_trans1.size() - 1).play();
                shoot_trans2.get(shoot_trans2.size() - 1).play();
                shoot_trans21.get(shoot_trans21.size() - 1).play();
            }

        } else if (i == 1) {
            // try {
            // shoot_weapon
            // .add(new weapon(scenePane, 20, 5, hero.getOrc().getLayoutX(),
            // hero.getOrc().getLayoutY() + 26,
            // "The_Will_Hero-main/w2.png"));
            // } catch (Exception e) {
            // System.out.println("hi");

            if (knife == 1) {
                shoot_weapon.add(new weapon(scenePane, 20, 5, hero.getOrc().getLayoutX(), hero.getOrc().getLayoutY(),
                        "The_Will_Hero-main/w2.png"));// used for lvl 1
                shoot_weapon.get(shoot_weapon.size() - 1).setinp(scenePane);
                shoot_trans.add(new TranslateTransition());
                // weapon and trans added

                shoot_trans.get(shoot_trans.size() - 1).setNode(shoot_weapon.get(shoot_weapon.size() - 1).getIsl1());
                shoot_trans.get(shoot_trans.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans.get(shoot_trans.size() - 1).setByX(hero.getOrc().getX() + 500);

                shoot_trans.get(shoot_trans.size() - 1).play();
            } else if (knife == 2) {
                // System.out.println(" previous t: " + shoot_trans.size());
                // System.out.println("next t1: " + shoot_trans1.size());
                // System.out.println("next t2: " + shoot_trans2.size());

                shoot_weapon1.add(new weapon(scenePane, 20, 5, hero.getOrc().getLayoutX(), hero.getOrc().getLayoutY(),
                        "The_Will_Hero-main/w2.png"));// used for lvl 2
                shoot_weapon2.add(new weapon(scenePane, 20, 5, hero.getOrc().getLayoutX(), hero.getOrc().getLayoutY(),
                        "The_Will_Hero-main/w2.png"));// used for lvl 2 but 2nd layer or diagonal

                shoot_weapon1.get(shoot_weapon1.size() - 1).setinp(scenePane);
                shoot_weapon2.get(shoot_weapon2.size() - 1).setinp(scenePane);

                shoot_trans1.add(new TranslateTransition());
                shoot_trans2.add(new TranslateTransition());
                shoot_trans21.add(new TranslateTransition());

                shoot_trans1.get(shoot_trans1.size() - 1)
                        .setNode(shoot_weapon1.get(shoot_weapon1.size() - 1).getIsl1());
                shoot_trans1.get(shoot_trans1.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans1.get(shoot_trans1.size() - 1).setByX(hero.getOrc().getX() + 500);

                shoot_trans2.get(shoot_trans2.size() - 1)
                        .setNode(shoot_weapon2.get(shoot_weapon2.size() - 1).getIsl1());
                shoot_trans2.get(shoot_trans2.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans2.get(shoot_trans2.size() - 1).setByX(hero.getOrc().getX() + 500);

                shoot_trans21.get(shoot_trans21.size() - 1)
                        .setNode(shoot_weapon2.get(shoot_weapon2.size() - 1).getIsl1());
                shoot_trans21.get(shoot_trans21.size() - 1).setDuration(Duration.millis(1000));
                shoot_trans21.get(shoot_trans21.size() - 1).setByY(hero.getOrc().getY() - 100);

                shoot_trans1.get(shoot_trans1.size() - 1).play();
                shoot_trans2.get(shoot_trans2.size() - 1).play();
                shoot_trans21.get(shoot_trans21.size() - 1).play();
            }
        }

        // shootcheck.start();

    }

    // trans4.stop();

    public void magicpower(int k, int n) throws InterruptedException, IOException {
        // TimeUnit.MILLISECONDS.sleep(50);
        // change_skin();
        // TimeUnit.MILLISECONDS.sleep(50);

        for (int i = 0; i < n; i++) {

            shooting(k);

            TimeUnit.MILLISECONDS.sleep(50);
        }

    }

    public void change_skin() {
        hero.getOrc().setImage(new Image("The_Will_Hero-main/Helmet2.png"));
    }

    public void change_skin2() {
        hero.getOrc().setImage(new Image("The_Will_Hero-main/avatar1.png"));
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
        int prevX = (int) hero.getOrc().getLayoutX();
        willhero.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("load.fxml"));

        stage = (Stage) ((Node) m2.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("bg.css").toExternalForm();
        scene.getStylesheets().add(css);

        hero.getOrc().setLayoutX(hero.getOrc().getLayoutX() + 50);
        pane.setLayoutX(pane.getLayoutX() + 50);
        scenePane.setLayoutX(scenePane.getLayoutX() - 50);
        settings.setLayoutX(settings.getLayoutX() + 50);
        pane2.setLayoutX(pane2.getLayoutX() + 50);
        coincounter.setLayoutX(coincounter.getLayoutX() + 50);
        scorelLabel.setLayoutX(scorelLabel.getLayoutX() + 50);
        p3.setLayoutX(p3.getLayoutX() + 50);
        // jumping.start();
        // magicpower2();
        // change_skin();

        try {
            if (setpowerup == 0) {

                shooting(weaponobtained);
                // System.out.println("print "+weaponobtained); // 0 is for shuriken 1 is for
                // knife
            } else if (setpowerup == 1) {
                shooting(0);
                shooting(1);
            } // if pwerup is 1 then it shoots 2 weapons

            // magicpower(0, 5);

            // shooting(0);

            if (hero.getOrc().getLayoutX() > prevX) {
                scorecount++;
            }
            scorelLabel.setText("" + scorecount);
            if (scorecount > 100) {
                change_skin();
            }
        } catch (Exception e) {
            System.out.println(e);
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

    public void chooseshuri() {
        weaponobtained = 0;
    }

    public void chooseknife() {
        weaponobtained = 1;
    }

    // }
    // };
    public void victory() {
        System.out.println("you won my friend!");

    }

    public void revive(MouseEvent e) throws IOException {
        if (coincount >= 1000 && ressurect == 0) {
            System.out.println("in revive");
            coincount = coincount - 1000;
            // hero.getOrc().relocate(1000, 255);// random spawn
            ressurect = 1;
            p3.toBack();
            p3.setDisable(true);
            gameover.setDisable(true);
            playagain.setDisable(true);
            ressure.setDisable(true);
            exittomain.setDisable(true);

            pane.setDisable(false);
            p3.setOpacity(0);
            p3.setVisible(false);
            gameover.setOpacity(0);
            gameover.setVisible(false);
            ressure.setOpacity(0);
            ressure.setVisible(false);
            playagain.setOpacity(0);
            playagain.setVisible(false);
            exittomain.setOpacity(0);
            exittomain.setVisible(false);
            saving_progress(e);
            // scenePane.setLayoutX(1000);
            // pane.setLayoutX(1000);
            // pane2.setLayoutX(1000);
            // p3.setLayoutX(1000);
            // hero.getOrc().relocate(1000, 255);
            Stage stage;
            Scene scene;

            Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.rgb(80, 200, 255)) };
            LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);

            Parent root = FXMLLoader.load(getClass().getResource("load.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, lg1);
            String css = this.getClass().getResource("bg.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            // controller c = new controller();
            // c.init();
            stage.show();

        } else {
            exit(mousie);
        }

    }

    public void endgame() {
        // pane.setDisable(true);
        p3.setDisable(false);
        p3.toFront();
        gameover.setDisable(false);
        playagain.setDisable(false);
        ressure.setDisable(false);
        exittomain.setDisable(false);

        pane.setDisable(true);
        p3.setOpacity(1);
        p3.setVisible(true);
        gameover.setOpacity(1);
        gameover.setVisible(true);
        ressure.setOpacity(1);
        ressure.setVisible(true);
        playagain.setOpacity(1);
        playagain.setVisible(true);
        exittomain.setOpacity(1);
        exittomain.setVisible(true);
        exittomain.toFront();
        // pause.setVisible(true);
        // restart.setVisible(true);
        // exitm.setVisible(true);
        // save.setVisible(true);

    }

    AnimationTimer endscreen = new AnimationTimer() {
        public void handle(long arg0) {
            if (checkOrcCrush(hero.getOrc(), deathline)) {
                endgame();

            } else if (scorecount > 122) {
                victory();
            }
        };
    };
    AnimationTimer chest = new AnimationTimer() {

        @Override
        public void handle(long arg0) {

            if (checkCollision(hero.getOrc(), weaponchestsLIST.get(0).getOrc()) == true) {
                weaponchestsLIST.remove(0);
                weaponchestsLIST.add(0,
                        new weaponchest(scenePane, 55, 40, 451, 212, "The_Will_Hero-main/ChestOpen.png"));
                if (weaponobtained == 0) {
                    // shurimg.setDisable(false);
                    shurimg.setOpacity(1);
                } else if (weaponobtained == 1) {
                    // knifimg.setDisable(false);
                    knifimg.setOpacity(1);
                }

            } else if (checkCollision(hero.getOrc(), weaponchestsLIST.get(1).getOrc()) == true) {
                weaponchestsLIST.remove(1);
                weaponchestsLIST.add(1,
                        new weaponchest(scenePane, 55, 40, 1451, 212, "The_Will_Hero-main/ChestOpen.png"));
                if (weaponobtained == 0) {
                    // shurimg.setDisable(false);
                    shurimg.setOpacity(1);
                } else if (weaponobtained == 1) {
                    // knifimg.setDisable(false);
                    knifimg.setOpacity(1);
                }

            } else if (checkCollision(hero.getOrc(), weaponchestsLIST.get(2).getOrc()) == true) {

                weaponchestsLIST.remove(2);
                weaponchestsLIST.add(2,
                        new weaponchest(scenePane, 55, 40, 4661, 212, "The_Will_Hero-main/ChestOpen.png"));
                if (weaponobtained == 0) {
                    // shurimg.setDisable(false);
                    shurimg.setOpacity(1);
                } else if (weaponobtained == 1) {
                    // knifimg.setDisable(false);
                    knifimg.setOpacity(1);
                }

            }
            if (checkCollision(hero.getOrc(), coinchest.getOrc()) == true) {
                coinchest = new cChest(scenePane, 55, 40, 2651, 212, "The_Will_Hero-main/ChestOpen.png");
                coincount = coincount + 1000;

            }

            if (hero.getOrc().getLayoutX() > weaponchestsLIST.get(0).getOrc().getLayoutX()) {

                shuri = 1;
                weaponobtained = 0;
            }

            if (hero.getOrc().getLayoutX() > weaponchestsLIST.get(0).getOrc().getLayoutX() + 1100) {
                knife = 1;
                weaponobtained = 1;
            }
            if (hero.getOrc().getLayoutX() > weaponchestsLIST.get(0).getOrc().getLayoutX() + 4000) {
                shuri = 2;
                weaponobtained = 0;
            }
            // if(checkCollision(hero.getOrc(), weaponchestsLIST.get(0).getOrc())){
            // weaponobtained=weaponchestsLIST.get(0).openchest();
            // if(weaponobtained==0){
            // shuri=1;
            // }
            // if(weaponobtained==1){
            // knife=1;
            // }
            // }
        };
    };
    AnimationTimer shootcheck = new AnimationTimer() {

        @Override
        public void handle(long now) {
            if (weaponobtained == 0) {
                if (shuri == 1) {
                    for (int i = 0; i < shoot_trans.size(); i++) {
                        if (shoot_trans.get(i).getStatus() == Animation.Status.STOPPED) {
                            shoot_weapon.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                            // shoot_weapon.remove(i);
                            // shoot_trans.remove(i);
                        }
                        if (shoot_trans.get(i).getStatus() == Animation.Status.RUNNING) {

                            for (int k = 0; k < orcs.size(); k++) {
                                if (checkCollision(orcs.get(k).getOrc(), shoot_weapon.get(i).getIsl1())) {
                                    shoot_weapon.get(i).getIsl1().setVisible(false);
                                    scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                                    // shoot_weapon2.get(i).getIsl1().setVisible(false);
                                    // scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                                }
                            }
                        }
                    }
                }
                if (shuri == 2) {// level check from shoot weapon only
                    for (int i = 0; i < shoot_trans1.size(); i++) {
                        if (shoot_trans1.get(i).getStatus() == Animation.Status.STOPPED) {
                            shoot_weapon1.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon1.get(i).getIsl1());

                            shoot_weapon2.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                        } else if (shoot_trans1.get(i).getStatus() == Animation.Status.RUNNING) {
                            for (int k = 0; k < orcs.size(); k++) {
                                if (checkCollision(orc.getOrc(), shoot_weapon.get(i).getIsl1())) {
                                    shoot_weapon.get(i).getIsl1().setVisible(false);
                                    scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                                    // shoot_weapon2.get(i).getIsl1().setVisible(false);
                                    // scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                                }
                            }
                        }
                    }
                }
            }
            if (weaponobtained == 1) {
                if (knife == 1) {
                    for (int i = 0; i < shoot_trans.size(); i++) {
                        if (shoot_trans.get(i).getStatus() == Animation.Status.STOPPED) {
                            shoot_weapon.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                        }
                        if (shoot_trans.get(i).getStatus() == Animation.Status.RUNNING) {
                            for (int k = 0; k < orcs.size(); k++) {
                                if (checkCollision(orcs.get(k).getOrc(), shoot_weapon.get(i).getIsl1())) {
                                    shoot_weapon.get(i).getIsl1().setVisible(false);
                                    scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                                    // shoot_weapon2.get(i).getIsl1().setVisible(false);
                                    // scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                                }
                            }
                        }
                    }
                }
                if (knife == 2) {// level check from shoot weapon only
                    for (int i = 0; i < shoot_trans2.size(); i++) {
                        if (shoot_trans2.get(i).getStatus() == Animation.Status.STOPPED) {
                            shoot_weapon.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                            shoot_weapon2.get(i).getIsl1().setVisible(false);
                            scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());

                        }
                        if (shoot_trans2.get(i).getStatus() == Animation.Status.RUNNING) {
                            for (int k = 0; k < orcs.size(); k++) {
                                if (checkCollision(orcs.get(k).getOrc(), shoot_weapon.get(i).getIsl1())) {
                                    shoot_weapon.get(i).getIsl1().setVisible(false);
                                    scenePane.getChildren().remove(shoot_weapon.get(i).getIsl1());
                                    // shoot_weapon2.get(i).getIsl1().setVisible(false);
                                    // scenePane.getChildren().remove(shoot_weapon2.get(i).getIsl1());
                                }
                            }
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

            if (checkCollision(ORC, hero.getOrc())) {// || checkCollision(avatar,
                // ISLAND1.get(1).getIsl1())) {
                velocityX = 0;
                // System.out.println("vslset1");
                time = .13;
            }

            // ORC.relocate(x, y);
            // time+=0.001;
        }
    };

    AnimationTimer jumping = new AnimationTimer() {

        @Override
        public void handle(long timestamp) {
            double x = hero.getOrc().getLayoutX();
            double y = hero.getOrc().getLayoutY();

            for (int k = 0; k < ISLAND1.size(); k++) {
                if (checkCollision(hero.getOrc(), ISLAND1.get(k).getIsl1())) {// ||
                                                                              // checkCollision(avatar,

                    coincount++;
                    coincounter.setText("Coins " + coincount);
                }
            }
            for (int k = 0; k < ISLAND2.size(); k++) {
                if (checkCollision(hero.getOrc(), ISLAND2.get(k).getIsl1())) {// ||
                                                                              // checkCollision(avatar,
                    // ISLAND1.get(1).getIsl1())) {

                }
            }
            if (checkOrcCrush(hero.getOrc(), deathline)) {
                // gear();
            }

            // hero.getOrc().relocate(x, y);
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
    AnimationTimer playa;
    AnimationTimer newa;
    ArrayList<AnimationTimer> anims = new ArrayList<AnimationTimer>();

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
        oflags = ldfile.orcflags;
        ox = ldfile.orcx;
        oy = ldfile.orcy;
        tx = ldfile.topx;
        ty = ldfile.topy;
        bx = ldfile.botx;
        by = ldfile.boty;
        boundary barrier = new boundary(scenePane, 6000, 1, 0, 300);
        for (int k = 0; k < 10; k++) {
            System.out.println("oflag " + oflags.get(k));
            if (oflags.get(k) == 1) {

                topboundaries.add(new boundary(scenePane, 30, 1, tx.get(k), 230));
                bottomboundaries.add(new boundary(scenePane, 30, 1, bx.get(k), 280));

            }
        }
        blade = new windmill(scenePane, 180, 20, 400, 80);
        blade1 = new windmill(scenePane, 180, 20, 400, 80);

        blade2 = new windmill(scenePane, 180, 20, 3400, 100);
        blade3 = new windmill(scenePane, 180, 20, 3400, 100);
        blade1.getwindmill().setRotate(90);
        // blade2.getwindmill().setRotate(180);
        blade3.getwindmill().setRotate(90);
        blades.add(blade);
        blades.add(blade1);
        blades.add(blade2);
        blades.add(blade3);
        hero = new avatar(scenePane, 20, 25, 300, 225, barrier.gRectangle(), topboundaries, bottomboundaries, ISLAND1,
                ISLAND2, coins, blades);

        for (int a = 0; a < 10; a++) {
            if (oflags.get(a) == 1) {
                orcs.add(new orc(scenePane, 60, 60, ox.get(a), 225, hero.getOrc(), ISLAND1, barrier.gRectangle(),
                        shoot_weapon, shoot_weapon2, new boundary(scenePane, 30, 1, tx.get(a), 230),
                        new boundary(scenePane, 30, 1, bx.get(a), 280)));
            }
            // orcs.add(new orc(scenePane, 60, 60, 195 + (400 * a), 225, hero.getOrc(),
            // ISLAND1, barrier.gRectangle(), shoot_weapon,shoot_weapon2,
            // topboundaries.get(a), bottomboundaries.get(a)));

            if (a % 3 == 0) {
                // orcs.get(a).setImg();
            }

        }
        for (int a = 0; a < orcs.size(); a++) {
            anims.add(orcs.get(a).getanim());
        }
        coinchest = new cChest(scenePane, 55, 40, 2651, 212, "The_Will_Hero-main/crest.png");

        weaponchestsLIST.add(0, new weaponchest(scenePane, 55, 40, 451, 212, "The_Will_Hero-main/crest.png"));
        weaponchestsLIST.add(1, new weaponchest(scenePane, 55, 40, 1451, 212, "The_Will_Hero-main/crest.png"));
        weaponchestsLIST.add(2, new weaponchest(scenePane, 55, 40, 4661, 212, "The_Will_Hero-main/crest.png"));
        // orcs.add();
        // orc = new orc(scenePane, 60, 60, 625, 225, hero.getOrc(), ISLAND1,
        // barrier.gRectangle(), shoot_weapon,
        // shoot_weapon2, topboundaries.get(0), bottomboundaries.get(0));

        playa = hero.getanim();
        // newa = orc.getanim();

        for (

                int a = 0; a < 10; a++) {

            orcs.add(new orc(scenePane, 60, 60, 195 + (400 * a), 225, hero.getOrc(), ISLAND1, barrier.gRectangle(),
                    shoot_weapon, shoot_weapon2, topboundaries.get(a), bottomboundaries.get(a)));

            if (a % 3 == 0) {
                // orcs.get(a).setImg();
            }

        }
        for (int a = 0; a < 10; a++) {
            anims.add(orcs.get(a).getanim());
        }
        hero.getOrc().setLayoutX(ldfile.player_x);
        hero.getOrc().setLayoutY(ldfile.player_y);
        coincount = ldfile.coins;
        scorecount = ldfile.moves_done;
        System.out.println(scorecount + " " + ldfile.moves_done);
        ressurect = ldfile.ressurect;
        knife = ldfile.knife_lvl;
        shuri = ldfile.shuriken_lvl;
        weaponobtained = ldfile.weapon_flag;
        scenePane.setLayoutX(ldfile.ap_x);
        pane.setLayoutX(ldfile.p1_x);
        pane2.setLayoutX(ldfile.p2_x);
        settings.setLayoutX(ldfile.gear);
        coincounter.setLayoutX(ldfile.coinscounter);
        scorelLabel.setLayoutX(hero.getOrc().getLayoutX());

        // orc = new orc(scenePane, 75, 75, 300, 270, avatar);

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
        // blade2.getwindmill().getTransforms().add(rotate2);
        // blade3.getwindmill().getTransforms().add(rotate2);
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
        ISLAND2.add(new island(scenePane, 600, 100, 5760, 245));
        ISLAND2.get(ISLAND2.size() - 1).getIsl1().toBack();
        try {
            for (int a = 0; a < 10; a++) {
                anims.get(a).start();
            }
            shootcheck.start();
            rot.start();
            // newa.start();
            chest.start();
            playa.start();
            jumping.start();
            endscreen.start();

            // jumping2.start();
            initt.setDisable(true);
            // timeline.play();
            // timeline2.play();
        } catch (Exception e) {
            System.out.println("yo");
            System.out.println("Game Initialized ! ");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("Default init :Input Recieved ");

    }

    public boolean checkCollision(ImageView avatar, Group obj) {
        if (avatar.intersects(obj.getBoundsInParent()) == true) {

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