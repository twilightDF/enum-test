import org.junit.Test;

public class Solution4 {
    //输入：strs = ["flower","flow","flight"]
    //输出："fl"
    @Test
    public void test01(){
        String[] strs = {"abcdefg","abcde","abc","a"};

        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }


    public String longestCommonPrefix(String[] strs) {
        //思路,
        //1.获取第一个字符串的第一个字符
        //2.依次与第二个字符串的第一个字符,第三个字符串的第一个字符....作比较
        // *(比较完毕后,若flag为true,result拼接上次字符,否则直接返回)
        //3.获取第一个字符串的第二个字符
        //4.同步骤2,只是与每个字符串的第二个字符作比较
        //5.直到
        String result = "";
        char c;
        char b;
        boolean flag = false;
        char[] chars = strs[0].toCharArray();

        for (int i = 0; i < chars.length; i++) {
            c = chars[i];
            for (int j = 1; j < strs.length; j++) {
                try {
                    b = (strs[j].toCharArray())[i];
                }catch (Exception e){
                    return result;
                }
                if (c == b){
                    flag = true;
                }else
                    return result;
            }
            if (flag){
                result += c;
                flag = false;
            }
        }
        return result;
    }
}
