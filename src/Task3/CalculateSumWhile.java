package Task3;

public class CalculateSumWhile {
    public static void main(String[] args) {
        int sum = 0;
        int sum2 = 0;
        int i = 1;
        while (i <= 1000) {
            if (i % 2 == 0) {
                sum += i;
            } else {
                sum2 += i;
            }
            i++;
        }
        System.out.println("The sum of the even 1000 numbers is: " + sum);
        System.out.println("The sum of the odd 1000 numbers is: " + sum2);
    }
}
