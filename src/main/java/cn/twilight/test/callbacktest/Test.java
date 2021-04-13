package cn.twilight.test.callbacktest;

public class Test {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Boss boss = new Boss(driver);

        boss.orderFix();
        boss.doOther();
    }
}
