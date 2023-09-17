import java.util.ArrayList;

public class Train {
    private int id;
    private ArrayList<Railcar> railcars; 

    public Train(int id) {
        this.id = id;
        this.railcars = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    

    public boolean engage(Railcar rc) {

        if(rc instanceof Locomotive){
                if(railcars.size()==0){
                    railcars.add(rc);
                    return true;
                }
                if(railcars.get(railcars.size()-1) instanceof Locomotive){
                    railcars.add(rc);
                    return true;
                }
                return false;
        }
        if(rc instanceof Wagon){
                if(railcars.size()==0){
                    return false;
                }
                railcars.add(rc);
                return true;
        }
        return false;
    }

    public boolean removeLastRailcar() {
        if (!railcars.isEmpty()) {
            Railcar removedRailcar = railcars.remove(railcars.size() - 1);
            removedRailcar.setTrain(null);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Train id = " + id + " | ");
        for (Railcar railcar : railcars) {
            result.append("[").append(railcar.getClass().getSimpleName()).append(" id = ").append(railcar.getId()).append("] | ");
        }
        return result.toString().trim();
    }

    public ArrayList<Railcar> getRailcars() {
        return railcars;
    }
}