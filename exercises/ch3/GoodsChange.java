/*
 * an application that reads a purchase price 
   and an amount tendered and then displays 
   the change in dollars, quarters, dimes, nickels, and
   pennies.
*/
import java.util.*;
import java.text.*;
class Change{
  public static void main(String[] args){
    // Amount of cents  constanst that makes a quarte, dime, nickel and penny respectively.
    final int DOLLAR = 100;
    final int QUARTER = 25;
    final int DIME = 10;
    final int NICKEL = 5;
    final int PENNY = 1;
    // Take two input, purchase price and amount tendered cents
    int purchasePrice, amountTendered, change;
    double purchasePriceD, amountTenderedD, changeD; 

    // outputs denomination
    int dollars, quarters, dimes, nickels, pennies;

    Scanner scan = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    System.out.print(" Purchase Price (cents):  ");
    purchasePrice = scan.nextInt();
    System.out.print("Amount Tendered (cents):  ");
    amountTendered = scan.nextInt();
    change = amountTendered - purchasePrice;

    purchasePriceD = (double)(purchasePrice)/DOLLAR;
    amountTenderedD = (double)(amountTendered)/DOLLAR;
    changeD = (double)(change)/DOLLAR;
    System.out.println("\n Purchase Price:  $" + df.format(purchasePriceD));
    System.out.println("Amount Tendered:  $" + df.format(amountTenderedD));
    System.out.println("\n Your change is:  $" + df.format(changeD));

    dollars = change/DOLLAR;
    change %= DOLLAR;
    quarters = change/QUARTER;
    change %= QUARTER;
    dimes = change/DIME;
    change %= DIME;
    nickels = change/NICKEL;
    change %= NICKEL;
    pennies = change;

    System.out.println("\n                  " + dollars + " one-dollar bill(s)");
    System.out.println("                  " + quarters + " quarter(s)");
    System.out.println("                  " + dimes + " dime(s)");
    System.out.println("                  " + nickels + " nickel(s)");
    System.out.println("                  " + pennies + " penn(y/ies)");

    System.out.println("\nThank you for your business. Come back soon.");
    scan.close();
  }
}
