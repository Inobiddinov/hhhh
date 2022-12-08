import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Assignment2A_Mukhammadaziz {

    public static void main(String[] args) {

        DisplayAll mainMenu = new DisplayAll();

        mainMenu.displayMenu();

    }

}

class DisplayAll {

    Scanner scan = new Scanner(System.in);

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    LocalDateTime localTime = LocalDateTime.now();

// creating Arrays for display result

    String[] dispatchers = {"John", "Sam", "Will",};

    String[] zones = {"Zone A", "Zone B"};

    int[]
            [] orderArray = new int [3]
            [15];

    int[] totalOrder = {0,0,0,0};

    int[]
            [] allWeightFee = new int [3]
            [15];

    double[] grossWage = new double [4];

    double[] commission = new double [4];

    double[] totalWage = new double [4];

// declaration of instance variables for calculation

    int choice;

    int dispatcherNumber=0, zoneFrom=0, zoneTo=0, weight=0;

    public void displayMenu() {

        do {

//prompt user to choose one option here if the choice is not exist on list it will be loop and ask the user to re input 
            again

            System.out.printf("Welcome to Sunway City Delivery \n%5s %s\n", " ","Main Menu");

            System.out.println("1. Enter a new order");
            System.out.println("2. Modify an order");
            System.out.println("3. View all order");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (1-4)
:");

            choice = scan.nextInt();

            if (choice==1) {

                displayNewOrder();

            }

            else if (choice==2) {

                modifyOrder();

            }

            else if (choice==3) {

                displayAll();

            }

            else if (choice==4) {

            }

            else

                System.out.println("Invalid input");

        }while (choice!=4);

        System.out.println("It was great time with you and see you Soon!
        !");

    }

    public void displayNewOrder () {

        for (int srt = 0; srt< dispatchers.length; srt++) {

            System.out.printf("%d : %s \n", srt+1, dispatchers[srt]
            );

        }

        do {

//prompt user to select a dispatcher from these 3 choices
            System.out.println("Choose a dispatcher(1-3)
:");

            dispatcherNumber = scan.nextInt();

            if (dispatcherNumber<1 |
| dispatcherNumber>3)

            System.out.println("Invalid input Try Again:");

        }while (dispatcherNumber<1 |
|dispatcherNumber>3);
