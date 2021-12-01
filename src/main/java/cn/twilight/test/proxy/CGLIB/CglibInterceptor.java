package cn.twilight.test.proxy.CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {

    private DemoCglibTarget target;

    public CglibInterceptor(DemoCglibTarget target){
        this.target = target;
    }

    //实例工厂
    public Object getProxy(){
        //通过enhancer对象的create方法可以生成代理对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置拦截器 用于增强行为
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("增强行为------方法前");
        Object invoke = methodProxy.invoke(target, objects);
        System.out.println("增强行为------方法后");
        return invoke;
    }


}
