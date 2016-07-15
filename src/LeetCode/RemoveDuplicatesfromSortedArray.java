package LeetCode;

/**
 * Created by v-zhoguo on 7/12/2016.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int length = nums.length;
        for (int i = 1; i< length; i++){
            int current = i;
            if (nums[current] != nums[current-1]){
                nums[++p] = nums[current];
            }
        }
        return p+1;
    }
}
