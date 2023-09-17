public class Railcar {
    
    private int id;
    private Train train;

    public Railcar(int id, Train train){
        this.id = id;
        this.train = train;
    }

    public int getId() {
        return id;
    }

    public Train getTrain() {
        return train;
    }
    
    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString(){
        return "id = " + id + " Train = " + train;
    }
}
