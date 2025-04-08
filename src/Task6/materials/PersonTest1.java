package Task6.materials;

public class PersonTest1 {

  public static void main(String[] args) {
       
        Person latte;

		latte = new Person( );
		latte.setName("Ms. Latte");
		latte.setAge(20);
		latte.setGender('F');

		System.out.println( "Name: " + latte.getName()   );
		System.out.println( "Age : " + latte.getAge()    );
		System.out.println( "Gender : " + latte.getGender() );

        
    }
    
}
