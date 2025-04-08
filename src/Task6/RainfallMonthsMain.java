package Task6;

import java.util.Scanner;

public class RainfallMonthsMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RainfallMonths rainfall = new RainfallMonths();
        System.out.println("Enter rainfall for each month (1-12):");
        for (int i = 0; i < 12; i++) {
            System.out.print(rainfall.months[i] + ": ");
            double amount = sc.nextDouble();
            rainfall.setRainfall(i + 1, amount);
        }
        System.out.println("Total Rainfall: " + rainfall.getTotalRainfall());
        System.out.println("Average Monthly Rainfall: " + rainfall.getAverageMonthlyRainfall());
    }
}
