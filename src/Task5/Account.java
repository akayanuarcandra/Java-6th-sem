package Task5;

class Account {

    private String ownerName;
    
    private double balance;
    
    public Account( ) {
	    ownerName = "Unassigned";
	    balance = 0.0;
    }

    public Account (String name, double bal) {
        ownerName = name;
        balance = bal;
    }

    public void add(double amt) {
        balance = balance + amt;
    }
    
    public void deduct(double amt) {
        balance = balance - amt;
    }
    
    public double getCurrentBalance( ) {
        return balance;
    }
    
    public String getOwnerName( ) {
        
        return ownerName;
    }
    public void setInitialBalance
                         (double bal) {
        
         balance = bal;
    }
    
    public void setOwnerName
                       (String name) {
    
        ownerName = name;
    }    
 }
