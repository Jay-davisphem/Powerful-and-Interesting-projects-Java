/*
 * Problem statement: Write a loan calculator program that computes 
   both monthly and total payments for a given loan amount, 
   annual interest rate, and loan period
 * File: LoanCalculator.java
 * Step 1: Input Data Values, loanAmount, interestRate, loanPeriod
 * Step 2: Compute the monthly and total payments, 
   monthly_paynent = (L * R)/(1 - [1/(1 + R)]^N)
 * Step 3: Output the results
*/
import java.util.*;
import java.text.*;
class LoanCalculator{
    public static void main(String[] args){
        // constants
        final int MONTHS_IN_YEAR = 12;
        // inputs
        double loanAmount, annualInterestRate;
        int loanPeriod;
        // outputs
        double monthlyPayment, totalPayment, monthlyInterestRate;
        int numberOfPayment;
        DecimalFormat df = new DecimalFormat("0.00");
        // STEP 1
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(System.getProperty("line.separator"));

        System.out.print("Loan Amount (Naira:Kobo): ");
        loanAmount = scan.nextDouble();

        System.out.print("Interest Rate (%): ");
        annualInterestRate = scan.nextDouble();

        System.out.print("Loan Period (years): ");
        loanPeriod = scan.nextInt();
        
        // STEP TWO
        numberOfPayment = MONTHS_IN_YEAR * loanPeriod;
        monthlyInterestRate = annualInterestRate / 100.0 / MONTHS_IN_YEAR;

        monthlyPayment = (loanAmount * monthlyInterestRate) / 
            (1 - Math.pow(1/(1 + monthlyInterestRate), numberOfPayment));
        totalPayment = monthlyPayment * numberOfPayment;
        // STEP 3
        System.out.println("");
        System.out.println("Loan Amount:            $" + loanAmount);
        System.out.println("Annual Interest Rate:   " + annualInterestRate + "%");
        System.out.println("Loan Period (years):    " + loanPeriod);
        System.out.println("\n"); //skip two lines
        System.out.println("Monthly payment is      $" + df.format(monthlyPayment));
        System.out.println("  TOTAL payment is      $" + df.format(totalPayment));
        scan.close();
    }
}
