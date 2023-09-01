import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int option = firstMenu();
            if(option == 0) break;
            switch(option){
                case 1: 
                        int id;
                        int locNum;

                        System.out.println("Enter the train id: ");
                        id = sc.nextInt();

                        System.out.println("The number of locomotives: ");
                        locNum = sc.nextInt();

                        Train train = new Train(id, locNum)
                        
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
                        //yard.getTrains();
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
        int option = sc.nextInt();
        sc.close();
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
        int optionTwo = sc.nextInt();
        sc.close();
        return optionTwo;
    }
}
