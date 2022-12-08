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
            int[][] orderArray = new int [3][15];
            int[] totalOrder = {0,0,0,0};
            int[][] allWeightFee = new int [3][15];
            double[] grossWage = new double [4];
            double[] commission = new double [4];
            double[] totalWage = new double [4];

            // declaration of instance variables for calculation
            int choice;
            int dispatcherNumber=0, zoneFrom=0, zoneTo=0, weight=0;
            public void displayMenu() {
                do {
                    //prompt user to choose one option here if the choice is not exist on list it will be loop and ask the user to re input again
                    System.out.printf("Welcome to Sunway City Delivery \n%5s %s\n", " ","Main Menu");
                    System.out.println("1. Enter a new order");
                    System.out.println("2. Modify an order");
                    System.out.println("3. View all order");
                    System.out.println("4. Exit");
                    System.out.println("Enter your choice (1-4):");

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
                System.out.println("It was great time with you and see you Soon!!");
            }


            public void displayNewOrder () {



                for (int srt = 0; srt< dispatchers.length; srt++) {
                    System.out.printf("%d : %s \n", srt+1, dispatchers[srt]);
                }

                do {
                    //prompt user to select a dispatcher from these 3 choices
                    System.out.println("Choose a dispatcher(1-3):");
                    dispatcherNumber = scan.nextInt();

                    if (dispatcherNumber<1 || dispatcherNumber>3)
                        System.out.println("Invalid input Try Again:");
                }while (dispatcherNumber<1 ||dispatcherNumber>3);


                do {
                    //User should prompt the delivery direction where it should be taken.
                    System.out.println("Choose location for the dispatcher to drive from:(1-Zone A, 2-Zone B)");
                    zoneFrom= scan.nextInt();
                    if (zoneFrom !=1 && zoneFrom!=2)
                        System.out.println("Invalid input");
                } while (zoneFrom !=1 && zoneFrom!=2);

                do {
                    //User should prompt the delivery direction where it should be delivered.
                    System.out.println("Choose location for the dispatcher to drive to:(1-Zone A, 2-Zone B");
                    zoneTo= scan.nextInt();
                    if (zoneTo !=1 && zoneTo!=2)
                        System.out.println("Invalid input");
                } while (zoneTo !=1 && zoneTo!=2);

                do {
                    //Prompt user to enter the weight of the package must be at least 100 in order to proceed
                    System.out.println("Enter package weight(>100g):");
                    weight = scan.nextInt();
                    if (weight <100)
                        //If user prompt invalid value it will loop and ask the user input valid value
                        System.out.println("Invalid weight. Please try Again:");
                }while (weight<100);

                System.out.print(dispatcherNumber);
                dispatcherNumber--;


                //calculation of Dispatcher number
                if (dispatcherNumber<10)
                    System.out.print("0"+ totalOrder[dispatcherNumber]);
                else
                    System.out.print(totalOrder[dispatcherNumber]);
                System.out.print("" + zoneFrom + zoneTo);
                //Display Order no, Dispatcher name, from zone , to zone, and charge
                allWeightFee[dispatcherNumber][totalOrder[dispatcherNumber]]= calculateCharge(zoneFrom, zoneTo, weight);
                System.out.printf(" %s %s %s %d\n", dispatchers[dispatcherNumber], zones[--zoneFrom], zones[--zoneTo], allWeightFee[dispatcherNumber][totalOrder[dispatcherNumber]]);

                System.out.println("\n");
                totalOrder[dispatcherNumber]++;
            }


            public void modifyOrder() {

                //Declaring variables for modifyOrder class
                boolean Validation=false;
                int modifyOrder=0;
                int editOrder=0;
                int modifyName=0;
                int modifyZoneFrom=0, modifyZoneTo=0;
                int newCharge=0, oldCharge=0;
                int weight=0;
                int zoneFrom=0, zoneTo=0;
                int dispatcherNumber=0;

                do {
                    do {
                        Validation= true;
                        //prompt user to input valid order number for modify
                        System.out.println("Enter an order number(5 digits):");
                        modifyOrder = scan.nextInt();
                        //if order number is more than max limit and less than min limit it will loop again and will ask the user to input valid value
                        if (modifyOrder<10111 || modifyOrder>31522) {
                            System.out.println("Invalid Order Number"); Validation=false;}
                    }while (!Validation);

                    //declaring Modification variables
                    modifyZoneTo= modifyOrder%10;
                    modifyZoneFrom = (modifyOrder/10)%10;
                    editOrder = ((modifyOrder/10)/10)%100;
                    modifyName = (((((modifyOrder/10)/10)/10)/10)%10);
                    System.out.println("" + modifyName + editOrder + modifyZoneFrom + modifyZoneTo);
                    //checking if dispatcher number is valid or not
                    if (modifyName>3 || modifyName<1) {
                        System.out.println("Invalid dispatcher No."); Validation=false;
                    }

                    //checking if index number is valid or not
                    if (editOrder>totalOrder[(modifyName-1)] ||editOrder<=0) {
                        System.out.println("Invalid OrderNo");
                        Validation=false;
                    }
                    //checking if zone from is valid or not
                    if (modifyZoneFrom !=1 && modifyZoneFrom!=2) {
                        System.out.println("Invalid From Zone");
                        Validation=false;
                    }
                    //checking if zone to is valid or not
                    if (modifyZoneTo!=1 && modifyZoneTo!=2){
                        System.out.println("Invalid To Zone");
                        Validation=false;
                    }
                }while (!Validation);

                do {
                    //prompt user to input new weight which will be changed and replaced
                    System.out.println("Enter new weight(>100g):");
                    weight = scan.nextInt();
                    if (weight<100) System.out.println("Invalid weight");
                }while (weight<100);
                //declaring modified values to valid variables
                zoneFrom=modifyZoneFrom;zoneTo=modifyZoneTo;
                dispatcherNumber = modifyName-1;
                --editOrder;


                newCharge = calculateCharge(zoneFrom, zoneTo, weight);


                oldCharge = allWeightFee[dispatcherNumber][editOrder];

                System.out.println(newCharge);
                if (oldCharge>newCharge)
                    //calculating sum of  refund RM which will be give back to user
                    System.out.println("Refunded Amount: RM" + (oldCharge-newCharge));
                else
                    //calculating sum of  top up RM amount which will be top up by user to proceed
                    System.out.println("Top-up amount: RM" + (newCharge-oldCharge));
                allWeightFee[dispatcherNumber][editOrder]= newCharge;
                System.out.println();
                System.out.println();
            }



            //display all final results
            public void displayAll() {

                //Displaying each number using loops
                for(int count=0; count<grossWage.length; count++) {
                    grossWage[count]= totalOrder[count]*3;
                    if (totalOrder[count]>=10)
                        commission[count]= 0.05*grossWage[count];

                    totalWage[count]=grossWage[count]+commission[count];
                }
                System.out.println();
                //Final Output as a result of whole process done by user
                System.out.println("Sunway City Delivery Company daily report for "+dateFormat.format(localTime));
                display("\nDispatcher", dispatchers);

                //Displaying each order number using loops
                for (int cntt=0; cntt<15; cntt++) {
                    System.out.printf("%-20s",  "Order"+ (cntt+1));
                    for (int number=0; number<allWeightFee.length; number++) {
                        System.out.printf("%8d ",allWeightFee[number][cntt]);
                    }
                    System.out.println();
                }
                System.out.println();
                //calculating sum of the all orders made by user and output it on the last row
                totalOrder[3] = totalOrder[0]+totalOrder[1]+totalOrder[2];
                grossWage[3]= grossWage[0] + grossWage[1]+grossWage[2];
                commission[3]= commission[0] + commission[1]+ commission[2];
                totalWage[3]= totalWage[0]+ totalWage[1]+totalWage[2];


                //Final output of orders
                display(" Total Orders",totalOrder);
                System.out.println();
                display(" Gross Wages",grossWage);
                System.out.println();
                display(" Commission", commission);
                System.out.println();
                display(" Total wages", totalWage);
                System.out.println();
            }
            //declaring class for calculating zonefrom, zoneto,weight of the order
            public int calculateCharge(int zoneFrom, int zoneTo, int weight) {

                //declaring variables for calculation
                int deliveryFeeOfOrder=0;
                int extraFeeOfOrder=0;
                int totalFeeOfOrder=0;
                if (zoneFrom == zoneTo)
                    deliveryFeeOfOrder=6;
                else
                    deliveryFeeOfOrder=7;

                if ((weight-100)%100==0)
                    extraFeeOfOrder= (weight-100)/100;
                else
                    extraFeeOfOrder= (((weight-100)/100)+1);

                totalFeeOfOrder =deliveryFeeOfOrder+extraFeeOfOrder;
                return totalFeeOfOrder;
            }

            public void display (String displayMessage, String nameDisplay[]) {
                System.out.printf("%-20s ", displayMessage);
                for (int cnt = 0; cnt< orderArray.length; cnt++) {
                    System.out.printf("%8s ", nameDisplay[cnt]);
                }
                System.out.println();
            }

            //displaying Order number using loops
            public void display (String displayMessage, int displayOrder[]) {
                System.out.printf("%-20s", displayMessage);
                for (int cnt=0; cnt<displayOrder.length; cnt++) {
                    System.out.printf("%8d ", displayOrder[cnt]);
                }
                System.out.println();
            }
            //displaying  Amount on the arrays using loops
            public void display (String displayCtr, double displayAmount[]) {
                System.out.printf("%-20s", displayCtr);
                for (int cnt=0; cnt<displayAmount.length; cnt++) {
                    System.out.printf("%8.2f ", displayAmount[cnt]);
                }
                System.out.println();
            }

        }