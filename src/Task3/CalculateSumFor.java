package Task3;

public class CalculateSumFor {
    public static void main(String[] args) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 2 == 0) {
                sum += i;
            } else {
                sum2 += i;
            }
        }
        System.out.println("The sum of the even 1000 numbers is: " + sum);
        System.out.println("The sum of the odd 1000 numbers is: " + sum2);
    }
}
