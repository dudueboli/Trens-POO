public class Wagon {
    
    private int id;
    private int weight;
    private int ref;
    
    public Wagon(int id, int weight, int ref) {
        this.id = id;
        this.weight = weight;
        this.ref = ref;
    }
    public int getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }
    public int getRef() {
        return ref;
    }
    @Override
    public String toString() {
        return "Wagon [id=" + id + ", weight=" + weight + ", ref=" + ref + "]";
    }
    
}
