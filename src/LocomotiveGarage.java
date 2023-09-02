import java.util.ArrayList;

public class LocomotiveGarage {
    
    private ArrayList<Locomotive> locGarage;
    
    public LocomotiveGarage(ArrayList<Locomotive> loc) {
        locGarage = new ArrayList<>(loc);
    }
    public void park(Locomotive loc){
        locGarage.add(loc.disengageLocomotive());
    }
    public Locomotive remove(int id){
        for(int i = 0; i<locGarage.size(); i++){
            Locomotive loc = locGarage.get(i);
            if(loc.getId() == id){
                locGarage.remove(i);
                return loc;
            }
        }
        return null;
    }
    public int numberOfLocomotives(){
        return locGarage.size();
    }
    public Locomotive get(int id){
        for(Locomotive loc : locGarage){
            if(loc.getId() == id){
                return loc;
            }
        }
        return null;
    }
    public void printLocomotives() {
        for (Locomotive loc : locGarage) {
            System.out.println(loc);
        }
    }
    

}
