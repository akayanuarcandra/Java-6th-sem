package Task12.Part2;

public class Student{
    private String name;
    private String email;
    private int age;
    
    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public int getAge() {
        return age;
    }

    public int setAge(int age) {
        this.age = age;
        return age;
    }
    
    public void printInfo() {
        System.out.println("Name: " + name + "\tEmail: " + email + "\tAge: " + age);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Email: " + email + " Age: " + age;
    }
}