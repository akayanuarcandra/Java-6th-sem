package Task8;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student [] students = new Student[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("==========================");
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student email: ");
            String email = scanner.nextLine();
            System.out.print("Enter student age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            students[i] = new Student(name, email, age);
        }
        System.out.println("===========================");

        int result = students[0].compareTo(students[1]);
        if (result == 0) {
            System.out.println("Both students are of the same age.");
        } else if (result < 0) {
            System.out.println(students[0].getName() + " is younger than " + students[1].getName());
        } else {
            System.out.println(students[0].getName() + " is older than " + students[1].getName());
        }
    }
}
