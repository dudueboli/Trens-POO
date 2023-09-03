import java.util.ArrayList;

public class Yard {

    private ArrayList<ArrayList<Train>> yard;
    
    public Yard (ArrayList<ArrayList<Train>> yard){
        this.yard = new ArrayList<>(yard);
    }
    public void park (ArrayList<Train> trains){
        ArrayList<Train> trainList = new ArrayList<>(trains);
        yard.add(trainList);
    }
    public ArrayList<Train> remove(int index) {
        if (index >= 0 && index < yard.size()) {
            return yard.remove(index);
        }
        return null;
    }
    public int numberOfTrainLists() {
        return yard.size();
    }
    public ArrayList<Train> get(int index) {
        if (index >= 0 && index < yard.size()) {
            return yard.get(index);
        }
        return null;
    }
    public void printTrains() {
        for (ArrayList<Train> trainList : yard) {
            for (Train train : trainList) {
                System.out.print("Train id = " + train.getId() + " | ");
                
                for (Locomotive loc : train.getLocomotives()) {
                    System.out.print("[Locomotive id = " + loc.getId() + "] ");
                }
                
                System.out.print("| ");
                
                for (Wagon wagon : train.getWagons()) {
                    System.out.print("[Wagon id = " + wagon.getId() + "] ");
                }
                
                System.out.println();
            }
        }
    }
    public ArrayList<ArrayList<Train>> getYard() {
        return yard;
    }
}
