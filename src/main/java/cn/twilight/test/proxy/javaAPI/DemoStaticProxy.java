package cn.twilight.test.proxy.javaAPI;

/**
 * 静态代理类
 */
public class DemoStaticProxy implements DemoInterface{

    private DemoInterface demo;

    public DemoStaticProxy(final DemoInterface demo){
        this.demo = demo;
    }

    @Override
    public void handle() {
        System.out.println("进入了静态代理类");
        demo.handle();
        System.out.println("委托类调用完成，又进入了静态代理类");
    }
}
