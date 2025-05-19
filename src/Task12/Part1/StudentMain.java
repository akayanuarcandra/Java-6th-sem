package Task12.Part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner; // For safe removal from ArrayList

public class StudentMain {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in); // For user input

        // (1) Read student information from file list.txt
        loadStudentsFromFile("Task12/Part1/list.txt", studentList);
        System.out.println("--- Students loaded from file ---");
        printAllStudents(studentList);

        // (2) Compute the average age of students
        if (!studentList.isEmpty()) {
            double averageAge = calculateAverageAge(studentList);
            System.out.printf("\n(2) Average age of students: %.2f\n", averageAge);
        } else {
            System.out.println("\n(2) No students to calculate average age.");
        }

        // (3) Display the names of the oldest student and the youngest student
        if (!studentList.isEmpty()) {
            findOldestAndYoungest(studentList);
        } else {
            System.out.println("\n(3) No students to find oldest or youngest.");
        }

        // (4) Print out the names of those who are over 20 years old
        System.out.println("\n(4) Students over 20 years old:");
        printStudentsOverAge(studentList, 20);

        // (5) Given the name, search particular student in the List.
        System.out.println("\n(5) Searching for student 'James':");
        searchStudentByName(studentList, "James");
        System.out.println("Searching for student 'Nobody':");
        searchStudentByName(studentList, "Nobody");


        // (6) Enter a name and search it the List. If it finds the name, remove the student object.
        System.out.println("\n(6) Remove student:");
        System.out.print("Enter name of student to remove: ");
        String nameToRemove = scanner.nextLine();
        removeStudentByName(studentList, nameToRemove);
        System.out.println("--- Student list after removal attempt ---");
        printAllStudents(studentList);

        System.out.println("\n(7) Replace student:");
        System.out.print("Enter name of student to replace: ");
        String nameToReplace = scanner.nextLine();
        replaceStudentByName(studentList, nameToReplace, scanner);
        System.out.println("--- Student list after replacement attempt ---");
        printAllStudents(studentList);

        saveStudentsToFile("Task12/Part1/info.txt", studentList);
        System.out.println("\n(8) Student information saved to info.txt");

        scanner.close();
    }

    public static void printAllStudents(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        for (Student student : list) {
            student.printInfo();
        }
    }

    public static void loadStudentsFromFile(String filename, ArrayList<Student> list) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String name = parts[0];
                    String email = parts[1];
                    try {
                        int age = Integer.parseInt(parts[2]);
                        list.add(new Student(name, email, age));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid age in line: " + line);
                    }
                } else {
                    System.err.println("Skipping invalid line format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filename);
        }
    }

    public static double calculateAverageAge(ArrayList<Student> list) {
        if (list.isEmpty()) {
            return 0.0;
        }
        double sumOfAges = 0;
        for (Student student : list) {
            sumOfAges += student.getAge();
        }
        return sumOfAges / list.size();
    }

    public static void findOldestAndYoungest(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("Cannot find oldest/youngest in an empty list.");
            return;
        }
        Student oldestStudent = list.get(0);
        Student youngestStudent = list.get(0);

        for (Student student : list) {
            if (student.getAge() > oldestStudent.getAge()) {
                oldestStudent = student;
            }
            if (student.getAge() < youngestStudent.getAge()) {
                youngestStudent = student;
            }
        }
        System.out.println("(3) Oldest student: " + oldestStudent.getName() + " (Age: " + oldestStudent.getAge() + ")");
        System.out.println("(3) Youngest student: " + youngestStudent.getName() + " (Age: " + youngestStudent.getAge() + ")");
    }

    public static void printStudentsOverAge(ArrayList<Student> list, int ageThreshold) {
        boolean found = false;
        for (Student student : list) {
            if (student.getAge() > ageThreshold) {
                System.out.println("- " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found over " + ageThreshold + " years old.");
        }
    }

    public static void searchStudentByName(ArrayList<Student> list, String name) {
        boolean found = false;
        for (Student student : list) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.print("Found student: ");
                student.printInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with name '" + name + "' not found.");
        }
    }

    public static void removeStudentByName(ArrayList<Student> list, String name) {
        Iterator<Student> iterator = list.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Delete successfully!");
                removed = true;
                break; // Assuming only one student with this name, or remove first occurrence
            }
        }
        if (!removed) {
            System.out.println("Can't find the name '" + name + "' to remove!");
        }
    }

    // (7) Replace student by name
    public static void replaceStudentByName(ArrayList<Student> list, String nameToFind, Scanner consoleScanner) {
        int indexToReplace = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(nameToFind)) {
                indexToReplace = i;
                break;
            }
        }

        if (indexToReplace != -1) {
            System.out.println("Enter new information for student '" + nameToFind + "':");
            System.out.print("Enter new name: ");
            String newName = consoleScanner.nextLine();
            System.out.print("Enter new age: ");
            int newAge = -1;
            while (newAge < 0) { // Basic age validation
                try {
                    newAge = Integer.parseInt(consoleScanner.nextLine());
                    if (newAge < 0) System.out.println("Age cannot be negative. Try again:");
                } catch (NumberFormatException e) {
                    System.out.print("Invalid age format. Please enter an integer: ");
                }
            }
            System.out.print("Enter new email: ");
            String newEmail = consoleScanner.nextLine();

            Student newStudent = new Student(newName, newEmail, newAge);
            list.set(indexToReplace, newStudent);
            System.out.println("Replace successfully!");
        } else {
            System.out.println("Can't find the name '" + nameToFind + "' to replace!");
        }
    }

    // (8) Save student information to file
    public static void saveStudentsToFile(String filename, ArrayList<Student> list) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (Student student : list) {
                writer.println("Name: " + student.getName() +
                               " Email: " + student.getEmail() +
                               " Age: " + student.getAge());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not write to file - " + filename);
        }
    }
}