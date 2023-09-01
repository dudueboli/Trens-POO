public class Locomotive extends Train {
    
    private int id;
    private int weight;
    private int maxWagons;
    private Train train;
    
    public Locomotive(int id, int weight, int maxWagons) {
        super(id, null);
        this.id = id;
        this.weight = weight;
        this.maxWagons = maxWagons;
        this.train = null;
    }
    public int getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }
    public int getMaxWagons() {
        return maxWagons;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    @Override
    public String toString() {
        return "Locomotive [id=" + id + ", weight=" + weight + ", maxWagons=" + maxWagons + ", train=" + train + "]";
    }
    
    
    


    
}
