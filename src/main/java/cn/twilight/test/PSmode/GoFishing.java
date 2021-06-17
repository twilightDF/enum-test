package cn.twilight.test.PSmode;

/**
 * 模拟发布-订阅模式
 *
 * 垂钓者 - 订阅者,观察鱼竿发生变化后采取动作
 * 鱼竿 - 发布者,有鱼上钩发出变化
 */
public class GoFishing {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("简单实现的观察者模式：");
        System.out.println("=======================");

        //1.初始化鱼竿(被观察者)
        FishingRod fishingRod = new FishingRod();
        //2.声明垂钓者(观察者)
        FishMan fishMan = new FishMan("张三");
        //3.垂钓者观察鱼竿
        fishingRod.addSubscriber(fishMan);

        //4.循环钓鱼
        while(fishMan.getFishCount() < 5){
            fishingRod.Fishing();
            System.out.println("-------------------");
            //睡眠5s
            Thread.sleep(2000);
        }
    }
}
