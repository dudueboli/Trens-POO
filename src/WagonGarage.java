import java.util.ArrayList;

public class WagonGarage {
    
    private Wagon wagon;
    private int id;
    private ArrayList<Wagon> wagonGarage;

    public void park(Wagon wagon){
        wagonGarage.add(wagon.disengageWagon());
    }
    public Wagon remove(int id){
        wagonGarage.remove(id);
        return wagon.getW(id);
    }
    public int numberOfLocomotives(){
        return wagonGarage.size();
    }
    public Wagon get(int id){
        return wagon;
    }

}
