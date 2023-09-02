public class Wagon extends Train {
    
    private int id;
    private int weight;
    private Train train;
    
    public Wagon(int id, int weight) {
        super(id, null);
        this.id = id;
        this.weight = weight;
        this.train = null;
    }
    public int getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    @Override
    public String toString() {
        return "Wagon [id=" + id + ", weight=" + weight + ", train=" + train + "]";
    }
    
}
