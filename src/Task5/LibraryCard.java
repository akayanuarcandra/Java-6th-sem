package Task5;

public class LibraryCard {
    
    //Data Member
    private Student owner;
    private int borrowCount;
    //Constructor
    public LibraryCard(){
        owner = null;
        borrowCount = 0;
    }

   //Method
    public void checkOut(int numOfBooks){
        borrowCount = borrowCount +numOfBooks;
    }
    public void returnBook(int numOfBooks){
        borrowCount = borrowCount-numOfBooks;
    }
    public int getNumberOfBook(){
        return  borrowCount;
    }
    public String getOwnerName(){
        return owner.getName();
    }
    public void setOwner(Student st){
        owner =st;
    }
    public String toString(){
        return "Owner name:"+owner.getName()+"\n"+
                "Email:"+owner.getEmail()+"\n"+
                "Books borrowed: "+ borrowCount;
    }
    
}
