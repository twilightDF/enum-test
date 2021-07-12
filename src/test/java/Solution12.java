import org.junit.Test;

public class Solution12 {
    @Test
    public void test01(){
        String s = "sjiadj djsaijdo djsia djsiaj";
        System.out.println(indexOfLastWord(s));
    }

    public int indexOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        for (;index > 0;index--){
            if (32 == chars[index]){
                return chars.length - index - 1;
            }else if(index == 1){
                return chars.length - index + 1;
            }
        }
        throw new UnsupportedOperationException("不支持的操作");
    }
}
