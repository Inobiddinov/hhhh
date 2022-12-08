import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Assignment2B_Mukhammadaziz {
    public static void main(String[] args) {
        DisplayAll display = new DisplayAll();
        display.mainMenu();
    }
}
class DisplayAll {
    //declaring Scan and Local date and time
    Scanner scan = new Scanner(System.in);
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime localTime = LocalDateTime.now();
    //Declaring Arrays
    String[] nameOfTherapists = {"Leyla", "Jasmin", "Sofia"};
    String modifyOrder = null;
    int row = 3;
    int column = 15;
    int[][] orderArray = new int[row][column];

    int[] totalOrder = new int [4];
    double[] grossWage = new double[4];
    double[] commission = new double[4];
    double[] totalWage = new double[4];
    double[] sum   = new double[4];

    //declaring integers
    int finalPrice = 0;
    int validation =0;
    final int SHOULDER__MASSAGE = 60, WHOLE_BODY_MASSAGE = 100;
    int namesNo = 0, massage_Package = 0, totalMinute = 0;
    int therapistOne =0 , therapistTwo =0  , TherapistThree = 0;
    int indexFirstDigit =0;

    //declaring Strings
    String indexOfTherapist =null, orderIndex =null, massageIndex =null;
    String finalIndex =null;
    //Boolean declaration
    boolean valid = false;

    public void mainMenu() {
        int choice = 0;
        //prompt user to choose one option here if the choice is not exist on list it will be loop and ask the user to re input again
        do {
            System.out.printf("Welcome to Sunway Clio Massage service \n%5s %s\n", " ", "Main Menu");
            System.out.println("1. Enter a new order");
            System.out.println("2. Modify an order");
            System.out.println("3. View all order");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (1-4):");
            choice = scan.nextInt();

            //Declaring Which option user want to use and initialize it with the method
            if (choice == 1) {
                newOrder();
            } else if (choice == 2) {
                modifyOrder();
            } else if (choice == 3) {
                finalDisplayOrder();
            } else if (choice == 4) {
                System.out.println();
            } else
                System.out.println("Invalid choice. Try it again!");
            System.out.println();
        } while (choice != 4);
        System.out.println("It was great time with you and see you Soon!!");
    }

    //New Order Method
    public void newOrder () {

        //display therapist names
        for (int srt = 0; srt < nameOfTherapists.length; srt++) {
            System.out.printf("%d : %s \n", srt + 1, nameOfTherapists[srt]);
        }

        do {
            //prompt user to select a dispatcher from these 3 choices
            System.out.println("Choose a Therapist[1-3]:");
            namesNo = scan.nextInt();

            //checks if the user input valid option otherwise it will ask user to re input it again.
            if (namesNo > 3 || namesNo < 1)
                System.out.println("\nInvalid therapist choice. Try Again:");
        } while (namesNo > 3 || namesNo < 1);
        checkArray(namesNo);

        //Prompt user to input which type of massage user want to have
        do {
            System.out.println("Select a massage option:\n1: Shoulder Massage \n2: Whole Body Massage");
            massage_Package = scan.nextInt();
            if (massage_Package != 2 && massage_Package != 1) {
                System.out.println("Invalid Option. Please Try it again!");
                System.out.println();
            }
        } while (massage_Package != 2 && massage_Package != 1);

        //Prompt user to input how many minutes want to have massage
        do {
            System.out.println("How many total minutes you want to book:");
            totalMinute = scan.nextInt();
            if (totalMinute < 30) {
                System.out.println("Please Input more than 30 minutes:");
                System.out.println();
            }
         }   while (totalMinute < 30);

        // Assigning the value into method by declaring the therapist choice and massage type and display
        if (namesNo == 1) {
            validation = therapistOne;
            displayOrder(validation);
            therapistOne++;
        }
        else if(namesNo == 2) {
            validation = therapistTwo;
            displayOrder(validation);
            therapistTwo++;

        }else {
            displayOrder(validation);
            TherapistThree++;
        }
    }

    //Declaring the display for index therapist name massage type and total sum of the service
    public void displayOrder(int displayChoices){

        orderArray[namesNo-1][displayChoices] = calculation(totalMinute, massage_Package);
        System.out.print("Index: "+createIndex(namesNo, massage_Package,displayChoices));
        System.out.print(" /Therapist: " + nameOfTherapists[namesNo-1]);
        System.out.print(" /Massage: " +massagePackageDisplay(massage_Package));
        System.out.print(" /Total: RM" + finalPrice);
        System.out.println();
    }
    //Massage Package
    public String massagePackageDisplay(int massage_choice) {
        if (massage_choice == 1) {
            return "Shoulder Massage" ;
        }else {
            return "Body Massage";
        }
    }
    //Index Creating by declaring every single digit
    public  String createIndex(int therapist , int massage_package, int orderNumber) {

        indexFirstDigit = (therapist - 1);
        indexOfTherapist =String.valueOf(indexFirstDigit);
        orderIndex =String.format("%02d", orderNumber);
        massageIndex =String.valueOf(massage_package);
        finalIndex = (indexOfTherapist + orderIndex + massageIndex);
        return finalIndex;
    }

    //Modifying Order Method
    public void modifyOrder() {
        //Declaring variables which will be used for modify purpose
        int refund =0;
        int modifyTopUp =0 ;
        int modifyTherapist = 0, modifySecondDigit = 0, modifyThirdDigit = 0, modifyMassagePackage = 0;
        boolean modifyBoolean = true;
        int modifySum =0;
        int newTime =0;

        do {
            //prompt user to enter order number
            System.out.println("Enter order number (4-digit)");
            scan.nextLine();
            modifyOrder =scan.nextLine();

            //Taking input String value and turn it into single integer
            modifyTherapist= Integer.parseInt(String.valueOf(modifyOrder.charAt(0)));
            modifySecondDigit = Integer.parseInt(String.valueOf(modifyOrder.charAt(1)));
            modifyThirdDigit = Integer.parseInt(String.valueOf(modifyOrder.charAt(2)));
            modifyMassagePackage= Integer.parseInt(String.valueOf(modifyOrder.charAt(3)));

            //check if order number exist
            if (modifySecondDigit == 1) {
                if(orderArray[modifyTherapist][10+modifyThirdDigit] > 0 ) {
                    modifyBoolean = false ;
                }
            }else if(modifySecondDigit == 0){
                if(orderArray[modifyTherapist][modifyThirdDigit] > 0 ) {
                    modifyBoolean = false ;
                }else {
                    System.out.println("Invalid order number Try it again");
                }
            }
        }while(modifyBoolean == true);

        //display order information
        System.out.println("Your order number : " + modifyOrder);
        System.out.println("Your therapist name : " + nameOfTherapists[modifyTherapist]);
        System.out.println("Your Massage package : " + massagePackageDisplay(modifyMassagePackage));
        if (modifySecondDigit == 1) {
            System.out.println("Your cost : RM" + orderArray[modifyTherapist][10+modifyThirdDigit]);
        }else {
            System.out.println("Your cost : RM" + orderArray[modifyTherapist][modifyThirdDigit]);
        }

        //prompt user to enter new time
        System.out.println("Enter new time: ");
        newTime = scan.nextInt();

        //method to calculate new charge
        modifySum= calculation(newTime,modifyMassagePackage);

        // refund or top up from charge by calculating new time
        if(modifySecondDigit==0) {
            if (modifySum< orderArray[modifyTherapist][modifyThirdDigit] ) {
                refund = orderArray[modifyTherapist][modifyThirdDigit] - modifySum;
                System.out.println("Refund amount : Rm " + refund);
            }else {
                modifyTopUp = modifySum - orderArray[modifyTherapist][modifyThirdDigit];
                System.out.println("Top up amount : Rm " + modifyTopUp);
            }
            orderArray[modifyTherapist][modifyThirdDigit] = modifySum;
        }
        else {
            if (modifySum < orderArray[modifyTherapist][10+modifyThirdDigit] ) {
                refund = orderArray[modifyTherapist][10+modifyThirdDigit] - modifySum;
                System.out.println("Refund amount : Rm " + refund);
            }else {
                modifyTopUp = modifySum - orderArray[modifyTherapist][10+modifyThirdDigit];
                System.out.println("Top up amount : Rm " + modifyTopUp);
            }
            orderArray[modifyTherapist][10+modifyThirdDigit] = modifySum;
        }}

    //Checking the array if array is empty or not
    public void checkArray(int namesNo) {
        for (int row=namesNo-1; row < namesNo ; row++) {
            for (int col=0; col < column ; col++) {

                if (orderArray[row][col] == 0 ) {
                    valid = true ;
                }else {
                    valid = false;
                }
            }
        }
    }

    public int calculation(int minuteness, int packages) {
        //declaring variables for calculation
        int extraFeeForAdd10Minute = 0;
        int packagePrice = 0;

        //Calculation for massage type
        if (packages == 1) {
            packagePrice = SHOULDER__MASSAGE;

        } else {
            packagePrice = WHOLE_BODY_MASSAGE;
        }
        if (minuteness >= 30) {
            extraFeeForAdd10Minute = (minuteness - 30);
            extraFeeForAdd10Minute = (int) Math.round(extraFeeForAdd10Minute / 10.0) * 10;
        }
        finalPrice = (packagePrice + extraFeeForAdd10Minute);
        return finalPrice;
    }
    //Final Display order Method which will execute the final row and column of arrays
    public void finalDisplayOrder(){

        //Declaring variables
        int totalOrders1=0;
        int totalOrders2=0;
        int totalOrders3=0;
        int totalOrders4=0;
        int[] orderRecord = new int [4];

        int totall=0;
        int cnts = 0;

        //print information of orders
        System.out.println();
        System.out.println("Sunway Clio Hotel Massage service daily report for " + dateFormat.format(localTime));//date month year + Local time
        System.out.print("therapist " + ""); //print Therapist name
        for (int i=0 ; i<nameOfTherapists.length ;i++) {
            System.out.print("       " + nameOfTherapists[i] );
        }

        //4th row for calculating sum of the line
        System.out.println("     total");
        System.out.println();
        // output total array
        for (int cnt=0; cnt<orderArray[0].length; cnt++) {
            System.out.printf("%-10s",  "Order "+ (cnt+1));
            for (int row=0; row<orderArray.length; row++) {
                System.out.printf("\t\t%3d ",orderArray[row][cnt]);
                totall+=orderArray[row][cnt];
            }

            System.out.print("          "+totall);
            totall=0;
            System.out.println();
        }

        //calculate Total-Wage and Commission and Gross-wage
        for(int j=0 ; j<orderArray.length ;j++) {

            for(int i=0 ; i<orderArray[0].length ; i++) {
                sum[j] += orderArray[j][i];
                grossWage[j] = sum[j];

                if (orderRecord[j] >10) {
                    commission[j] = (grossWage[j]/100)*40;
                }
                else {
                    commission[j] = (grossWage[j]/100)*30;
                }

                totalWage[j]=grossWage[j]+commission[j];
            }
        }

        // Calculating sum of the gross-wage commision and total-wage and output last array
        grossWage[3]=grossWage[0]+grossWage[1]+grossWage[2];
        commission[3]=commission[0]+commission[1]+commission[2];
        totalWage[3]=totalWage[0]+totalWage[1]+totalWage[2];

        //calculate total orders for different therapist
        for (int rows=0; rows<orderArray.length; rows++) {
            for (int col=0; col<orderArray[0].length; col++) {
                if (orderArray[rows][col] != 0) {
                    ++cnts;
                    if(rows == 0) {
                        totalOrders1 = cnts;

                    }else if(rows == 1) {
                        totalOrders2 = cnts-totalOrders1;
                    }else {
                        totalOrders3 = cnts-totalOrders2-totalOrders1;
                    }
                }
            }
        }
        totalOrders4= (totalOrders1+totalOrders2+totalOrders3);
        System.out.println();

        //print gross-wage, commission , total-wage  and Total-orders
       System.out.printf("Total Order%8.2s    %8.2s    %8.2s    %8.2s \n",totalOrders1,totalOrders2,totalOrders3,totalOrders4);
        System.out.print("Gross Wages");
        for (int i=0; i<grossWage.length; i++) {
            System.out.printf("%8.2f", grossWage[i]);
            System.out.print("    ");
        }
        System.out.println();
        System.out.print("Commission");
        for (int i=0; i<commission.length; i++) {
            System.out.printf("%9.2f", commission[i]);
            System.out.print("   ");
        }
        System.out.println();
        System.out.print("Total Wages");
        for (int i=0; i<totalWage.length; i++) {
            System.out.printf("%8.2f", totalWage[i]);
            System.out.print("    ");
        }
        System.out.println();
    }
    }


