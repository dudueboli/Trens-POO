import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Locomotive> loc = new ArrayList<>();
        ArrayList<Wagon> wagon = new ArrayList<>();
        ArrayList<ArrayList<Train>> trainYard = new ArrayList<>();
        for(int i = 0; i <= 50; i++){
                loc.add(new Locomotive(i, 25, 10));   
        }
        for(int i = 0; i <=200; i++){
                wagon.add(new Wagon(i, 25));
        }
        LocomotiveGarage garageLoc = new LocomotiveGarage(loc);
        WagonGarage garageWag = new WagonGarage(wagon);
        Yard yard = new Yard(trainYard);
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
                            ArrayList<Train> newTrainList = new ArrayList<>();
                            newTrainList.add(train);
                            train.engageLocomotive(locNum.getL(idLocomotive));
                            yard.park(newTrainList);
                            garageLoc.remove(idLocomotive);
                            System.out.println("Train created!");
                        }
                                         
                        break;
                case 2: 
                        System.out.println("Enter the train id you want do edit: ");
                        id = sc.nextInt();
                
                        while(true){
                            int optionTwo = editingMenu();
                            if(optionTwo == 0) break;
                            switch(optionTwo){
                                case 1:
                                ArrayList<Train> editTrainList = null;
                                for (ArrayList<Train> trainList : yard.getYard()) {
                                    for (Train train : trainList) {
                                        if (train.getId() == id) {
                                            editTrainList = trainList;
                                            break;
                                        }
                                    }
                                    if (editTrainList != null) {
                                        break; 
                                    }
                                }
                                if (editTrainList != null) {
                                    System.out.println("Enter the locomotive id you want to add: ");
                                    int editLocomotiveId = sc.nextInt();
                                    Locomotive editLocomotive = garageLoc.get(editLocomotiveId);
                                    if (editLocomotive != null) {
                                        editTrainList.get(0).engageLocomotive(editLocomotive);
                                        garageLoc.remove(editLocomotiveId);
                                        System.out.println("Locomotive added to the train successfully!");
                                    } else {
                                        System.out.println("Locomotive not found in the locomotive garage.");
                                    }
                                } else {
                                    System.out.println("Train not found in the yard.");
                                }
                                break;
                            
                                case 2:
                                        garageWag.printWagons();
                                        System.out.println("Enter the train wagon id: ");
                                        int idW = sc.nextInt();

                                        //if(...)
                                        break;
                                case 3:
                
                                        break;
                                case 4:
                                        garageLoc.printLocomotives();
                                        break;
                                case 5:
                                        garageWag.printWagons();
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
