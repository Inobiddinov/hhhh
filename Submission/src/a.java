import java.util.*;

public class a {
    public static void main(String[] args) {


        Compan c = new Compan();


        c.displayMenu();

    }

}


class Compan {
    Scanner scan = new Scanner(System.in);



    String name[] = {"John", "Sam", "Will"};
    String zone[] = {"Zone A", "Zone B"};
    int order[][] = new int [3][15];
    int totalOrder[]= {0,0,0};

    int allWeightFee[][]= new int [3][15];


    public void displayMenu() {
        int choice;
        do {

            System.out.printf("%5s %s\n", " ", "Main Menu");
            System.out.println("1. Enter a new order");
            System.out.println("2. Modify an order");
            System.out.println("3. View all order");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (1-4)");



            choice = scan.nextInt();

            if (choice==1) {
                displayNewOrder();
            }
            else if (choice==2) {
                modify();
            }

            else if (choice==3) {
                displayAll();
            }

            else if (choice==4) {

            }
            else
                System.out.println("Invalid input");
        }while (choice!=4);
    }


    public void displayNewOrder () {

        int dispatchNo=0, zoneFrom=0, zoneTo=0, weight=0;

        for ( int cnt=0; cnt<name.length; cnt++) {
            System.out.printf("%d : %s \n", cnt+1, name[cnt]);
        }
        do {
            System.out.println("Choose a dispatcher(1-3):");
            dispatchNo = scan.nextInt();
            if (dispatchNo<1 || dispatchNo>3)
                System.out.println("Invalid input");

        }while (dispatchNo<1 ||dispatchNo>3);

        do {
            System.out.println("Enter from where you are delivering(1-Zone A, 2-Zone B)");
            zoneFrom= scan.nextInt();
            if (zoneFrom !=1 && zoneFrom!=2)
                System.out.println("Invalid input");
        } while (zoneFrom !=1 && zoneFrom!=2);

        do {
            System.out.println("Enter where you are delivering to(1-Zone A, 2-Zone B");
            zoneTo= scan.nextInt();
            if (zoneTo !=1 && zoneTo!=2)
                System.out.println("Invalid input");
        } while (zoneTo !=1 && zoneTo!=2);

        do {
            System.out.println("Enter package weight(>100g):");
            weight = scan.nextInt();
            if (weight <100)
                System.out.println("Invalid weight");
        }while (weight<100);

        System.out.print(dispatchNo);

        dispatchNo--;



        if (dispatchNo<10)
            System.out.print("0"+ totalOrder[dispatchNo]);
        else
            System.out.print(totalOrder[dispatchNo]);
        System.out.print("" + zoneFrom + zoneTo);

        allWeightFee[dispatchNo][totalOrder[dispatchNo]]= calcCharge(zoneFrom, zoneTo, weight);
        System.out.printf(" %s %s %s %d\n", name[dispatchNo], zone[--zoneFrom], zone[--zoneTo], allWeightFee[dispatchNo][totalOrder[dispatchNo]]);

        System.out.println();
        System.out.println();

        totalOrder[dispatchNo]++;
    }


    public void modify() {
        boolean valid=false;
        int modifyOrder=0;
        int editOrder=0;
        int editName=0;
        int editZoneFrom=0, editZoneTo=0;
        int newCharge=0, oldCharge=0;
        int weight=0;
        int zoneFrom=0, zoneTo=0;
        int dispatchNo=0;

        do {
            do {
                valid= true;

                System.out.println("Enter an order nuumber(5 digits):");

                modifyOrder = scan.nextInt();
                if (modifyOrder<10111 || modifyOrder>31522) {
                    System.out.println("Invalid Order Number"); valid=false;}
            }while (!valid);

            editZoneTo= modifyOrder%10;
            editZoneFrom = (modifyOrder/10)%10;
            editOrder = ((modifyOrder/10)/10)%100;
            editName = (((((modifyOrder/10)/10)/10)/10)%10);
            System.out.println("" + editName + editOrder + editZoneFrom + editZoneTo);

            if (editName>3 || editName<1) {
                System.out.println("Invalid dispatcher No."); valid=false;
            }


            if (editOrder>totalOrder[(editName-1)] ||editOrder<=0) {
                System.out.println("Invalid OrderNo");
                valid=false;
            }

            if (editZoneFrom !=1 && editZoneFrom!=2) {
                System.out.println("Invalid From Zone");
                valid=false;
            }

            if (editZoneTo!=1 && editZoneTo!=2){
                System.out.println("Invalid To Zone");
                valid=false;
            }
        }while (!valid);


        do {
            System.out.println("Enter new weight(>100g):");
            weight = scan.nextInt();
            if (weight<100) System.out.println("Invalid weight");
        }while (weight<100);

        zoneFrom=editZoneFrom;zoneTo=editZoneTo;
        dispatchNo = editName-1;
        --editOrder;

        newCharge = calcCharge(zoneFrom, zoneTo, weight);


        oldCharge = allWeightFee[dispatchNo][editOrder];

        System.out.println(newCharge);
        if (oldCharge>newCharge)
            System.out.println("Refunded Amount: RM" + (oldCharge-newCharge));
        else
            System.out.println("Top-up amount: RM" + (newCharge-oldCharge));
        allWeightFee[dispatchNo][editOrder]= newCharge;
        System.out.println();
        System.out.println();
    }


    public void displayAll() {
        double grossWage[]= new double [3];
        double commission[]= new double [3];
        double totalWage[] = new double [3];

        for(int count=0; count<grossWage.length; count++) {
            grossWage[count]= totalOrder[count]*3;
            if (totalOrder[count]>=10)
                commission[count]= 0.05*grossWage[count];

            totalWage[count]=grossWage[count]+commission[count];
        }


        display(" Dispatcher", name);

        for (int cntt=0; cntt<15; cntt++) {
            System.out.printf("%-20s",  "Order"+ (cntt+1));
            for (int number=0; number<allWeightFee.length; number++) {
                System.out.printf("%8d ",allWeightFee[number][cntt]);
            }
            System.out.println();
        }
        System.out.println();
        display(" Gross Wages", grossWage);
        display(" Commission", commission);
        display(" Total wages", totalWage);
        System.out.println();
    }
    public void display (String msg, String name[]) {
        System.out.printf("%-20s ", msg);
        for (int cnt=0; cnt<order.length; cnt++) {
            System.out.printf("%8s ", name[cnt]);
        }
        System.out.println();
    }

    public void display (String msg, int order[]) {
        System.out.printf("%-20s", msg);
        for (int cnt=0; cnt<order.length; cnt++) {
            System.out.printf("%8d ", order[cnt]);
        }
        System.out.println();
    }

    public void display (String msg, double amount[]) {
        System.out.printf("%-20s", msg);
        for (int cnt=0; cnt<amount.length; cnt++) {
            System.out.printf("%8.2f ", amount[cnt]);
        }
        System.out.println();
    }


    public int calcCharge(int zoneFrom, int zoneTo, int weight) {
        int deliveryFee=0;
        int extraFee=0;
        int totalFee=0;
        if (zoneFrom == zoneTo)
            deliveryFee=6;
        else
            deliveryFee=7;

        if ((weight-100)%100==0)
            extraFee= (weight-100)/100;
        else
            extraFee= (((weight-100)/100)+1);

        totalFee =deliveryFee+extraFee;
        return totalFee;
    }


}