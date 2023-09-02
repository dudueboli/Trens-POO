import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Locomotive> loc = new ArrayList<>();
        ArrayList<Wagon> wagon = new ArrayList<>();
        ArrayList<Train> trains = new ArrayList<>();
        for(int i = 0; i <= 50; i++){
                loc.add(new Locomotive(i, 25, 10));   
        }
        for(int i = 0; i <=200; i++){
                wagon.add(new Wagon(i, 25));
        }
        LocomotiveGarage garageLoc = new LocomotiveGarage(loc);
        WagonGarage garageWag = new WagonGarage(wagon);
        Yard yard = new Yard(trains);
        while(true){
            int option = firstMenu();
            if(option == 0) break;
            switch(option){
                case 1: 
                        int id;
                        int idLocomotive;
                        Locomotive locNum;

                        System.out.println("Enter the train id: ");
                        id = sc.nextInt();

                        garageLoc.printLocomotives();

                        System.out.println("Enter the train locomotive id: ");
                        idLocomotive = sc.nextInt();

                        locNum = garageLoc.get(idLocomotive);
                        if(locNum != null){
                            Train train = new Train(id, locNum);
                            trains.add(train);
                            System.out.println("Train created!");
                        }
                                         
                        break;
                case 2: 
                        System.out.println("Enter the train id: ");
                        id = sc.nextInt();
                
                        while(true){
                            int optionTwo = editingMenu();
                            if(optionTwo == 0) break;
                            switch(optionTwo){
                                case 1:
                                        System.out.println("Enter the train id: ");
                                        id = sc.nextInt();

                                        //if(...)
                                        break;
                                case 2:
                                        System.out.println("Enter the train id: ");
                                        id = sc.nextInt();

                                        //if(...)
                                        break;
                                case 3:
                                        //train.deleteLastCarriage;
                                        break;
                                case 4:
                                        //locomotivesGarage.getLocomotives();
                                        break;
                                case 5:
                                        //wagonsGarage.getWagons();
                                        break; 
                                
                            }
                        }
                        break;

                case 3: 
                        System.out.println("Enter the train id: ");
                        id = sc.nextInt();

                        //train.delete(id);
                        break;

                case 4:
                        yard.printTrains();
                        break;
            }
        }

    }
    public static int firstMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Trains Creator");
        System.out.println("===============================");
        System.out.println("(1) Create a train");
        System.out.println("(2) Edit a train");
        System.out.println("(3) Delete a train");
        System.out.println("(4) List of trains in the yard");
        System.out.println("(0) Exit");
        System.out.println("===============================");
        System.out.println("Type the option:");
        int option = sc.nextInt();
        return option;
    }

    public static int editingMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Editing Menu");
        System.out.println("==========================================");
        System.out.println("(1) Insert a new locomotive");
        System.out.println("(2) Insert a new wagon");
        System.out.println("(3) Delete the last carriage of the train");
        System.out.println("(4) List of free locomotives");
        System.out.println("(5) List of free wagons");
        System.out.println("(0) Exit");
        System.out.println("==========================================");
        System.out.println("Type the option:");
        int optionTwo = sc.nextInt();
        return optionTwo;
    }
}
