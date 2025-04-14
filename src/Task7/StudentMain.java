package Task7;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];
        students[0] = new GraduateStudent();
        students[0].setName("Tom");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter " + students[0].getName() + " score for test " + (i + 1) + ": ");
            int score = scanner.nextInt();
            students[0].setTestScore(i, score);
        }
        students[0].computeCourseGrade();
        System.out.println("Average score for " + students[0].getName() + ": " + students[0].getAverageScore());
        System.out.println("Course grade for " + students[0].getName() + ": " + students[0].getCourseGrade());
        System.out.println("==========================");

        students[1] = new UndergraduateStudent();
        students[1].setName("Alice");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter " + students[1].getName() + " score for test " + (i + 1) + ": ");
            int score = scanner.nextInt();
            students[1].setTestScore(i, score);
        }
        students[1].computeCourseGrade();
        System.out.println("Average score for " + students[1].getName() + ": " + students[1].getAverageScore());
        System.out.println("Course grade for " + students[1].getName() + ": " + students[1].getCourseGrade());
        System.out.println("==========================");

        students[2] = new UndergraduateStudent();
        students[2].setName("James");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter " + students[2].getName() + " score for test " + (i + 1) + ": ");
            int score = scanner.nextInt();
            students[2].setTestScore(i, score);
        }
        students[2].computeCourseGrade();
        System.out.println("Average score for " + students[2].getName() + ": " + students[2].getAverageScore());
        System.out.println("Course grade for " + students[2].getName() + ": " + students[2].getCourseGrade());
    }
}
