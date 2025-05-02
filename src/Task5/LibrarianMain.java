package Task5;

public class LibrarianMain {

  public static void main(String[] args) {
       
        Student student;
        LibraryCard card1,card2;
        student = new Student();
        student.setName("JavaBoy");
        student.setEmail("javaboy@gmail.com");
        
        card1 = new LibraryCard();
        card1.setOwner(student);
        card1.checkOut(3);
        
        card2 = new LibraryCard();
        card2.setOwner(student);
        card2.checkOut(5);

        System.out.println("Card1 Info");
        System.out.println(card1.toString());
        System.out.println("Card2 Infor");
        System.out.println(card2.toString());
        
    }
    
}
