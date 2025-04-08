package Task6;

import java.util.Scanner;

public class RainfallMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rainfall rainfall = new Rainfall(12);

        for (int i = 0; i < 12; i++) {
                System.out.print("Enter rainfall for month " + (i + 1) + ": ");
            double amount = sc.nextDouble();
            rainfall.setRainfall(i + 1, amount);
        }

        System.out.println("Total Rainfall: " + rainfall.getTotalRainfall());
        System.out.println("Average Monthly Rainfall: " + rainfall.getAverageMonthlyRainfall());
    }
}
