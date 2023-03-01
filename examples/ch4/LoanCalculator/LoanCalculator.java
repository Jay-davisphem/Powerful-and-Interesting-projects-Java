import java.util.*;
import java.text.*;
class LoanCalculator{
  private Loan loan;

  public static void main(String[] arg){
    LoanCalculator calculator = new LoanCalculator();
    calculator.start();
  }

  public LoanCalculator(){
  }

  // Top-level method that calls other private methods
  public void start(){
    describeProgram();
    getInput();
    computePayment();
    displayOutput();
  }
  private  void describeProgram(){
    System.out.println("This program computes the monthly and total");
    System.out.println("payments for a given loan amount, annual ");
    System.out.println("interest rate, and loan period (# of years).");
    System.out.println("\n");
  }
  private void getInput(){
    double loanAmount, annualInterestRate;
    int loanPeriod;
    Scanner scan = new Scanner(System.in);
    System.out.print("Loan Amount (Dollars+Cents): ");
    loanAmount = scan.nextDouble();
   
    System.out.print("Annual Interest Rate (e.g., 9.5): ");
    annualInterestRate = scan.nextDouble();
    
    System.out.print("Loan Period - # of years: ");
    loanPeriod = scan.nextInt();
    
    //create a new loan with the input values
    loan = new Loan(loanAmount, annualInterestRate,loanPeriod);
  }
  private  void computePayment(){
    System.out.println("inside computePayment");
  }
  private void displayOutput(){
    //echo print the input values here
    DecimalFormat df = new DecimalFormat("0.000");
    System.out.println("Loan Amount: $" + loan.getAmount());
    System.out.println("Annual Interest Rate:" + loan.getRate() + "%");
    System.out.println("Loan Period (years): " + loan.getPeriod());
    System.out.println("Monthly payment is $ " + df.format(loan.getMonthlyPayment() ));
    System.out.println(" TOTAL payment is $ " + df.format(loan.getTotalPayment() ));
  }
}
