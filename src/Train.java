import java.util.ArrayList;

public class Train {
    private int id;
    private int idLocomotive;
    private int idWagon;
    private Locomotive loc;
    private Wagon wagon;
    private ArrayList<Train> trains;


    public Train(int id, Locomotive loc){
        this.id = id;
        this.loc = loc;
        trains = new ArrayList<Train>();
    }
    
    public int getId() {
        return id;
    }

    public boolean engageLocomotive(Locomotive loc){
        if(trains.isEmpty() || trains.get(trains.size()-1).equals(loc)){
            trains.add(this.loc);
            
            return true;
        }
        return false;
    }
    public boolean engageWagon(Wagon wag){
        if(trains.isEmpty() || !full(trains)){
            trains.add(this.wagon);
            //remove from the garage
            return true;
        }
        return false;
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
    public Locomotive getL(int idLocomotive){
        return loc;
    }
    public Wagon getW(int idWagon){
        return wagon;
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
        return "Train [id=" + id + ", trains=" + trains + "]";
    }
    
}
