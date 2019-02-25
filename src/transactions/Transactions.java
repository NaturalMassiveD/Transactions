/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions;

/**
 *
 * @author Dhrgam
 */
import java.text.NumberFormat;
import java.util.Scanner;
public class Transactions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Account acct1 = new Account("Ted Murphy", 72354, 102.56);
        Account acct2 = new Account("Jane Smith", 69713, 40.00);
        Account acct3 = new Account("Edward Demsey", 93757, 759.32);

        acct1.deposit(25.85);

        double smithBalance = acct2.deposit(500.00);
        System.out.println("Smith balance after deposit: " +
                smithBalance);

        //System.out.println("Smith balance after withdrawal: " + 
        //        acct2.withdraw (430.75, 1.50));
        
        Scanner WD = new Scanner(System.in);
        System.out.println("Please enter withdrawal amount:");
        double WDamt = WD.nextDouble();
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        if(smithBalance <= WDamt){
            System.out.println("You have overdrawn. You owe $" + fmt.format(-((smithBalance - WDamt)-1.50)));
        }    
        if(WDamt <=0){
            System.out.println("You can not withdraw a negative number.");
        }
        else{
            System.out.println("Smith balance after withdrawal: " + fmt.format(acct2.withdraw(WDamt, 1.50)));
        }
        
        acct1.addInterest();
        acct2.addInterest();
        acct3.addInterest();

        System.out.println();
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct3);
    }
    
}
