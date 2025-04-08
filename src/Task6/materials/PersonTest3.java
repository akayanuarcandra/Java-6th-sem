package Task6.materials;

import java.util.Scanner;

public class PersonTest3 {

	public static void main(String[] args) {

		Person[ ]  person;
		person = new Person[5];
		String 	name,inpStr;
		int age;
		char gender;
		int		minIdx = 0;		//index to the youngest person
		int		maxIdx = 0; 	//index to the oldest person


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
		for (int i = 1; i < person.length; i++) {
			if ( person[i].getAge() < person[minIdx].getAge() ) {
				minIdx = i; 	//found a younger person

			} else if (person[i].getAge() > person[maxIdx].getAge() ) {
				maxIdx = i; 	//found an older person
			}
		}
		System.out.println( "The youngest person is " + person[minIdx].getName());
		System.out.println( "The oldest person is " + person[maxIdx].getName());

		scanner.close();


	}

}
