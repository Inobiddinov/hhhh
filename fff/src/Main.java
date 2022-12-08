import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Main{
    public static void main (String[]args) throws Exception {
        //construct file object
//        File file = new File("myfile");

//        System.out.println("can read?"+file.canRead());
//        System.out.println("can write?" + file.canWrite());
//
//        System.out.println("size " +file.length());
//        System.out.println("last modified date:" +file.lastModified());
//        System.out.println("last modified date:"+ new Date(file.lastModified()));

//      //construct scanner object
//        Scanner scan = new Scanner (file);
//        String line = "";
//        //read data in a loop
//        for (int cnt=1; cnt<=3; cnt++){
//            line = scan.nextLine();
//
//            //display resut
//            System.out.printf("line %d: %s",cnt , line);
//            System.out.println();
//        }

        String name="";
        int amt=0, total=0;

        //1. construct a file object
        File file = new File("result");
        //2. construct a scanner object
        Scanner scan = new Scanner(file);
        //3. read data in a loop
        for (int cnt=1; cnt<=10; cnt++){
           // name = scan.next(); //read only 1 word
            amt = scan.nextInt();
            int cmd = scan.nextInt();
            int cmec = scan.nextInt();
            int cmr = scan.nextInt();

            //4. sum the sales
        total = total+amt;
        //5. display result
        System.out.printf("RM%d ",amt);
        System.out.printf("DM%d ",cmd);
        System.out.printf("KM%d ",cmec);
        System.out.printf("RM%d ",cmr);




            System.out.println();
        }
        //6. display sum
        System.out.printf("Total Sales: RM%d", total);


        //compolsury & important step
    }
}