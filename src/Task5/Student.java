package Task5;

public class Student {
    private static int idCounter = 1;
    private final String id;
    private String name;
    private String email;
    private int age;

    public Student(String name, int age) {
        this.id = generateId();
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.id = generateId();
        this.name = name;
    }

    public Student() {
        this.id = generateId();
    }

    private String generateId() {
        return "202511039" + String.format("%03d", idCounter++);
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative.");
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void printInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Age: " + getAge());
    }
}