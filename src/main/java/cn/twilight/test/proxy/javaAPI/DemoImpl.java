package cn.twilight.test.proxy.javaAPI;

/**
 * 委托类，实现了DemoInterface接口
 */
public class DemoImpl implements DemoInterface {
    @Override
    public void handle() {
        System.out.println("调用了委托类");
    }

    private void privateMethod(){
        System.out.println("DemoImpl的私有方法，通过java原生API生成的代理对象无法调用");
    }
}
