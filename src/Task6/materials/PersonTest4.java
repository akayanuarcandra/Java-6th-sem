package Task6.materials;
import java.util.Scanner;

public class PersonTest4 {

  public static void main(String[] args) {
       
        Person[ ]  person;
		person = new Person[5];
		String 	name,inpStr;
		int age;
		char gender;
		String searchName;

		
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
		System.out.print("Enter a name for search:"); 
		searchName = scanner.next ( );
		int index=-1;
		boolean findIt = false;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getName().equals(searchName)  ) { 
				index=i;
				findIt = true;
				break;
			}
		}

		if ( findIt ) {
			//found - successful search
			System.out.println("Found "+searchName+" at position " + index);
				

			} else {
				//not found - unsuccessful search
				System.out.println(searchName+" was not in the array");
			}
       	scanner.close(); 
    }
    
}
