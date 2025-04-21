package Task8;

public class Student implements Comparable<Student> {
    private String name;
    private String email;
    private int age;

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getName() {
        return name;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public String getEmail() {
        return email;
    }

    public int setAge(int age) {
        this.age = age;
        return age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
//        if (this.age < other.age) {
//            return -1;
//        } else if (this.age > other.age) {
//            return 1;
//        } else {
//            return 0;
//        }
//      these can be simplified apparently
        return Integer.compare(this.age, other.age);
    }
}
