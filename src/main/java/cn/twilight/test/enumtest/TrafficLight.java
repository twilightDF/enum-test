package cn.twilight.test.enumtest;

/**
 *  switch支持enum类型
 */
enum Single{
    RED,YELLOW,GREEN
}
public class TrafficLight {
    Single color = Single.RED;

    public void change(){
        switch(color){

            case RED:
                color = Single.GREEN;
                break;
            case GREEN:
                color = Single.YELLOW;
                break;
            case YELLOW:
                color = Single.RED;
                break;
        }
        System.out.println(color);
    }

    public static void main(String[] args) {
        new TrafficLight().change();
    }
}

