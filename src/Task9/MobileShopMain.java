package Task9;

import java.util.Scanner;

public class MobileShopMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cellphones in the shop: ");
        int cellphoneAmount = scanner.nextInt();
        MobileShop mobileShop = new MobileShop(cellphoneAmount);

        System.out.print("Enter the amount of first internal shopping money: ");
        int moneyAmount1 = scanner.nextInt();
        MobileShop.InnerPurchaseMoney purchaseMoney1 = mobileShop.new InnerPurchaseMoney(moneyAmount1, mobileShop);
        purchaseMoney1.buyCellphone();

        System.out.print("Enter the amount of second internal shopping money: ");
        int moneyAmount2 = scanner.nextInt();
        MobileShop.InnerPurchaseMoney purchaseMoney2 = mobileShop.new InnerPurchaseMoney(moneyAmount2, mobileShop);
        purchaseMoney2.buyCellphone();
    }
}