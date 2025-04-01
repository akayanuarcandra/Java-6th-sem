package Task4;

import java.util.Scanner;

public class LoginTestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginTest loginTest = new LoginTest();

        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            boolean loginUsername = loginTest.loginUsername(username);

            if (loginUsername) {
                break;
            }

            if (loginTest.getRemainingAttempts() <= 0) {
                System.out.println("Fail Three Times, Refuse Service!");
                System.exit(0);
            }
        }

        while (true) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            boolean loginPassword = loginTest.loginPassword(password);

            if (loginPassword) {
                System.out.println("Login successful!");
                break;
            }

            if (loginTest.getRemainingAttempts() <= 0) {
                System.out.println("Fail Three Times, Refuse Service!");
                System.exit(0);
            }
        }

        scanner.close();
    }
}