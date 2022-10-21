import java.util.ArrayList;

public class Trading {
    public static ArrayList<Offering> Trades=new ArrayList<>();
    public void accept(NodeVisitor visitor){

    }
    public void addTrade(Offering p){
        Trades.add(p);
    }
    public ArrayList<Offering> viewTrade(){
        return Trades;
    }
}
