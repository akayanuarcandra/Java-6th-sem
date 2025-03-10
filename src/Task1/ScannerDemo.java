package Task1;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your student ID");
        int ID = scanner.nextInt();
        System.out.println("My name is " + name);
        System.out.println("My student ID is " + ID);
        scanner.close();
    }
}
