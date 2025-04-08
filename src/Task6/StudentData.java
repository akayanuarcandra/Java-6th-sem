package Task6;

public class StudentData {
    private final Student[] students;
    private int studentCount;

    public StudentData(int capacity) {
        students = new Student[capacity];
        studentCount = 0;
    }

    public boolean isFull() {
        return studentCount >= students.length;
    }

    public void addStudent(Student student) {
        if (!isFull()) {
            students[studentCount++] = student;
        }
    }

    public void displayStudents() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println("-------------------");

            students[i].printInfo();
        }
        System.out.println("-------------------");
    }

    public void searchStudentName(String name) {
        boolean found = false;
        System.out.println("-------------------");
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Student found: " + students[i].getName() + ", Age: " + students[i].getAge());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        System.out.println("-------------------");
    }

    public void countAverageAge() {
        System.out.println("-------------------");
        if (studentCount == 0) {
            System.out.println("No students to calculate average age.");
            return;
        }
        int totalAge = 0;
        for (int i = 0; i < studentCount; i++) {
            totalAge += students[i].getAge();
        }
        double averageAge = (double) totalAge / studentCount;
        System.out.println("Average age of students: " + averageAge);
        System.out.println("-------------------");
    }

    public void displayOldestStudent() {
        System.out.println("-------------------");
        if (studentCount == 0) {
            System.out.println("No students to find the oldest.");
            return;
        }
        Student oldestStudent = students[0];
        for (int i = 1; i < studentCount; i++) {
            if (students[i].getAge() > oldestStudent.getAge()) {
                oldestStudent = students[i];
            }
        }
        System.out.println("Oldest student: " + oldestStudent.getName() + ", Age: " + oldestStudent.getAge());
        System.out.println("-------------------");
    }

    public void displayYoungestStudent() {
        if (studentCount == 0) {
            System.out.println("No students to find the youngest.");
            return;
        }
        Student youngestStudent = students[0];
        for (int i = 1; i < studentCount; i++) {
            if (students[i].getAge() < youngestStudent.getAge()) {
                youngestStudent = students[i];
            }
        }
        System.out.println("Youngest student: " + youngestStudent.getName() + ", Age: " + youngestStudent.getAge());
        System.out.println("-------------------");
    }

    public void foundStudentOlderThan(int age) {
        System.out.println("-------------------");
        boolean found = false;
        System.out.println("Student older than " + age + ": ");
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getAge() > age) {
                System.out.println(students[i].getName() + ", Age: " + students[i].getAge());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students older than " + age);
        }
        System.out.println("-------------------");
    }
}