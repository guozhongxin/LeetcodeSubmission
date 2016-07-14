package LeetCode;

/**
 * Created by v-zhoguo on 7/12/2016.
 */
public class RemoveElement {
    public int removeElement_1(int[] nums, int val) {
        int length = nums.length;
        if (length==0)
            return 0;
        int start = 0;
        int end = nums.length-1;

        //range!!!!!!!!!!!!!!!!  [0, length-1]
        while (true){
            while (start<length && nums[start]!=val){
                start ++;
            }
            while (end >=0 && nums[end]==val){
                end--;
            }
            if (start< end ){
                nums[start] = nums[end];
                nums[end] = val; // important!!
                start++;
                end--;
            }else {
                break;
            }
        }
        return start;
    }
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] !=val){
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
