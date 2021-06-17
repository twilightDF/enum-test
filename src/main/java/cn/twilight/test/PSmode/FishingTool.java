package cn.twilight.test.PSmode;

import java.util.ArrayList;
import java.util.List;

/**
 * 发布者抽象类,所有发布者需要继承该类,并实现update方法
 */
public abstract class FishingTool {
    /**
     * 维护订阅者列表,并通知订阅者
     */
    private List<Subscriber> _subscribers;
    protected FishingTool()
    {
        _subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber)
    {
        if (!_subscribers.contains(subscriber))
            _subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber)
    {
        if (_subscribers.contains(subscriber))
            _subscribers.remove(subscriber);
    }

    public void notify(FishType type)
    {
        for (Subscriber subscriber : _subscribers)
            subscriber.update(type);
    }
}
