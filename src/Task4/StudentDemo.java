package Task4;

public class StudentDemo {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setID(1);
        student1.setName("John Doe");
        student1.setGender(Student.Gender.MALE);
        student1.setPhone(1234567890);

        student2.setID(2);
        student2.setName("Jane Doe");
        student2.setGender(Student.Gender.FEMALE);
        student2.setPhone(1234543210);

        student1.printInfo();
        student2.printInfo();
    }
}
