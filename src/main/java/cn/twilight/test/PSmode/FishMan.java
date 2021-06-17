package cn.twilight.test.PSmode;

import lombok.Getter;
import lombok.Setter;

//垂钓者,实现了观察者接口,实现对消息的处理方法update()
@Getter
@Setter
public class FishMan implements Subscriber {
    private String name;
    private int fishCount;

    public FishMan(String name){
        this.name = name;
    }
    @Override
    public void update(FishType type) {
        fishCount ++;
        System.out.println(name + ",钓到一条" + type + ",总计: " + fishCount + " 条鱼");
    }
}
