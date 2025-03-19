package Task3;
import java.util.Scanner;

public class TransformScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter your score: ");
                int score = scanner.nextInt();
                if (score >= 90) {
                    System.out.println("A");
                } else {
                    if (score >= 80) {
                        System.out.println("B");
                    } else {
                        if (score >= 70) {
                            System.out.println("C");
                        } else {
                            if (score >= 60) {
                                System.out.println("D");
                            } else {
                                System.out.println("F");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}