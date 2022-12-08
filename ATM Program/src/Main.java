import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   int balance = 10000000, withdraw, deposit;

   Scanner scam = new Scanner(System.in);
   while(true){
       System.out.println("ATM machine");
       System.out.println("Choose 1: for Withdraw money.");
       System.out.println("Choose 2: for Deposit.");
       System.out.println("Choose 3: for Check Balance.");
       System.out.println("Choose 4: for EXIT.");
       System.out.println("Choose one of this option you want to perform from above");

       int choice = scam.nextInt();
       switch (choice){
           case 1:
               System.out.println("Enter money to be withdrawn: ");

               withdraw = scam.nextInt();

               if(balance >= withdraw){
                   balance = balance - withdraw;
                   System.out.println("Please collect your money");
               }
               else{
                   System.out.println();
                   break;
               }
               case 2 :
                   System.out.println("Enter money to be deposited: ");

                   deposit = scam.nextInt();

                   balance = balance+deposit;
                   System.out.println("You have successfully deposited!");
                   System.out.println();
                   break;
                   case 3:
                       System.out.println("Balance: " + balance);
                       System.out.println();
                       break;
                       case 4 :System.exit(0);
       }

   }
    }
}