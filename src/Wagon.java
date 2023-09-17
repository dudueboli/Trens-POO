public class Wagon extends Railcar {
    private int weight;

    public Wagon(int id, int weight) {
        super(id, null);
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Wagon = " + super.toString() + " max weight = " + this.weight;
    }
    
}
