package cn.twilight.test.java8test;
@FunctionalInterface
public interface ImTheTwo<T> {
    String handleString(T t,String a);
}

class TwoClass{
    String oneString ;

    public String concatString(String a ){
        return this.oneString + a;
    }

    public String startHandleString(ImTheTwo<TwoClass> imTheTwo,String str){
        return imTheTwo.handleString(this,str);
    }
}

class Test{
    public static void main(String[] args) {
        TwoClass twoClass = new TwoClass();
        twoClass.oneString = "abc";
        String result = twoClass.startHandleString(TwoClass::concatString, "123");
        System.out.println(result);

        //相当于以下效果
        TwoClass twoClass2 = new TwoClass();
        twoClass2.oneString = "abc";
        ImTheTwo theOne2 = (a, b) -> twoClass2.concatString(b);
        String result2 = theOne2.handleString(theOne2, "123");
        System.out.println(result2);

    }
}