import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Assignment2A_Trial
{
    public static void main(String args[])
    {
        Mainmenu menu = new Mainmenu();
        menu.mainMenu();
    }
}

class Mainmenu
{
    // Arrays
    int orderNumber[] = { 0, 0, 0, 0, 0 };
    int order[][] = new int[3][15];
    int prices[][] = { { 6 }, { 7 } };
    static String[] dispatcher = { "Chris", "John", "Wick" };
    String[] location = { "Zone A", "Zone B" };
    int displayOrder[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

    // declaration of instance variables
    int newWeight = 0, additionalFee = 0, totalAmount = 0, dispatcherName = 0, fromZone = 0, toZone = 0;
    double orderWeight = 0;

    Scanner scan = new Scanner(System.in);

    void mainMenu()
    {
        int options = 0;
        do
        {
            do
            {
                System.out.print(
                        "Welcome to Nile Delivery\nMain Menu\n1. Add order\n2. Modify Order\n3. View orders\n4. Exit\nSelect an option (1,2,3,4):  ");
                options = scan.nextInt();

                if (options == 1)
                    addOrder();
                else if (options == 2)
                    modifyOrder();
                else if (options == 3)
                    viewOrder();
                else if (options == 4)
                    exitOrder();
                else
                    System.out.println("Invalid option. Please re-select: ");
            } while (options < 1 || options > 4);
        } while (options != 4);
    }

    void addOrder()
    {
        //Prompt user to select a dispatcher
        do {
            System.out.println("1. Chris\n2. John\n3. Wick\nChoose a dispatcher (1,2,3): ");
            dispatcherName = scan.nextInt();
        } while (dispatcherName < 1 || dispatcherName > 4);

        //Ensure that the dispatcher only has 15 deliveries to make in a day
        do
        {
            if(orderNumber[dispatcherName - 1] == 15)
            {
                System.out.println(dispatcher[dispatcherName - 1] + "has reached the maximum limit for the day. Select a different dispatcher: ");
                dispatcherName = scan.nextInt();
            }
        } while (orderNumber[dispatcherName - 1] == 15);

        //Prompt user to choose the area the dispatcher is coming from
        do {
            System.out.println("1. Zone A\n2. Zone B\nChoose location for the dispatcher to drive from: ");
            fromZone = scan.nextInt();
        } while (fromZone < 1 || fromZone > 2);

        //Prompt user to choose the area the dispatcher is going to
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

        order[dispatcherName - 1][orderNumber[dispatcherName - 1]] = totalAmount;
        System.out.println();

        // Print order no., dispatcher's name, from zone, to zone, and charges on screen
        System.out.printf("Order no: %d%d%d%d%d\n", dispatcherName - 1, orderNumber[dispatcherName - 1],
                orderNumber[dispatcherName - 1], fromZone, toZone);
        System.out.println("Dispatcher Name: " + dispatcher[dispatcherName - 1]);
        System.out.println("From Zone: " + location[fromZone - 1]);
        System.out.println("To Zone: " + location[toZone - 1]);
        System.out.println("Total Amount: " + totalAmount + "\n");
    }

    void modifyOrder()
    {
        int decision = 0, orderNo = 0, newOrderWeight = 0, newOrderFee = 0;

        System.out.println("Enter the order number of package you want to modify: ");
        orderNo = scan.nextInt();

        do
        {
            System.out.printf("Order no: %d%d%d%d%d\n", dispatcherName - 1, orderNumber[dispatcherName - 1],
                    orderNumber[dispatcherName - 1], fromZone, toZone);
            System.out.println("Dispatcher Name: " + dispatcher[dispatcherName - 1]);
            System.out.println("From Zone: " + location[fromZone - 1]);
            System.out.println("To Zone: " + location[toZone - 1]);
            System.out.println("Total Amount: " + totalAmount + "\n");
            System.out.println("Do you want to modify the weight of the package ?\n1. Yes\n2. No\nAnswer: ");
            decision = scan.nextInt();

            if(decision < 1 || decision > 2)
            {
                System.out.println(decision + " is incorrect, please re-enter (1/2): ");
                decision = scan.nextInt();
            }
        } while (decision < 1 || decision > 2);

        if (decision == 1)
        {
            do
            {
                System.out.println("Enter the new package weight: ");
                newOrderWeight = scan.nextInt();

                if(newOrderWeight < 100)
                {
                    System.out.println("Minimum package weight is 100g. Re-enter: ");
                    newOrderWeight = scan.nextInt();
                }
            } while (newOrderWeight < 100);

            if (newOrderWeight < orderWeight)
            {

            }
        }
        else
            System.out.println("The order cannot be found");

        System.out.println();
        System.out.println();
    }

    void viewOrder()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();

        //Declaring variables
        int i = 0, totalOrders = 0, col1TotalOrder = 0, col2TotalOrder = 0,
                col3TotalOrder = 0, col1GrossWages = 0, col2GrossWages = 0,
                col3GrossWages = 0, totalGrossWage = 0;
        double sum = 0, col1TotalWages = 0, col2TotalWages = 0, col3TotalWages = 0,
                finalWages = 0, totalCommission = 0, col1Commission = sum,
                col2Commission = sum, col3Commission = sum;

        //Display the order for each dispatcher, their wages and commission
        System.out.println();
        System.out.printf("\t\t\t" + "Nile Delivery Company daily report for " + dtf.format(now) + "\n");
        System.out.printf("%s %20s %12s %12s %14s", "Dispatcher", dispatcher[0], dispatcher[1], dispatcher[2], "Total");
        System.out.println();

        //Displaying each order number
        for (i = 0; i < 14; i++)
        {
            System.out.printf("%s %d %21d %12d %12d\n", "Order", displayOrder[i], order[0][i], order[1][i],
                    order[2][i]);
        }

        System.out.printf("%s %d %20d %12d %12d\n", "Order", displayOrder[14], order[0][14], order[1][14], order[2][14]);
        System.out.println();

        //Calculation and displays the total number of orders
        for (i = 0; i < 15; i++)
        {
            if (order[0][i] > 0)
                col1TotalOrder = col1TotalOrder + 1;
            if (order[1][i] > 0)
                col2TotalOrder = col2TotalOrder + 1;
            if (order[2][i] > 0)
                col3TotalOrder = col3TotalOrder + 1;
        }

        totalOrders = col1TotalOrder + col2TotalOrder + col3TotalOrder;

        System.out.printf("%s %4d %12d %12d %15d", "Total number of orders: ", col1TotalOrder, col2TotalOrder,
                col3TotalOrder, totalOrders);
        System.out.println();

        //Calculate and display the value for Gross Wages
        col1GrossWages = col1TotalOrder * 3;
        col2GrossWages = col2TotalOrder * 3;
        col3GrossWages = col3TotalOrder * 3;
        totalGrossWage = col1GrossWages + col2GrossWages + col3GrossWages;
        System.out.printf("%s %15d %12d %12d %15d", "Gross wages: ", col1GrossWages, col2GrossWages, col3GrossWages,
                totalGrossWage);
        System.out.println();

        //Calculate and display the commission
        for (i = 0; i < 10; i++)
        {
            if (col1TotalOrder == 10)
            {
                sum = sum + order[0][i];
                col1Commission = sum;
            }
            if (col2TotalOrder == 10)
            {
                sum = sum + order[1][i];
                col2Commission = sum;
            }
            if (col1TotalOrder == 10)
            {
                sum = sum + order[0][i];
                col3Commission = sum;
            }
        }

        col1Commission = col1Commission * 0.05;
        col2Commission = col2Commission * 0.05;
        col3Commission = col3Commission * 0.05;

        totalCommission = col1Commission + col2Commission + col3Commission;
        System.out.printf("%s %19.2f %12.2f %12.2f %15.2f", "Commission", col1Commission, col2Commission,
                col3Commission, totalCommission);
        System.out.println();

        //Calculation of the total Wages
        col1TotalWages = col1Commission + col1GrossWages;
        col2TotalWages = col2Commission + col2GrossWages;
        col3TotalWages = col3Commission + col3GrossWages;
        finalWages = col1TotalWages + col2TotalWages + col3TotalWages;

        System.out.printf("%s %18.2f %12.2f %12.2f %15.2f", "Total Wages", col1TotalWages, col2TotalWages,
                col3TotalWages, finalWages);
        System.out.println();
    }

    void exitOrder() {
        System.out.println("Thank you for using Nile Delivery");
    }
}