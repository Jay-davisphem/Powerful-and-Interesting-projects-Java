class SecondMain {
    // This sample program uses both the Bicycle and Account classes
    public static void main(String[] args) {
        Bicycle bike;
        Account acct;
   
        String myName = "Jon Java";
        bike = new Bicycle();
        bike.setOwnerName(myName);
        acct = new Account(myName, 250.00);
    
        acct.add(25.00);
        acct.deduct(50);
        
        //Output some information
        System.out.println(bike.getOwnerName() + " owns a bicycle and");
        System.out.println("has $ " + acct.getCurrentBalance() +" left in the bank");
    }
}
