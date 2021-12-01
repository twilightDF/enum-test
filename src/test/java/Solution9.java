import org.junit.Test;
//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。
//
//
//
// 说明：
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
//
//
//
// 示例 1：
//
//
//输入：haystack = "hello", needle = "ll"
//输出：2
//
//
// 示例 2：
//
//
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
//
//
// 示例 3：
//
//
//输入：haystack = "", needle = ""
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= haystack.length, needle.length <= 5 * 104
// haystack 和 needle 仅由小写英文字符组成
//
// Related Topics 双指针 字符串 字符串匹配
// 👍 954 👎 0
public class Solution9 {
    @Test
    public void test01(){
        String haystack = "jkdajkdla";
        String needle = "da";

        System.out.println(haystack.indexOf(needle));
        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle) || ("".equals(needle)&&"".equals(haystack)) || haystack.equals(needle))return 0;
        if ("".equals(haystack) || haystack.length() < needle.length())return -1;

        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        int i = 0;
        int j = 0;

        while(i < nee.length){
            while(j < hay.length){
                if (hay[j] == nee[i]){
                    i++;
                    j++;
                    if (i == nee.length)break;
                }else {
                    i = 0;
                    j++;
                    if (j == hay.length)return -1;
                }
            }
        }
        return j-nee.length;
    }
}
