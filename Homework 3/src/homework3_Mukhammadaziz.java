import java.io.File;
import java.util.Scanner;

public class homework3_Mukhammadaziz {
    public static void main(String[] args) throws Exception {

        //construct file object
        File files = new File("homework3");
        //construct scanner object
        Scanner scan = new Scanner(files);
        //declaring variable
        double total = 0;
        double total1 = 0;

        double setAmeal = 9.90;
        double setBmeal = 10.90;
        double setCmeal = 11.90;
        double setDmeal = 12.90;

        String setA = ("    Set A              Set B             Set C              Set D          Total Price \n        RM9.90             RM10.90           RM11.90            RM12.90        (RM)");


        System.out.println("__________________________________________________________________________________________");
        System.out.print("No. " + setA);
        System.out.println();

        System.out.print("==========================================================================================");

       //read data in a loop
        int counter = 1;
        for (int cnt = 1; cnt <= 10; cnt++) {

            int raw1 = scan.nextInt();
            int raw2 = scan.nextInt();
            int raw3 = scan.nextInt();
            int raw4 = scan.nextInt();
            System.out.println();

            //sum the sales
            total = ((raw1 * setAmeal) + (raw2 * setBmeal) + (raw3 * setCmeal) + (raw4 * setDmeal));

            //display result
            System.out.printf("%-2d        %d      ", counter, raw1);
            System.out.printf("            %d      ", raw2);
            System.out.printf("           %d       ", raw3);
            System.out.printf("           %d  %17.2f", raw4, total);


            counter = counter + 1;
            total1 = total1 + total;
        }

        System.out.println();
        System.out.println("__________________________________________________________________________________________");
        System.out.printf("                                                            Total Price         %.2f", total1);

    }
}