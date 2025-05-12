package Task11.Part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
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

    public void write() {
        String inputFileName = "Task11/Part2/list.txt";
        String outputFileName = "Task11/Part2/student.data";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFileName))) {

            List<Student> students = new ArrayList<>();
            String line;

            System.out.println("Reading list.txt:");

            while ((line = br.readLine()) != null) {
                System.out.println("Original: " + line);

                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    String name = parts[0];
                    String email = parts[1];
                    int age = Integer.parseInt(parts[2]);

                    students.add(new Student(name, email, age));
                }
            }
            oos.writeObject(students);
            System.out.println("\nStudent information written to student.data");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public void read() {
        String inputFileName = "Task11/Part2/student.data";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFileName))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> rawList = (List<?>) obj;
                List<Student> students = new ArrayList<>();
                for (Object item : rawList) {
                    if (item instanceof Student) {
                        students.add((Student) item);
                    } else {
                        System.err.println("Invalid object in the list: " + item);
                    }
                }
                System.out.println("Reading student.data:");
                for (Student student : students) {
                    System.out.println(student);
                }
            } else {
                System.err.println("Deserialized object is not a List.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}