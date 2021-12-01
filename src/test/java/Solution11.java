import org.junit.Test;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划
// 👍 3371 👎 0
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
