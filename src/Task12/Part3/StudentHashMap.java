package Task12.Part3;

import java.util.HashMap;
import java.util.Scanner;

public class StudentHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a HashMap to store student information
        HashMap<String, String> studentMap = new HashMap<String, String>();
        
        // Add some students to the HashMap
        studentMap.put("st001", "Tom");
        studentMap.put("st005", "Alice");
        studentMap.put("st003", "James");
        studentMap.put("st014", "Bob");
        studentMap.put("st025", "John");

        System.out.println("-- Student HashMap --");
        for (String key : studentMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + studentMap.get(key));
        }
        
        System.out.println("-- Remove a Student --");
        System.out.print("Enter a student ID for removal: ");
        String studentRemove = scanner.nextLine();
        
        // Check if the student ID exists in the HashMap
        if (studentMap.containsKey(studentRemove)) {
            studentMap.remove(studentRemove);
            System.out.println("Student with ID " + studentRemove + " has been removed.");
        } else {
            System.out.println("Student with ID " + studentRemove + " does not exist.");
        }

        System.out.println("-- Updated Student HashMap --");
        for (String key : studentMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + studentMap.get(key));
        }
    }
}
