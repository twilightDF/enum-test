package cn.twilight.test.PSmode;

//订阅者接口,所有订阅者(垂钓者),都要实现该接口
public interface Subscriber {
    //该方法为接到消息的处理方法
    void update(FishType type);
}
