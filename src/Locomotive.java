public class Locomotive extends Train {
    
    private int id;
    private int weight;
    private final int maxWagons;
    private int ref;
    
    public Locomotive(int id, int weight, int maxWagons, int ref) {
        super(id, loc);
        this.id = id;
        this.weight = weight;
        this.maxWagons = maxWagons;
        this.ref = ref;
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
    public int getRef() {
        return ref;
    }
    @Override
    public String toString() {
        return "Locomotive [id=" + id + ", weight=" + weight + ", maxWagons=" + maxWagons + ", ref=" + ref + "]";
    }
    


    
}
