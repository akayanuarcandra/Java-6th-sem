package Task11;

public class StudentMain {
    public static void main(String[] args) {
        Student student = new Student();
        
        System.out.println("Reading student information:");
        student.read();
        
        System.out.println("\nWriting formatted student information:");
        student.write();
    }
}