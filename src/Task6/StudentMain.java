package Task6;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Student Management System");
        System.out.println("=======================================");
        System.out.print("Please enter the number of students you want to manage: ");
        int numberOfStudents = scanner.nextInt();
        StudentData studentData = new StudentData(numberOfStudents);
        System.out.println("=======================================");

        int menu = 0;
        while (menu != 7) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Compute Average Age");
            System.out.println("4. Display Oldest and Youngest Students");
            System.out.println("5. Found Student Older than Determined Age");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Exit");
            System.out.print("Select Menu: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
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
                        System.out.println("-------------------");
                    }
                    break;
                case 2:
                    studentData.displayStudents();
                    break;
                case 3:
                    studentData.countAverageAge();
                    break;
                case 4:
                    studentData.displayOldestStudent();
                    studentData.displayYoungestStudent();
                    break;
                case 5:
                    System.out.print("Enter the age to compare: ");
                    int compareAge = scanner.nextInt();
                    studentData.foundStudentOlderThan(compareAge);
                    break;
                case 6:
                    System.out.print("Enter the name of the student to search: ");
                    String searchNameForSearch = scanner.next();
                    studentData.searchStudentName(searchNameForSearch);
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}