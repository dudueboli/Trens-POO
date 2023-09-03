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

                    boolean trainFound = false;
                    ArrayList<Train> editTrainList = null;

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
                                
                                Train existingTrain = null;
                                for (ArrayList<Train> trainList : yard.getYard()) {
                                    if (!trainList.isEmpty()) {
                                        existingTrain = trainList.get(0);
                                        break;
                                    }
                                }
                    
                                if (existingTrain != null) {
                                    
                                    existingTrain.engageWagon(wagonToAdd);
                                    garageWag.remove(idW);
                                    System.out.println("Wagon added to the train successfully!");
                                    System.out.println(existingTrain.toString());
                                } else {
                                    System.out.println("No existing train found in the yard.");
                                }
                            } else {
                                System.out.println("Wagon not found in the wagon garage.");
                            }
                            break;
                            case 3:
                                ArrayList<Train> trainListToRemove = null;
                                for (ArrayList<Train> trainList : yard.getYard()) {
                                    for (Train train : trainList) {
                                        if (train.getId() == id) {
                                            trainListToRemove = trainList;
                                            break;
                                        }
                                    }
                                    if (trainListToRemove != null) {
                                        break;
                                    }
                                }
                                if (trainListToRemove != null) {
                                    if (trainListToRemove.size() > 1) {
                                        trainListToRemove.remove(trainListToRemove.size() - 1);
                                        System.out.println("Last carriage removed from the train.");
                                    } else {
                                        System.out.println("A train must have at least one locomotive.");
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
                    id = sc.nextInt();

                    ArrayList<Train> trainToRemove = null;
                    for (ArrayList<Train> trainList : yard.getYard()) {
                        for (Train train : trainList) {
                            if (train.getId() == id) {
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

                        yard.remove(yard.getYard().indexOf(trainToRemove));

                     
                        for (Locomotive locRe : locomotivesToReturn) {
                            garageLoc.park(locRe);
                        }

                        for (Wagon wagonRe : wagonsToReturn) {
                            garageWag.park(wagonRe);
                        }

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