import org.junit.Test;
//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "Hello World"
//输出：5
//
//
// 示例 2：
//
//
//输入：s = " "
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅有英文字母和空格 ' ' 组成
//
// Related Topics 字符串
// 👍 329 👎 0
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
