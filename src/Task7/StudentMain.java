package Task7;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];

        students[0] = new GraduateStudent();
        students[0].setName("Tom");
        students[1] = new UndergraduateStudent();
        students[1].setName("Alice");
        students[2] = new UndergraduateStudent();
        students[2].setName("James");

        for (Student student : students) {
            System.out.println("==========================");
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter " + student.getName() + " score for test " + (i + 1) + ": ");
                int score = scanner.nextInt();
                student.setTestScore(i, score);
            }
            student.computeCourseGrade();
            System.out.println("Average score for " + student.getName() + ": " + student.getAverageScore());
            System.out.println("Course grade for " + student.getName() + ": " + student.getCourseGrade());
        }
    }
}
