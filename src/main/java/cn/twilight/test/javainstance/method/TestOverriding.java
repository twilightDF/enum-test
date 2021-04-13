package cn.twilight.test.javainstance.method;

/**
 * 测试方法覆盖
 */
public class TestOverriding {
    public static void main(String[] args) {
        Father man = new Son(11,"我是儿子");
        man.speak();
        System.out.println(man.toString());
    }

}

class Father{

    int age;
    String name;
    Father(){}
    Father(int age,String name){
        this.age = age;
        this.name = name;
    }
    public void speak(){
        System.out.println("父亲在说话");
    }

    @Override
    public String toString() {
        return "Father{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Son extends Father{
    Son(){}
    Son(int age, String name) {
        super(age, name);
    }

    @Override
    public void speak() {
        System.out.println("儿子在说话");
    }

    @Override
    public String toString() {
        return "Son{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
