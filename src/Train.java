import java.util.ArrayList;

public class Train {
    private int id;
    private Locomotive loc;
    private Wagon wagon;
    private ArrayList<Train> trains;
    private ArrayList<Locomotive> locomotives; 
    private ArrayList<Wagon> wagons; 

    public Train(int id, Locomotive loc){
        this.id = id;
        this.loc = loc;
        this.locomotives = new ArrayList<>(); 
        this.wagons = new ArrayList<>();       
        this.trains = new ArrayList<>();        
    }
    
    
    public int getId() {
        return id;
    }

    public boolean engageLocomotive(Locomotive loc) {
        if (this.wagons.isEmpty()) {
            this.locomotives.add(loc);
            loc.setTrain(this);
            return true;
        } else {
            System.out.println("Cannot add locomotive after a wagon.");
            return false;
        }
    }
    public boolean engageWagon(Wagon wag) {
        this.wagons.add(wag);
        wag.setTrain(this);
        return true;
    }
    
    public Locomotive disengageLocomotive(){
        if(!trains.isEmpty() || trains.get(trains.size()-1).equals(loc)){
            trains.remove(loc);
            return loc;
        }else{
            return null;
        }
    }  
    public Wagon disengageWagon(){
        if(!trains.isEmpty() || trains.get(trains.size()-1).equals(wagon)){
            trains.remove(wagon);
            return wagon;
        }else{
            return null;
        }
    }
    public ArrayList<Locomotive> getLocomotives() {
        return locomotives;
    }
    public ArrayList<Wagon> getWagons() {
        return wagons;
    }
    public boolean full(ArrayList<Train> trains){
        int locOccurrences = 0;
        int wagOccurrences = 0;
        for(int i = 0; i < trains.size(); i++){
            if(trains.get(i).equals(loc)){
                locOccurrences++;
            }else{
                wagOccurrences++;
            }
        }
        if(wagOccurrences < (locOccurrences * loc.getMaxWagons()) * (1 - ((locOccurrences-1) * 0.1))){ //cada locomotive pode levar 10 vagões
            return false;
        }
            return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Train id = " + id + " | ");
        for (Locomotive loc : locomotives) {
            result.append("[Locomotive id = ").append(loc.getId()).append("] | ");
        }
        for (Wagon wag : wagons) {
            result.append("[Wagon id = ").append(wag.getId()).append("] | ");
        }
        return result.toString().trim();
    }  
}
