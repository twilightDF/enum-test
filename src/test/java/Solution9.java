import org.junit.Test;

public class Solution9 {
    @Test
    public void test01(){
        String haystack = "legalization";
        String needle = "gal";
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
