import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int int_rand = random.nextInt();
        System.out.println("Please Type any value from 1 to 9: ");
        int a = scan.nextInt();
        if(a<=0 || a>10){
            System.out.println("invalid Input try again:");
        }
        int ss =0;
        System.out.println();

    }
}