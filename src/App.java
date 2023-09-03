import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Locomotive> loc = new ArrayList<>();
        ArrayList<Wagon> wagon = new ArrayList<>();
        ArrayList<ArrayList<Train>> trainYard = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            loc.add(new Locomotive(i, 25, 10));
        }
        for (int i = 0; i < 200; i++) {
            wagon.add(new Wagon(i, 25));
        }
        LocomotiveGarage garageLoc = new LocomotiveGarage(loc);
        WagonGarage garageWag = new WagonGarage(wagon);
        Yard yard = new Yard(trainYard);
        while (true) {
            int option = firstMenu();
            if (option == 0) break;
            switch (option) {
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
                    if (locNum != null) {
                        Train train = new Train(id, locNum);
                        train.engageLocomotive(locNum);
                        ArrayList<Train> newTrainList = new ArrayList<>();
                        newTrainList.add(train);
                        yard.park(newTrainList);
                        garageLoc.remove(idLocomotive);
                        System.out.println("Train created!");
                    }

                    break;
                case 2:
                    yard.printTrains();
                    System.out.println("Enter the train id you want to edit: ");
                    id = sc.nextInt();
                
                    ArrayList<Train> editTrainList = null;
                    boolean trainFound = false;

                    for (ArrayList<Train> trainList : yard.getYard()) {
                        for (Train train : trainList) {
                            if (train.getId() == id) {
                                editTrainList = trainList;
                                trainFound = true;
                                break;
                            }
                        }
                        if (trainFound) {
                            break;
                        }
                    }
                
                    if (!trainFound) {
                        System.out.println("Train not found in the yard.");
                        break;
                    }

                    while (true) {
                        int optionTwo = editingMenu();
                        if (optionTwo == 0) break;
                        switch (optionTwo) {
                            case 1:
                                garageLoc.printLocomotives();
                                System.out.println("Enter the locomotive id you want to add: ");
                                int editLocomotiveId = sc.nextInt();
                                Locomotive editLocomotive = garageLoc.get(editLocomotiveId);

                                if (editLocomotive != null) {
                                    boolean addedSuccessfully = editTrainList.get(0).engageLocomotive(editLocomotive);

                                    if (addedSuccessfully) {
                                        garageLoc.remove(editLocomotiveId);
                                        System.out.println("Locomotive added to the train successfully!");
                                    } else {
                                        System.out.println("Cannot add locomotive to the train.");
                                    }
                                } else {
                                    System.out.println("Locomotive not found in the locomotive garage.");
                                }

                                break;
                            case 2:
                                garageWag.printWagons();
                                System.out.println("Enter the train wagon id: ");
                                int idW = sc.nextInt();
                                Wagon wagonToAdd = garageWag.get(idW);
                                if (wagonToAdd != null) {
                                    boolean addedSuccessfully = editTrainList.get(0).engageWagon(wagonToAdd);

                                    if (addedSuccessfully) {
                                        garageWag.remove(idW);
                                        System.out.println("Wagon added to the train successfully!");
                                    } else {
                                        System.out.println("Cannot add wagon to the train.");
                                    }
                                } else {
                                    System.out.println("Wagon not found in the wagon garage.");
                                }
                                break;
                            case 3:
                                ArrayList<Train> trainToModify = null;
                                for (ArrayList<Train> trainList : yard.getYard()) {
                                    for (Train train : trainList) {
                                        if (train.getId() == id) {
                                            trainToModify = trainList;
                                            break;
                                        }
                                    }
                                    if (trainToModify != null) {
                                        break;
                                    }
                                }

                                if (trainToModify != null) {
                                    if (!trainToModify.get(0).getWagons().isEmpty()) {
                                        Wagon removedWagon = trainToModify.get(0).disengageWagon();
                                        garageWag.park(removedWagon);
                                        System.out.println("Last wagon removed from the train and returned to the wagon garage.");
                                    } else if (trainToModify.get(0).getLocomotives().size() > 1) {
                                        Locomotive removedLocomotive = trainToModify.get(0).disengageLocomotive();
                                        garageLoc.park(removedLocomotive);
                                        System.out.println("Last locomotive removed from the train and returned to the locomotive garage.");
                                    } else {
                                        System.out.println("The first locomotive cannot be removed. To do that you have to delete the whole train.");
                                    }
                                } else {
                                    System.out.println("Train not found in the yard.");
                                }
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
                    yard.printTrains();
                    System.out.println("Enter the train id you want to delete: ");
                    int idToDelete = sc.nextInt();
                
                    ArrayList<Train> trainToRemove = null;
                
                    for (ArrayList<Train> trainList : yard.getYard()) {
                        for (Train train : trainList) {
                            if (train.getId() == idToDelete) {
                                trainToRemove = trainList;
                                break;
                            }
                        }
                        if (trainToRemove != null) {
                            break;
                        }
                    }
                
                    if (trainToRemove != null) {
                        ArrayList<Locomotive> locomotivesToReturn = new ArrayList<>(trainToRemove.get(0).getLocomotives());
                        ArrayList<Wagon> wagonsToReturn = new ArrayList<>(trainToRemove.get(0).getWagons());
                
                        for (int i = locomotivesToReturn.size() - 1; i >= 0; i--) {
                            garageLoc.park(locomotivesToReturn.get(i));
                        }
            
                        for (int i = wagonsToReturn.size() - 1; i >= 0; i--) {
                            garageWag.park(wagonsToReturn.get(i));
                        }
                
                        yard.remove(yard.getYard().indexOf(trainToRemove));
                
                        System.out.println("Train deleted, locomotives and wagons returned to their garages.");
                    } else {
                        System.out.println("Train not found in the yard.");
                    }
                    break;

                case 4:
                    yard.printTrains();
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
        System.out.println("Type the option:");
        int option = sc.nextInt();
        return option;
    }

    public static int editingMenu() {
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