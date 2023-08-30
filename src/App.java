import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int option = firstMenu();
            if(option == 0) break;
            switch(option){
                case 1: 
                        String id;
                        int locNum;

                        System.out.println("Enter the train id: ");
                        id = sc.nextLine();

                        System.out.println("The number of locomotives: ");
                        locNum = sc.nextInt();
            }
        }

    }
    public static int firstMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Trains Creator");
        System.out.println("==============");
        System.out.println("(1) Create a train");
        System.out.println("(2) Edit a train");
        System.out.println("(3) Delete a train");
        System.out.println("(4) List of trains");
        System.out.println("(0) Exit");
        System.out.println("==============");
        int option = sc.nextInt();
        sc.close();
        return option;
    }

    public static int editingMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Editing Menu");
        System.out.println("==============");
        System.out.println("(1) Insert a new locomotive");
        System.out.println("(2) Insert a new wagon");
        System.out.println("(3) Delete the last carriage of the train");
        System.out.println("(4) List of free locomotives");
        System.out.println("(5) List of free wagons");
        System.out.println("(0) Exit");
        System.out.println("==============");
        int option = sc.nextInt();
        sc.close();
        return option;
    }
}
