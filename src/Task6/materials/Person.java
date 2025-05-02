package Task6.materials;

public class Person {

    //Data Member
    private String name;
    private int age;
	private char gender; // 'M'-Male , 'F'-Female

    //Constructor
	
	public Person(){
		
	}
    public Person(String name,int age,char gender){
        
        this.name = name;
		this.age = age;
		this.gender = gender; 
    }

   //method
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
	public char getGender(){
        return gender;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name; 
    }
	public void setGender(char gender){
        this.gender = gender;
    }
}
