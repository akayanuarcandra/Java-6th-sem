package Task6.materials;
import java.util.Scanner;

public class PersonTest2 {

  public static void main(String[] args) {
       
        Person[ ]  person;
		person = new Person[3];
		String 	name,inpStr;
		int age;
		char gender;
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < person.length; i++) {
			System.out.print("Enter name:"); name = scanner.next ( );
			System.out.print("Enter age:");  age = scanner.nextInt( );
			System.out.print("Enter gender:"); inpStr = scanner.next( );
			gender = inpStr.charAt(0);
			
			person[i] = new Person( );    //create a new Person and assign values
			person[i].setName  ( name   );
			person[i].setAge   (  age   );
			person[i].setGender( gender );
		}
		for (int i = 0; i < person.length; i++) {
			System.out.print( "Name: " + person[i].getName()   );
			System.out.print( " Age : " + person[i].getAge()    );
			System.out.println( " Gender : " + person[i].getGender() );
		}
		scanner.close();

        
    }
    
}
