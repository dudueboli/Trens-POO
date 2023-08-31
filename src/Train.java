import java.util.ArrayList;

public class Train {
    private int id;
    private Locomotive loc;
    private Wagon wagon;
    private int locNum;
    private ArrayList<Train> trains;


    public Train(int id, Locomotive loc){
        this.id = id;
        this.loc = loc;
        trains = new ArrayList<Train>();
    }
    public boolean engageLocomotive(Locomotive loc){
        if(trains.isEmpty() || trains.get(trains.size()-1).equals(loc)){
            trains.add(this.loc);
            return true;
        }
        return false;
    }
    public boolean engageWagon(Wagon wag){
        if(!trains.isEmpty() || !full(trains)){
            trains.add(this.loc);
            return true;
        }
        return false;
    }
    public Locomotive disengageLocomotive(){

        return null;
    }
    public Wagon disengageWagon(){

        return null;
    }
    public int numLocomotives(){

    }
    public int numWagons(){

    }
    public Locomotive get(int idLocomotive){


    }
    public Wagon get(int idWagon){

    }
    public boolean full(ArrayList<Train> trains){
        int locOcorrences = 0;
        int wagOcorrences = 0;
        for(int i = 0; i < trains.size(); i++){
            if(trains.get(i).equals(loc)){
                locOcorrences++;
            }else{
                wagOcorrences++;
            }
        }
        if(wagOcorrences < (locOcorrences * loc.getMaxWagons()) * (1 - ((locOcorrences-1) * 0.1))){ //cada locomotive pode levar 10 vagões
            return false;
        }
            return true;
    }
    
}
