package Task5;

import java.util.Scanner;

public class TemperatureTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();
        Temperature temp = new Temperature(celsius);
        System.out.println("Temperature in Fahrenheit: " + temp.toFahrenheit(celsius));

        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();
        Temperature temp2 = new Temperature(fahrenheit);
        System.out.println("Temperature in Celsius: " + temp.toCelsius(fahrenheit));

        System.out.println("=======================================");
        System.out.println("Temperature 1 in Celsius: " + temp.getCelsius() + "°C");
        System.out.println("Temperature 1 in Fahrenheit: " + temp.toFahrenheit(celsius) + "°F");
        System.out.println("=======================================");
        System.out.println("Temperature 2 in Celsius: " + temp2.getFahrenheit() + "°C");
        System.out.println("Temperature 2 in Fahrenheit: " + temp2.toCelsius(fahrenheit) + "°F");
    }
}
