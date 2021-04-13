package cn.twilight.test.callbacktest;

public class Driver {
    /**
     * 司机修车方法
     * @param callBack
     * 回调接口作为参数,为了完成修车后,给老板法报告
     */
    public void fixCar(CallBack callBack){
        try {
            //线程休眠,模拟修车过程
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //修好车,调用回调方法
        callBack.report("司机报告:车已经修好了!");
    }
}
