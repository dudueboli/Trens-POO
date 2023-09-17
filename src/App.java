import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Train> trainYard = new ArrayList<>();
        RailcarGarage railcarGarage = new RailcarGarage();

        for(int i = 1; i <= 30; i++){
            Locomotive locomotive = new Locomotive(i, null, 30, 10);
            railcarGarage.park(locomotive);
        }
        for(int i = 31; i <= 60; i++){
            Wagon wagon = new Wagon(i, 2);
            railcarGarage.park(wagon);
        }

        while (true) {
            int option = firstMenu();
            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    int trainId = trainYard.size();
                    Train train = createTrain(trainId, railcarGarage, sc);
                    if (train != null) {
                        trainYard.add(train);
                        System.out.println("Train created!");
                    }
                    break;
                case 2:
                    listTrains(trainYard);
                    System.out.println("Enter the train ID you want to edit: ");
                    int editTrainId = sc.nextInt();
                    Train editTrain = findTrain(trainYard, editTrainId);
                    if (editTrain != null) {
                        editTrainMenu(editTrain, railcarGarage, sc);
                    } else {
                        System.out.println("Train not found in the yard.");
                    }
                    break;
                case 3:
                    listTrains(trainYard);
                    System.out.println("Enter the train ID you want to delete: ");
                    int deleteTrainId = sc.nextInt();
                    Train deleteTrain = findTrain(trainYard, deleteTrainId);
                    if (deleteTrain != null) {
                        deleteTrain(trainYard, railcarGarage, deleteTrain);
                        System.out.println("Train deleted.");
                    } else {
                        System.out.println("Train not found in the yard.");
                    }
                    break;
                case 4:
                    listTrains(trainYard);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        sc.close();
    }

    public static int firstMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Trains Creator");
        System.out.println("===============================");
        System.out.println("(1) Create a train");
        System.out.println("(2) Edit a train");
        System.out.println("(3) Delete a train");
        System.out.println("(4) List of trains in the yard");
        System.out.println("(0) Exit");
        System.out.println("===============================");
        System.out.println("Enter your choice: ");
        int option = sc.nextInt();
        return option;
    }

    public static Train createTrain(int id, RailcarGarage railcarGarage, Scanner sc) {
        System.out.println("Creating a new train...");
        Train train = new Train(id);

        System.out.println("Add locomotive to the train (Enter locomotive ID or 0 to skip): ");
        int locId = sc.nextInt();
        while (locId != 0) {
            Railcar railcar = railcarGarage.remove(locId);
            if (railcar != null && railcar instanceof Locomotive) {
                Locomotive locomotive = (Locomotive) railcar;
                if (train.engage(locomotive)) {
                    System.out.println("Locomotive added to the train.");
                } else {
                    System.out.println("Cannot add locomotive to the train.");
                    railcarGarage.park(locomotive); 
                }
            } else {
                System.out.println("Invalid locomotive ID. Please try again.");
            }
            System.out.println("Add another locomotive (Enter locomotive ID or 0 to skip): ");
            locId = sc.nextInt();
        }

        System.out.println("Train created successfully.");
        return train;
    }

    public static void listTrains(ArrayList<Train> trainYard) {
        System.out.println("Trains in the yard:");
        for (Train train : trainYard) {
            System.out.println(train);
        }
    }

    public static Train findTrain(ArrayList<Train> trainYard, int trainId) {
        for (Train train : trainYard) {
            if (train.getId() == trainId) {
                return train;
            }
        }
        return null;
    }

    public static void deleteTrain(ArrayList<Train> trainYard, RailcarGarage railcarGarage, Train train) {
        trainYard.remove(train);
        
    
        ArrayList<Railcar> railcars = train.getRailcars();
    
    
        for (Railcar railcar : railcars) {
            railcarGarage.park(railcar);
        }
    }
    

    public static void editTrainMenu(Train train, RailcarGarage railcarGarage, Scanner sc) {
        while (true) {
            int option = editTrainSubMenu();
            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    listFreeLocomotives(railcarGarage);
                    System.out.println("Enter locomotive ID to add to the train: ");
                    int locId = sc.nextInt();
                    Railcar railcar = railcarGarage.remove(locId);
                    if (railcar != null && railcar instanceof Locomotive) {
                        Locomotive locomotive = (Locomotive) railcar;
                        if (train.engage(locomotive)) {
                            System.out.println("Locomotive added to the train.");
                        } else {
                            System.out.println("Cannot add locomotive to the train.");
                            railcarGarage.park(locomotive); 
                        }
                    } else {
                        System.out.println("Invalid locomotive ID. Please try again.");
                    }
                    break;
                case 2:
                    listFreeWagons(railcarGarage);
                    System.out.println("Enter wagon ID to add to the train: ");
                    int wagonId = sc.nextInt();
                    Railcar railcar2 = railcarGarage.remove(wagonId);
                    if (railcar2 != null && railcar2 instanceof Wagon) {
                        Wagon wagon = (Wagon) railcar2;
                        if (train.engage(wagon)) {
                            System.out.println("Wagon added to the train.");
                        } else {
                            System.out.println("Cannot add wagon to the train.");
                            railcarGarage.park(wagon); 
                        }
                    } else {
                        System.out.println("Invalid wagon ID. Please try again.");
                    }
                    break;
                case 3:
                    train.removeLastRailcar();
                    System.out.println("Last railcar removed from the train.");
                    break;
                case 4:
                    listFreeLocomotives(railcarGarage);
                    break;
                case 5:
                    listFreeWagons(railcarGarage);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static int editTrainSubMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Edit Train Menu");
        System.out.println("===============================");
        System.out.println("(1) Add locomotive to the train");
        System.out.println("(2) Add wagon to the train");
        System.out.println("(3) Remove the last railcar from the train");
        System.out.println("(4) List free locomotives");
        System.out.println("(5) List free wagons");
        System.out.println("(0) Return to main menu");
        System.out.println("===============================");
        System.out.println("Enter your choice: ");
        int option = sc.nextInt();
        return option;
    }

    public static void listFreeLocomotives(RailcarGarage railcarGarage) {
        System.out.println("Free locomotives in the garage:");
        for (int i = 0; i < railcarGarage.numberOfRailcars(); i++) {
            Railcar railcar = railcarGarage.get(i);
            if (railcar instanceof Locomotive) {
                System.out.println(railcar);
            }
        }
    }

    public static void listFreeWagons(RailcarGarage railcarGarage) {
        System.out.println("Free wagons in the garage:");
        for (int i = 0; i < railcarGarage.numberOfRailcars(); i++) {
            Railcar railcar = railcarGarage.get(i);
            if (railcar instanceof Wagon) {
                System.out.println(railcar);
            }
        }
    }
}