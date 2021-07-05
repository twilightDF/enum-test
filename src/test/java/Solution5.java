import org.junit.Test;

import java.util.Stack;

public class Solution5 {

    @Test
    public void test01(){
        String s = "(){[()()]}([])";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        stack.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            try{
                if (
                    stack.peek().equals('(')&&chars[i]==')' ||
                    stack.peek().equals('[')&&chars[i]==']' ||
                    stack.peek().equals('{')&&chars[i]=='}'
                ){
                    stack.pop();
                }else {
                 stack.push(chars[i]);
                }
            }catch (Exception e){
                stack.push(chars[i]);
            }
        }
        return stack.empty();
    }
}
