import org.junit.Test;

public class Solution7 {
    @Test
    public void test01(){
        int[] ints = {1,1,1,2,2,2,2,2,2,3,3,4,4,5,5};

        removeDuplicates(ints);

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
