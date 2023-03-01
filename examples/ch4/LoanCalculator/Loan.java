class Loan{
  // Data Members
  private static final int MONTHS_IN_YEAR = 12;
  private double loanAmount;
  private double monthlyInterestRate;
  private int numberOfPayments;
  
  // Contructor
  public Loan(double amount, double rate, int period){
    setAmount(amount);
    setRate(rate);
    setPeriod(period);
  }

  // Methods
  public void setPeriod(int periodInYear){
    numberOfPayments = periodInYear * MONTHS_IN_YEAR;
  }
  public int getPeriod(){
    return  (numberOfPayments / MONTHS_IN_YEAR);
  }
  public void setAmount(double amount){
    loanAmount = amount;
  }
  public double getAmount(){
    return loanAmount;
  }
  public void setRate(double rate){
    monthlyInterestRate  = rate / 100.0 / MONTHS_IN_YEAR;
  }
  public double getRate(){
    return monthlyInterestRate * 100.0 * MONTHS_IN_YEAR;
  }
  public double getMonthlyPayment(){
    double monthlyPayment;
    monthlyPayment = (loanAmount * monthlyInterestRate)  
      / 
      (1 - Math.pow(1/(1 + monthlyInterestRate), numberOfPayments));
    return monthlyPayment;
  }
  public double getTotalPayment(){
    double totalPayment;
    totalPayment = getMonthlyPayment() * numberOfPayments;
    return totalPayment;
  }
}
