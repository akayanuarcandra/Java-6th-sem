package Task6;

import java.util.Scanner;

public class StudentDeletionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        StudentData studentData = new StudentData(numStudents);
        for (int i = 0; i < numStudents; i++) {
            if (studentData.isFull()) {
                System.out.println("-------------------");
                System.out.println("The student array is full. Cannot add more students.");
                System.out.println("-------------------");
            } else {
                System.out.println("-------------------");
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                System.out.print("Enter email: ");
                String email = scanner.next();
                Student student = new Student(name, age, email);
                studentData.addStudent(student);
                System.out.println("-------------------");
                System.out.println("Student added successfully.");
            }
        }

        System.out.println("-------------------");
        System.out.print("Enter the name of the student to delete: ");
        String nameToDelete = scanner.next();
        studentData.deleteStudent(nameToDelete);
        System.out.println("Student list after deletion:");
        studentData.displayStudents();
    }
}
