package Task5;

public class Temperature {
    private double celsius;
    private double fahrenheit;

    public Temperature(double value) {
        this.celsius = value;
        this.fahrenheit = value;
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double toFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}