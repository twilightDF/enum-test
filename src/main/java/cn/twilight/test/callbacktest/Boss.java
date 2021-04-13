package cn.twilight.test.callbacktest;

public class Boss implements CallBack{
    //老板的司机
    private Driver driver;
    Boss(Driver driver){
        this.driver = driver;
    }
    //老板通过此方法命令司机去修车
    public void orderFix(){
        System.out.println("老板吩咐司机去修车");
        //新建一个线程,调用司机修车方法
        //新建一个线程的目的,不干扰老板的线程,老板吩咐后还要做自己的事
        new Thread(() -> driver.fixCar(this)).start();
    }

    /**
     * 这是回调方法属于老板
     * 司机修完车会回调这个方法
     * @param str
     */
    public void report(String str) {
        System.out.println(str);
    }

    public void doOther(){
        System.out.println("老板去做其他事!");
    }
}
