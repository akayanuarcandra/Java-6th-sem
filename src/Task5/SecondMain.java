package Task5;

class SecondMain {

    //This sample program uses both the Bicycle and Account classes

    public static void main(String[] args) {
    
        Bicycle bike;
        Account acct;
        
        String  myName = "Jon Java";
        
        bike = new Bicycle( );    
        bike.setOwnerName(myName);
        
        acct = new Account( );
        acct.setOwnerName(myName);
        acct.setInitialBalance(250.00);
        
        acct.add(25.00);
        acct.deduct(50);
 
        //Output some information      
        System.out.println(bike.getOwnerName() + " owns a bicycle and");                            
        System.out.println("has $ " + acct.getCurrentBalance() + 							" left in the bank");

        System.out.println("=======================================");

        Account acct1 = new Account("Vivian", 250.00);
        Account acct2 = new Account("Miyabi", 100.00);
        acct1.add(25);
        acct2.add(25);
        acct1.deduct(50);
        acct2.deduct(50);
        System.out.println(acct1.getOwnerName() + " has $" + acct1.getCurrentBalance() + " left in the bank");
        System.out.println(acct2.getOwnerName() + " has $" + acct2.getCurrentBalance() + " left in the bank");
    }
}
