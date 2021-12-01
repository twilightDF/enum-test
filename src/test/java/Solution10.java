import org.junit.Test;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 955 👎 0
public class Solution10 {
    @Test
    public void test01(){
        int[] ints = {1,2,3,6,7,8};
        int target = 3;
        //System.out.println(searchInsert(ints, target));
        System.out.println(searchInsert2(ints, target));
    }


    /*
    暴力查找
     */
    public int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if(target<=nums[i]) {
                break;
            }
        }
        return i;
    }

    /*
    二分查找(针对数据量多的时候,可以提升效率)
    int默认向下取整
     */
    //FIXME
    public int searchInsert2(int[] nums,int target){
        int low = 0;
        int high = nums.length;

        while(low<=high) {
            int mid = (high - low)/2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]){
                low = mid + 1;
            }else if (target == nums[mid])break;
        }
        return (high - low)/2;
    }
}
