package Task7;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[4];

        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter student type (U for Undergraduate, G for Graduate): ");
            char type = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            if (type == 'U') {
                students[i] = new UndergraduateStudent();
                System.out.print("Enter major: ");
                String major = scanner.nextLine();
                ((UndergraduateStudent) students[i]).setMajor(major);
            } else if (type == 'G') {
                students[i] = new GraduateStudent();
                System.out.print("Enter supervisor: ");
                String supervisor = scanner.nextLine();
                ((GraduateStudent) students[i]).setSupervisor(supervisor);
            } else {
                System.out.print("Invalid student type. Defaulting to UndergraduateStudent.");
                students[i] = new UndergraduateStudent();
            }

            students[i].setName(name);
            for (int j = 1; j <= students[i].NumberOfTest; j++) {
                System.out.print("Enter score for test " + j + ": ");
                int score = scanner.nextInt();
                students[i].setTestScore(j, score);
            }
            students[i].getAverageScore();
            students[i].computeCourseGrade();
            students[i].displayInfo();
            System.out.println("==========================");
        }

        // Count the number of UndergraduateStudent objects
        int undergraduateCount = 0;
        int graduateCount = 0;
        for (Student student : students) {
            if (student instanceof UndergraduateStudent) {
                undergraduateCount++;
            } else if (student instanceof GraduateStudent) {
                graduateCount++;
            } else {
                System.out.println("Unknown student type.");
            }
        }

        System.out.println("Number of undergraduate students: " + undergraduateCount);
        System.out.println("Number of graduate students: " + graduateCount);
        scanner.close();
    }
}