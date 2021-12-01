package cn.twilight.test.proxy.javaAPI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DemoDynamicHandler implements InvocationHandler {

    private DemoInterface demo;

    public DemoDynamicHandler(DemoInterface demo){
        this.demo = demo;
    }

    /**
     *
     * @param proxy   委托类对象引用
     * @param method  当前执行的方法
     * @param args     当前执行的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用了动态代理的增强方法");
        Object invoke = method.invoke(demo, args);
        System.out.println("调用完了委托类，有回到了动态代理增强方法");
        return invoke;
    }
}
