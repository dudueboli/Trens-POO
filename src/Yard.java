import java.util.ArrayList;

public class Yard {

    private ArrayList<Train> yard;
    
    public Yard (ArrayList<Train> yard){
        this.yard = new ArrayList<>(yard);
    }
    public void park (Train train){
        yard.add(train);
    }
    public Train remove(int id){
        for(int i = 0; i<yard.size(); i++){
            Train train = yard.get(i);
            if(train.getId() == id){
                yard.remove(i);
                return train;
            }
        }
        return null;
    }
    public int numberOfTrain(){
        return yard.size();
    }
    public Train get(int id){
        for(Train train : yard){
            if(train.getId() == id){
                return train;
            }
        }
        return null;
    }
    public void printTrains(){
        for(Train train : yard){
            System.out.println(train);
        }
    }
}
