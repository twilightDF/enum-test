import org.junit.Test;

public class Solution8 {

    @Test
    public void test01(){
        int[] ints = {1,1,1,1,2,1,2,3,4,4};

        System.out.println(" " + removeElement(ints, 1));
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int quick = 0;
        int i = nums.length;
        while(quick < nums.length){
            if (nums[quick] != val){
                nums[slow] = nums[quick];
                slow++;
                quick++;
            }else {
                i--;
                quick++;
            }
        }
        for (int a:nums
             ) {
            System.out.print(a);
        }
        return i;
    }
}
