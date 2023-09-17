public class Locomotive extends Railcar {
    
    private int weight;
    private int maxWagons;
  
    
    public Locomotive(int id, Train train, int weight, int maxWagons) {
        super(id, null);
        this.weight = weight;
        this.maxWagons = maxWagons;
    }
    public int getWeight() {
        return weight;
    }
    public int getMaxWagons() {
        return maxWagons;
    }
    @Override
    public String toString() {
        return "Locomotive = " + super.toString() + " max weight = " + this.weight + " max wagons = " + this.maxWagons;
    } 
}
