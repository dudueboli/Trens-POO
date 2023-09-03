import java.util.ArrayList;

public class WagonGarage {
    
    private ArrayList<Wagon> wagonGarage;

    

    public WagonGarage(ArrayList<Wagon> wagons) {
        wagonGarage = new ArrayList<>(wagons);
    }
    public void park(Wagon wagon){
        wagonGarage.add(wagon);
    }
    public Wagon remove(int id){
        for (int i = 0; i < wagonGarage.size(); i++) {
            Wagon wagon = wagonGarage.get(i);
            if (wagon.getId() == id) {
                wagonGarage.remove(i);
                return wagon;
            }
        }
        return null; 
    }
    public int numberOfLocomotives(){
        return wagonGarage.size();
    }
    public Wagon get(int id){
        for (Wagon wagon : wagonGarage) {
            if (wagon.getId() == id) {
                return wagon;
            }
        }
        return null;
    }
    public void printWagons() {
        for (Wagon wagon  : wagonGarage) {
            System.out.println(wagon);
        }
    }
}
