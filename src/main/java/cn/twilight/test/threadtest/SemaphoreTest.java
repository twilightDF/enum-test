package cn.twilight.test.threadtest;

import java.util.concurrent.Semaphore;

/**
 * 实现业务A、B、C线程并发。 某个时段B、C线程等待A线程结束后继续运行
 *
 * 使用Semaphore，Semaphore通过permits来控制线程的启动和停止
 * 线程从semaphore中获取permits，若permits不为空，则继续线程，若为空则调用release()释放permits
 */
public class SemaphoreTest {
    private static int num;//模拟公共资源
    public static Semaphore semaphore = new Semaphore(0);
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //模拟耗时操作之后初始化变量 num
                    Thread.sleep(2000);
                    num = 1;
                    semaphore.release(2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("B线程等待A之前执行的工作");
                    semaphore.acquire();
                    System.out.println("B线程等待之后执行的工作");
                    System.out.println(Thread.currentThread().getName() + "获取到的num值为:" + num);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("C线程等待A之前执行的工作");
                    semaphore.acquire();
                    System.out.println("C线程等待之后执行的工作");
                    System.out.println(Thread.currentThread().getName() + "获取到的num值为:" + num);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
