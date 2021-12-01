package cn.twilight.test.proxy;

import cn.twilight.test.proxy.CGLIB.CglibInterceptor;
import cn.twilight.test.proxy.CGLIB.DemoCglibTarget;
import cn.twilight.test.proxy.javaAPI.DemoDynamicHandler;
import cn.twilight.test.proxy.javaAPI.DemoImpl;
import cn.twilight.test.proxy.javaAPI.DemoInterface;
import cn.twilight.test.proxy.javaAPI.DemoStaticProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void javaApiTest(){
        //静态代理
        DemoStaticProxy demoStaticProxy = new DemoStaticProxy(new DemoImpl());
        demoStaticProxy.handle();
        System.out.println("***********************");
        //动态代理
        final DemoImpl demo = new DemoImpl();/*在此传入的目标对象为DemoImpl，也可以根据需要传入其他的目标对象，
                                                                   即可生成不同类的代理，此处也是动态代理的优势！！*/
         /*  newProxyInstance   方法的参数
          *  ClassLoader        类加载器，同于加载被代理对象字节码
          *  Class[]            字节码数组---用于让代理对象和被代理对象拥有相同的方法
          *  InvocationHandler  用于提供被增强的代码
        */
        DemoInterface o = (DemoInterface)Proxy.newProxyInstance(demo.getClass().getClassLoader(),
                                          demo.getClass().getInterfaces(),
                                          new DemoDynamicHandler(demo));
        o.handle();
        //o.privateMethod(); 无法调用

        //TODO 优化  可以生成工厂类直接获取代理对象实例
    }

    @Test
    public void CGlibTest(){
        DemoCglibTarget target = new DemoCglibTarget();
        CglibInterceptor cglibInterceptor = new CglibInterceptor(target);
        DemoCglibTarget proxy = (DemoCglibTarget)cglibInterceptor.getProxy();
        proxy.handle();
    }
}
