package Task12.Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class StudentMain {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in); // For user input

        // (1) Read student information from file list.txt
        loadStudentsFromFile("Task12/Part2/list.txt", studentList);
        System.out.println("--- Students loaded from file ---");
        printAllStudents(studentList);

        // (2) Sort the list using collection sort
        // Sort students by age using a Comparator
        Collections.sort(studentList, (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println("\n--- Students sorted by age ---");
        printAllStudents(studentList);


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
}