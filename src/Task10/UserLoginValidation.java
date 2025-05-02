package Task10;

import java.util.Scanner;

public class UserLoginValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctUsername = "";
        String correctPassword = "";

        try {
            System.out.println("============================");
            System.out.println("Create a new account");
            System.out.println("============================");
            System.out.print("Username: ");
            correctUsername = scanner.nextLine();
            if (correctUsername.isEmpty()) {
                throw new IllegalArgumentException("Username cannot be empty.");
            } else if (correctUsername.length() < 6 || correctUsername.length() > 10) {
                throw new IllegalArgumentException("Username must be between 6 and 10 characters.");
            }
            System.out.print("Password: ");
            correctPassword = scanner.nextLine();
            if (correctPassword.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty.");
            } else if (correctPassword.length() != 8) {
                throw new IllegalArgumentException("Password must be 8 characters.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return;
        }

        try {
            System.out.println("============================");
            System.out.println("Login to your account");
            System.out.println("============================");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.println("============================");
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username and password cannot be empty.");
            } else if (!username.equals(correctUsername) || !password.equals(correctPassword)) {
                throw new IllegalArgumentException("Invalid username or password.");
            }
            System.out.println("Login successful!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}