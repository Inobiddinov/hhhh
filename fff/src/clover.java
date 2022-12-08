import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class clover {
    public static void main(String[] args) throws Exception {
//        File file = new File ("colors");
//
//        PrintWriter pw = new PrintWriter(file);
//
//        //write data to file
//        pw.println("red");
//        pw.println(12);
//        pw.println('c');
//        pw.println(0.23);
//        pw.println("blue ");
//        pw.println("color");
//
//        //close the file ***** compulsory & important step
//        pw.close();

        File file = new File ("colors");
        PrintWriter pw = new PrintWriter(file);
        Scanner scan = new Scanner (System.in);
        int num =0;
        do{
            System.out.println("enter a number zero to stop: ");
            num = scan.nextInt();
            if (num!=0){
                pw.println(num);
            }
        } while (num!=0);
        pw.close();  //*******compulsore & important step
    }
}
