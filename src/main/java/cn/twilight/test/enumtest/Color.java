package cn.twilight.test.enumtest;


/**
 * 常量
 */
public enum Color {
    RED,GREEN,BLACK,YELLOW
}

/**
 * 向枚举中添加新方法
 */
enum Color2{
    RED("红色",1),GREEN("绿色",2),YELLOW("黄色",3);

    private String name;
    private int index;

    Color2() {
    }

    Color2(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    //根据传入的方法返回对应的颜色
    public static String returnColor(int index){
        for(Color2 c : Color2.values()){
            if(c.index == index)
                return c.name;
        }
        throw new UnsupportedOperationException("未识别的index");
    }

    public static void main(String[] args) {
        System.out.println(Color2.returnColor(2));
    }
}
