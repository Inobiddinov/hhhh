import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

    public class Assignment2A_Mukhammadaziz{
        public static void main(String[]args)

         {
             DisplayAll menu = new DisplayAll();
                menu.mainMenu();
         }
            }


            class DisplayAll {

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime localTime = LocalDateTime.now();


    // creating Arrays for display result
    int[] orderNumber = { 0, 0, 0, 0, 0 };
    int[][] OrderArray = new int[3][15];
    int [][]prices = { { 6 }, { 7 } };
    static String[] dispatchers = { "Chris", "John", "Wick" };
    String[] locations = { "Zone A", "Zone B" };
    int [] finalArrayList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

    // declaration of instance variables for calculation
    int newWeight = 0, additionalFee = 0, totalAmount = 0, dispatcherName = 0, fromZone = 0, toZone = 0;
    double orderWeight = 0;

    Scanner scan = new Scanner(System.in);

    //Menu which will loop again after one order
    void mainMenu()
    {
        int selection = 0;
        do
        {
            do
            {
                System.out.println();
                System.out.print("Welcome to Sunway City Delivery\nMain Menu\n1. Add order\n2. Modify Order\n3. View orders\n4. Exit\nChoose the number (1-4):  ");
                selection = scan.nextInt();
                //prompt user to choose one option here if the choice is not exist on list it will be loop and ask the user to re input again
                if (selection == 1)
                    addOrder();
                else if (selection == 2)
                    modifyOrder();
                else if (selection == 3)
                    viewOrder();
                else if (selection == 4)
                    exitOrder();
                else
                    System.out.println("Invalid option. Please Try it again!");
            } while (selection < 1 || selection > 4);
        } while (selection != 4);
    }

    void addOrder()
    {
        //prompt user to select a dispatcher from these 3 choices
        do {
            System.out.println("1. Chris\n2. John\n3. Wick\nChoose a dispatcher (1-3): ");
            dispatcherName = scan.nextInt();
        } while (dispatcherName < 1 || dispatcherName > 4);

        //Max limit delivery per day per dispatcher is 15, and it will automatically stop if user reach the max limit
        do
        {
            if(orderNumber[dispatcherName - 1] == 15)
            {
                System.out.println(dispatchers[dispatcherName - 1] + "has reached the maximum limit for the day. Select a different dispatcher: ");
                dispatcherName = scan.nextInt();
            }
        } while (orderNumber[dispatcherName - 1] == 15);

        //User should prompt the delivery direction where it should be taken.
        do {
            System.out.println("1. Zone A\n2. Zone B\nChoose location for the dispatcher to drive from: ");
            fromZone = scan.nextInt();
        } while (fromZone < 1 || fromZone > 2);

        //User should prompt the delivery direction where it should be delivered.
        do {
            System.out.println("1. Zone A\n2. Zone B\nChoose location for the dispatcher to drive to: ");
            toZone = scan.nextInt();
        } while (toZone < 1 || toZone > 2);


        //Prompt user to enter the weight of the package
        do {
            System.out.println("Enter the package weight: ");
            orderWeight = scan.nextInt();

            if (orderWeight < 100)
                System.out.println("Minimum package weight is 100g. Re-enter weight: ");
        } while (orderWeight < 100);

        orderWeight = orderWeight / 100;

        // Roundup weight
        orderWeight = Math.ceil(orderWeight);

        // Roundup weight to the nearest integer
        newWeight = (int) Math.round(orderWeight);
        System.out.println();

        if (newWeight == 1)
            additionalFee = 0;
        else
            additionalFee = newWeight - 1;

        // Calculation of the total area after adding the cost of additional weight
        totalAmount = prices[fromZone - 1][toZone - 1] + additionalFee;

        OrderArray[dispatcherName - 1][orderNumber[dispatcherName - 1]] = totalAmount;
        System.out.println();

        //Display Order no, Dispatcher name, from zone , to zone, and charge
        System.out.printf("Order no: %d%d%d%d%d\n", dispatcherName - 1, orderNumber[dispatcherName - 1],
                orderNumber[dispatcherName - 1], fromZone, toZone);
        System.out.println("Dispatcher Name: " + dispatchers[dispatcherName - 1]);
        System.out.println("From Zone: " + locations[fromZone - 1]);
        System.out.println("To Zone: " + locations[toZone - 1]);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println();
    }

    public void modifyOrder()
    {
        int choice = 0, orderNo = 0, newOrderWeight = 0, newOrderFees = 0;

        System.out.println("Enter the order number of package you want to modify: ");
        orderNo = scan.nextInt();

        do
        {
            System.out.printf("Order no: %d%d%d%d%d\n", dispatcherName - 1, orderNumber[dispatcherName - 1],
                    orderNumber[dispatcherName - 1], fromZone, toZone);
            System.out.println("Dispatcher Name: " + dispatchers[dispatcherName - 1]);
            System.out.println("From Zone: " + locations[fromZone - 1]);
            System.out.println("To Zone: " + locations[toZone - 1]);
            System.out.println("Total Amount: " + totalAmount + "\n");
            System.out.println("Do you want to modify the weight of the package ?\n1. Yes\n2. No\nAnswer: ");
            choice = scan.nextInt();

            if(choice < 1 || choice > 2)
            {
                System.out.println(choice + " is not on list, Please re-enter (1-2): ");
                choice = scan.nextInt();
            }
        } while (choice < 1 || choice > 2);

        if (choice == 1)
        {
            do
            {
                System.out.println("Enter the new package weight: ");
                newOrderWeight = scan.nextInt();

                if(newOrderWeight < 100)
                {
                    System.out.println("Minimum package weight must be more than 100g. Please Re-enter: ");
                    newOrderWeight = scan.nextInt();
                }
            } while (newOrderWeight < 100);

            if (newOrderWeight < orderWeight)
            {
                System.out.println("");
            }
        }
        else
            System.out.println("The order cannot be found,Try It again :");

        System.out.println();
        System.out.println();
        System.out.println();
    }

    void viewOrder()
    {


        //Declaring variables
        int i = 0, totalOrders = 0, totalOrderColumn1 = 0, totalOrderColumn2 = 0,
                totalOrderColumn3 = 0, grossWagesColumn1 = 0, grossWagesColumn2 = 0,
                grossWagesColumn3 = 0, totalGrossWage = 0;

        double sum = 0, totalWagesOfColumn1 = 0, totalWagesOfColumn2 = 0, totalWagesOfColumn3 = 0,
                totalWages = 0, totalCommission = 0, totalCommisionColumn1 = sum,
                totalCommisionColumn2 = sum, totalCommisionColumn3 = sum;

        //Display the order for each dispatcher, their wages and commission
        System.out.println();
        System.out.printf("\t\t\t" + "Sunway City Delivery Company daily report for " + dateFormat.format(localTime) + "\n");
        System.out.printf("%s %20s %12s %12s %14s", "Dispatcher", dispatchers[0], dispatchers[1], dispatchers[2], "Total");
        System.out.println();

        //Displaying each order number
        for (i = 0; i < 14; i++)
        {
            System.out.printf("%s %d %21d %12d %12d\n", "Order", finalArrayList[i], OrderArray[0][i], OrderArray[1][i],
                    OrderArray[2][i]);
        }

        System.out.printf("%s %d %20d %12d %12d\n", "Order", finalArrayList[14], OrderArray[0][14], OrderArray[1][14], OrderArray[2][14]);
        System.out.println();

        //Calculation and displays the total number of orders
        for (i = 0; i < 15; i++)
        {
            if (OrderArray[0][i] > 0)
                totalOrderColumn1 = totalOrderColumn1 + 1;
            if (OrderArray[1][i] > 0)
                totalOrderColumn2 = totalOrderColumn2 + 1;
            if (OrderArray[2][i] > 0)
                totalOrderColumn3 = totalOrderColumn3 + 1;
        }

        totalOrders = totalOrderColumn1 + totalOrderColumn2 + totalOrderColumn3;

        System.out.printf("%s %4d %12d %12d %15d", "Total number of orders: ", totalOrderColumn1, totalOrderColumn2,
                totalOrderColumn3, totalOrders);
        System.out.println();

        //Calculate and display the value for Gross Wages
        grossWagesColumn1 = totalOrderColumn1 * 3;
        grossWagesColumn2 = totalOrderColumn2 * 3;
        grossWagesColumn3 = totalOrderColumn3 * 3;
        totalGrossWage = grossWagesColumn1 + grossWagesColumn2 + grossWagesColumn3;
        System.out.printf("%s %15d %12d %12d %15d", "Gross wages: ", grossWagesColumn1, grossWagesColumn2, grossWagesColumn3,
                totalGrossWage);
        System.out.println();

        //Calculate and display the commission
        for (i = 0; i < 10; i++)
        {
            if (totalOrderColumn1 == 10)
            {
                sum = sum + OrderArray[0][i];
                totalCommisionColumn1 = sum;
            }
            if (totalOrderColumn2 == 10)
            {
                sum = sum + OrderArray[1][i];
                totalCommisionColumn2 = sum;
            }
            if (totalOrderColumn1 == 10)
            {
                sum = sum + OrderArray[0][i];
                totalCommisionColumn3 = sum;
            }
        }

        totalCommisionColumn1 = totalCommisionColumn1 * 0.05;
        totalCommisionColumn2 = totalCommisionColumn2 * 0.05;
        totalCommisionColumn3 = totalCommisionColumn3 * 0.05;

        totalCommission = totalCommisionColumn1 + totalCommisionColumn2 + totalCommisionColumn3;
        System.out.printf("%s %19.2f %12.2f %12.2f %15.2f", "Commission", totalCommisionColumn1, totalCommisionColumn2,
                totalCommisionColumn3, totalCommission);

        System.out.println();
        //Calculation of the total Wages
        totalWagesOfColumn1 = totalCommisionColumn1 + grossWagesColumn1;
        totalWagesOfColumn2 = totalCommisionColumn2 + grossWagesColumn2;
        totalWagesOfColumn3 = totalCommisionColumn3 + grossWagesColumn3;
        totalWages = totalWagesOfColumn1 + totalWagesOfColumn2 + totalWagesOfColumn3;

        System.out.printf("%s %18.2f %12.2f %12.2f %15.2f", "Total Wages", totalWagesOfColumn1, totalWagesOfColumn2,
                totalWagesOfColumn3, totalWages);
        System.out.println();
    }
    public void exitOrder() {
        System.out.println("It was great time with you and see you Soon!!");
    }
}