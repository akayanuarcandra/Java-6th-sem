package Task10;

import java.util.Scanner;

public class ScoreStatistics {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalStudents = 0;
            System.out.print("Enter the total number of students: ");
            totalStudents = Integer.parseInt(scanner.nextLine());
            if (totalStudents <= 0) {
                throw new IllegalArgumentException("Number of students must be greater than 0.");
            }
            System.out.println("============================");

            double[] averageScores = new double[totalStudents];
            for (int i = 0; i < totalStudents; i++) {
                System.out.print("Enter scores for student " + (i + 1) + " (comma-separated): ");
                String[] scoresInput = scanner.nextLine().split(",");
                int totalScore = 0;
                int numberOfScores = scoresInput.length;

                for (String score : scoresInput) {
                    try {
                        int parsedScore = Integer.parseInt(score.trim());
                        if (parsedScore > 100) {
                            throw new IllegalArgumentException("Score cannot be greater than 100.");
                        } else if (parsedScore < 0) {
                            throw new IllegalArgumentException("Score cannot be negative.");
                        }
                        totalScore += parsedScore;
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Invalid score input. Scores must be numerical.");
                    }
                }

                averageScores[i] = (double) totalScore / numberOfScores;
            }

            System.out.println("============================");
            System.out.println("\nScore Statistics:");
            for (int i = 0; i < totalStudents; i++) {
                System.out.printf("Student %d: Average Score = %.2f%n", (i + 1), averageScores[i]);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}