package Task4;

import java.util.Scanner;

public class NameDivider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your full name: ");
        String fullName = scanner.nextLine();

        String[] names = fullName.split(" ");
        int stringSize = names[1].length();

        System.out.println("Your first name is: " + names[0]);
        System.out.println("Your last name is: " + names[1]);
        System.out.println("Your last name has " + stringSize + " characters");
    }
}
