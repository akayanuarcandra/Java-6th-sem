package Task5;

public class StudentMain {
    public static void main(String[] args) {
        Student s1 = new Student("Tom");
        s1.setAge(23);
        s1.setEmail("tom@gmail.com");
        Student s2 = new Student("Brown", 26);
        s2.setEmail("brown@gmail.com");
        Student s3 = new Student();
        s3.setName("Rose");
        s3.setAge(22);
        s3.setEmail("rose@gmail.com");
        s1.printInfo();
        System.out.println("=======================================");
        s2.printInfo();
        System.out.println("=======================================");
        s3.printInfo();    }
}
