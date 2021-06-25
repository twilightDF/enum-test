//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3669 👎 0

import org.junit.Test;

//寻找最长回文
public class Solution {

    @Test
    public void test02(){
        String str = "aba";
//        String palindrome = getPalindrome(str);
        System.out.println(str);
    }

    public String getPalindrome(String str){
        int max = 0;
        int flag = 0;
        int size = str.length();
        char[] chars = str.toCharArray();
        if(size == 1){
            return str;
        }else if (size == 2){
            if(chars[0] == chars[1]){
                return str;
            }else {
                return "无回文字符串";
            }
        }else if(size != 0&&!"".equals(str)){
            for (int i = 1;i<size;i++){
                for (int a = 1;a < i; a++){
                    if (chars[i-a] == chars[i+a]){
                        max++;
                    }
                }
            }
            return "TODO!";
        }else {return "错误!";}
    }

    @Test
    public void test01(){
            long begin = System.currentTimeMillis();
            System.out.println(fib2(40));
            long end = System.currentTimeMillis();
            System.out.println("用了 : " + (end - begin));
        }
        //原始方法
    public int fib(int n){
            //1,1,2,3,5,8,13,21,34,....   893ms
            //斐波那契数组
            if(n <= 0)return 0;
            if(n == 1)return 1;
            return fib(n-1) + fib(n-2);
            //这种递归算法可以看到算了n-1次fib(2),浪费了时间
        }
        //自顶向下备忘录法 -- 将计算过的值存入数组中
    public int fib2(int n){//0
            if(n <= 0)return 0;
            int[] memo = new int[n+1];
            for (int i = 0; i <= n ; i++)
                memo[i] = -1;
            return fib3(memo,n);

        }
        public int fib3(int[] memo,int n){
            //如果memo中以及有斐波那契第n位的话就直接返回它
            if(memo[n] != -1)
                return memo[n];
            //否则进行计算
            if(n <= 2)
                memo[n] = 1;
            else memo[n] = fib3(memo, n-1) + fib3(memo, n-2);
            return memo[n];
        }
        //虽然备忘录法减少了计算次数,但是依然使用了递归,在基数过于庞大的情况下,依然会消耗大量的内存
        //所以采用 -- 自低向下的动态规划 先计算子问题,再通过子问题计算父问题
        public int fib4(int n){
            if(n <= 0)
                return n;
            int[] memo = new int[n+1];
            memo[0] = 0;
            memo[1] = 1;
            for(int i = 2;i <= n; i++){
                memo[i] = memo[i-1] + memo[i-2];
            }
            return memo[n];
        }
    }
