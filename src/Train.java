import java.util.ArrayList;

public class Train {
    private int id;
    private Locomotive loc;
    private ArrayList<Locomotive> locomotives; 
    private ArrayList<Wagon> wagons; 

    public Train(int id, Locomotive loc){
        this.id = id;
        this.loc = loc;
        this.locomotives = new ArrayList<>(); 
        this.wagons = new ArrayList<>();         
    }
    
    
    public int getId() {
        return id;
    }

    public boolean engageLocomotive(Locomotive loc) {
        if (this.wagons.isEmpty()) {
            this.locomotives.add(loc);
            loc.setTrain(this);
            return true;
        } else {
            System.out.println("Cannot add locomotive after a wagon.");
            return false;
        }
    }
    public boolean engageWagon(Wagon wag) {
        // Verifica se já há locomotivas engatadas no trem
        if (locomotives.isEmpty()) {
            System.out.println("Cannot add wagon before a locomotive.");
            return false;
        } else {
            // Calcula a capacidade máxima com base no número de locomotivas engatadas
            int maxCapacity = loc.getMaxWagons();
            for (int i = 1; i < locomotives.size(); i++) {
                maxCapacity = (int) (maxCapacity * 0.9); // Reduz em 10% a cada nova locomotiva
            }
            
            // Verifica se a capacidade máxima já foi atingida usando o método full
            if (full(wag)) {
                System.out.println("Cannot add more wagons. Maximum capacity reached.");
                return false;
            } else {
                // Adiciona o vagão ao trem
                this.wagons.add(wag);
                wag.setTrain(this);
                return true;
            }
        }
    }
    
    public Locomotive disengageLocomotive() {
        if (!locomotives.isEmpty()) {
            Locomotive removedLocomotive = locomotives.remove(locomotives.size() - 1);
            removedLocomotive.setTrain(null);
            return removedLocomotive;
        } else {
            return null; 
        }
    }
    public Wagon disengageWagon() {
        if (!wagons.isEmpty()) {
            Wagon removedWagon = wagons.remove(wagons.size() - 1);
            removedWagon.setTrain(null);
            return removedWagon;
        } else {
            return null; 
        }
    }
    public ArrayList<Locomotive> getLocomotives() {
        return locomotives;
    }
    public ArrayList<Wagon> getWagons() {
        return wagons;
    }
    public boolean full(Wagon wag) {
        int locOccurrences = locomotives.size();
        int wagOccurrences = wagons.size();
        int maxCapacity = loc.getMaxWagons();
        
        // Calcula a capacidade máxima com base no número de locomotivas engatadas
        for (int i = 1; i < locOccurrences; i++) {
            maxCapacity = (int) (maxCapacity * 0.9); // Reduz em 10% a cada nova locomotiva
        }
        
        return wagOccurrences >= maxCapacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Train id = " + id + " | ");
        for (Locomotive loc : locomotives) {
            result.append("[Locomotive id = ").append(loc.getId()).append("] | ");
        }
        for (Wagon wag : wagons) {
            result.append("[Wagon id = ").append(wag.getId()).append("] | ");
        }
        return result.toString().trim();
    }  
}
