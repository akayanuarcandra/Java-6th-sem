package Task6;

public class Rainfall {
    private final double[] rainfallData;
    private final int numberOfMonths;

    public Rainfall(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
        this.rainfallData = new double[numberOfMonths];
    }

    public void setRainfall(int month, double amount) {
        rainfallData[month - 1] = amount;
    }

    public double getTotalRainfall() {
        double total = 0;
        for (double amount : rainfallData) {
            total += amount;
        }
        return total;
    }

    public double getAverageMonthlyRainfall() {
        return getTotalRainfall() / numberOfMonths;
    }
}
