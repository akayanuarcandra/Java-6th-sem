package Task11.Part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    private String name;
    private String email;
    private int age;

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Student(String name) {
        this(name, "", 0);
    }

    public Student() {
        this("", "", 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Email: " + this.email + " Age: " + this.age;
    }

    public void readWrite() {
        try (BufferedReader br = new BufferedReader(new FileReader("Task11/list.txt"));
             FileWriter fw = new FileWriter("Task11/info.txt")) {
            
            String line;
            System.out.println("Reading and writing student information:");
    
            while ((line = br.readLine()) != null) {
                System.out.println("Original: " + line);
                
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    String name = parts[0];
                    String email = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    
                    String studentInfo = "Name: " + name + " Email: " + email + " Age: " + age + "\n";
                    fw.write(studentInfo);
                }
            }
            System.out.println("\nStudent information written to info.txt");
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }
}