package Task6;

public class RainfallMonths {
    private final double[] rainfallData;
    private final int numberOfMonths;
    public String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public RainfallMonths() {
        this.numberOfMonths = months.length;
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