import org.junit.Test;

public class Solution11 {
    @Test
    public void test01(){
        int[] ints = {1,-3,2,3,-2,-3,4,5,6,-7};
        System.out.println(maxSubArray(ints));
    }

    /*
    暴力获取子序和
     */
    public int maxSubArray(int[] nums) {
        int max = 0;
        for (int i = 0;i<nums.length;i++){
            int temp = nums[i];
            for (int j = i+1;j<nums.length;j++){
                temp += nums[j];
                if (temp > max)max = temp;
            }
        }
        return max;
    }

    /*
     分治法
     */
    public int maxSubArray2(int[] nums){
        return 0;
    }

    /*
    动态规划
     */
    public int maxSubArray3(int[] nums){
        return 0;
    }

}
