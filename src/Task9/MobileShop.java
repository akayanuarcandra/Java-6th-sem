package Task9;

public class MobileShop {
    private int cellphoneAmount;

    public MobileShop(int cellphoneAmount) {
        this.cellphoneAmount = cellphoneAmount;
    }

    public MobileShop() {
        this(0); // Default to 0 if no amount specified
    }

    void setCellphoneAmount(int cellphoneAmount) {
        this.cellphoneAmount = cellphoneAmount;
    }

    int getCellphoneAmount() {
        return cellphoneAmount;
    }

    class InnerPurchaseMoney {
        int moneyAmount;
        MobileShop mobileShop;

        InnerPurchaseMoney(int moneyAmount, MobileShop mobileShop) {
            this.moneyAmount = moneyAmount;
            this.mobileShop = mobileShop;
        }

        void buyCellphone() {
            if (moneyAmount >= 20000) {
                mobileShop.setCellphoneAmount(mobileShop.getCellphoneAmount() - 6);
                System.out.println("use " + moneyAmount + " to buy 6 cellphones");
                System.out.println("mobile shop has " + mobileShop.getCellphoneAmount() + " cellphones left");
            } else if (moneyAmount >= 10000) {
                mobileShop.setCellphoneAmount(mobileShop.getCellphoneAmount() - 3);
                System.out.println("use " + moneyAmount + " to buy 3 cellphones");
                System.out.println("mobile shop has " + mobileShop.getCellphoneAmount() + " cellphones left");
            } else if (moneyAmount >= 5000) {
                mobileShop.setCellphoneAmount(mobileShop.getCellphoneAmount() - 2);
                System.out.println("use " + moneyAmount + " to buy 2 cellphones");
                System.out.println("mobile shop has " + mobileShop.getCellphoneAmount() + " cellphones left");
            } else if (moneyAmount >= 2000) {
                mobileShop.setCellphoneAmount(mobileShop.getCellphoneAmount() - 1);
                System.out.println("use " + moneyAmount + " to buy 1 cellphone");
                System.out.println("mobile shop has " + mobileShop.getCellphoneAmount() + " cellphones left");
            } else {
                System.out.println("not enough money to buy cellphone");
            }
        }
    }
}