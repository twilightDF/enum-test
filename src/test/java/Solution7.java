import org.junit.Test;
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
//
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3 * 104
// -104 <= nums[i] <= 104
// nums 已按升序排列
//
//
//
// Related Topics 数组 双指针
// 👍 2103 👎 0

public class Solution7 {
    @Test
    public void test01(){
        int[] ints = {1,1,1,2,2,2,2,2,2,3,3,4,4,5,5};

        System.out.println(removeDuplicates(ints));

    }

    /*  思路1 -- 分为三步,1.重复数字置零  2.消零移位  3.掐断尾部为0部分
        问题:重复的数字置零不可取,
      因为不能拿排除原数组中0的存在,置为其他数字同理;
    */

//    public int removeDuplicates(int[] nums) {
//        //定义两个指针
//        int a = 0;
//        int b = 1;
//
//        //1--此步为去重,将重复的数字置0
//        while(b != nums.length){
//            if (nums[a] == nums[b]){
//                nums[b] = 0;
//                b++;
//            }else {
//                a = b;
//                b++;
//            }
//        }
//
//        a = 0;//重置a,b
//        b = 0;
//        int temp;
//        //去除第一位为0的情况,make no sense!!
//        if (nums[0] == 0) {TODO}
//       FIXME
//       2--此步为去零,并移动位置
//       while(b != nums.length){
//           if (nums[b] != 0){
//               b++;
//           }
//            else {
//               temp = nums[a];
//               nums[a] = nums[b];
//               nums[b] = temp;
//               a++;
//               b++;
//           }
//       }
         //3--掐断尾部为0部分
         //TODO
//        return nums.lenght;
//    }

    /*
    思路2 -- 一步到位
     */

    public int removeDuplicates(int[] nums) {
        int slow=0;  //定义一个慢指针指向数组第一个位置
        int quick=1; //定义一个快指针指向数组第二个位置
        int i=nums.length;
        while (quick< nums.length){ //遍历整个数组
            if(nums[slow]!=nums[quick]){//当两个指针指向的元素不相等时
                nums[slow+1]=nums[quick]; //将快指针指向的的元素的值赋值为慢指针后一位指向的元素
                quick++;//快指针向前移动
                slow++; //慢指针也向前移动
            }else{  //如果两个指针指向的元素相等
                //0123222333444
                //123112222233333
                i--;  //数组的长度-1
                quick++;  //快指针向前移动，慢指针不变
            }
        }
        return i;

    }
}
