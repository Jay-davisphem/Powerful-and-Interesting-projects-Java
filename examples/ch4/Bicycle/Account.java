class Account {
    // Data Members
    private String ownerName;
    private double balance;
    
    //Constructor
    public Account(String name, double startingBalance) {
        ownerName = name;
        balance = startingBalance;
    }
    
    //Adds the passed amount to the balance
    public void add(double amt) {
        balance += amt;
    }
    //Deducts the passed amount from the balance
    public void deduct(double amt) {
        balance -=  amt;
    }
    
    //Returns the current balance of this account
    public double getCurrentBalance( ) {
        return balance;
    }
    //Returns the name of this account's owner
    public String getOwnerName( ) {
        return ownerName;
    }
    //Assigns the name of this account's owner
    public void setOwnerName(String name) {
        ownerName = name;
    }
}
