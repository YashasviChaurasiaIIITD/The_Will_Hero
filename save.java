import java.io.Serializable;
import java.util.ArrayList;

public class save implements Serializable {
    double player_x;
    double player_y;
    int coins;
    int moves_done;// score
    int ressurect;
    int knife_lvl;
    int shuriken_lvl;
    int weapon_flag;
    double ap_x;
    double p1_x;
    double p2_x;
    double p3_x;
    double gear;
    double coinscounter;
    double scorecount;
    ArrayList<Integer> orcflags;
    ArrayList<Double> orcx;
    ArrayList<Double> orcy;

    ArrayList<Double> topx;
    ArrayList<Double> topy;

    ArrayList<Double> botx;
    ArrayList<Double> boty;

    public save(double x, double y, int coin, int moves, int rflag, int knife, int shuri, int wflag,double ap_x,double p1_x,double p2_x,double gear,double coinscounter,double score,double p3_x,
    ArrayList<Integer> oflags,ArrayList<Double> ox,ArrayList<Double> oy,ArrayList<Double> tx,ArrayList<Double> ty,ArrayList<Double> bx,ArrayList<Double> by)        
 
    {
        player_x = x;
        player_y = 220;
        coins = coin;
        moves_done = moves;
        ressurect = rflag;
        knife_lvl = knife;
        shuriken_lvl = shuri;
        weapon_flag = wflag;
        this.ap_x=ap_x;
        this.p1_x=p1_x;
        this.p2_x=p2_x;
        this.p3_x=p3_x;
        this.gear=gear;
        this.coinscounter=coinscounter;
        this.scorecount=scorecount;
        orcflags=oflags;
        orcx=ox;
        orcy=oy;
        topx=tx;
        topy=ty;
        botx=bx;
        boty=by;
    }

}
