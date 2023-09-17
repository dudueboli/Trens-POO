import java.util.ArrayList;

public class RailcarGarage {
    private ArrayList<Railcar> railcars;

    public RailcarGarage() {
        railcars = new ArrayList<>();
    }

    public void park(Railcar rc) {
        railcars.add(rc);
    }

    public Railcar get(int i) {
        if (i >= 0 && i < railcars.size()) {
            return railcars.get(i);
        } else {
            return null;
        }
    }

    public int numberOfRailcars() {
        return railcars.size();
    }

    public Railcar remove(int id) {
        Railcar removedRailcar = null;
        for (int i = 0; i < railcars.size(); i++) {
            Railcar railcar = railcars.get(i);
            if (railcar.getId() == id) {
                removedRailcar = railcars.remove(i);
                break;
            }
        }
        return removedRailcar;
    }
}