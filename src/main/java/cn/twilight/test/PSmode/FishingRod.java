package cn.twilight.test.PSmode;

import java.util.Random;

//鱼竿,模拟一个消息的发布者,当由于上钩,者发布消息
public class FishingRod extends FishingTool {
    public void Fishing() {

        System.out.println("开始下钩！");

        //用随机数模拟鱼咬钩，若随机数为偶数，则为鱼咬钩
        int type1 = new Random().nextInt(6);
        FishType type = FishType.getType(type1);
        System.out.println("铃铛：叮叮叮，鱼儿咬钩了");
        notify(type);
    }
}
