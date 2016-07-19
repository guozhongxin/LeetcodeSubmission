package LeetCode;

/**
 * Created by v-zhoguo on 7/17/2016.
 */
public class FirstMissingPositive {

    // for array, if you wanna save space complexity, use the nums[] ifself!!!
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i< length; i++){
            while(nums[i]<=length && nums[i]>=1 && nums[i]!=i+1){
                if ( nums[i] != nums[nums[i]-1]) {
                    swap(nums, i, nums[i] - 1);             // handle the duplicate value!!!!!
                }else{
                    break;          // handle every if and every else
                }
            }
        }

        for (int i =0; i< length; i++){
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Time: O(n) Space: O(n)
    public int firstMissingPositive_1(int[] nums) {
        int length = nums.length;
        int[] space = new int[nums.length+1];
        for (int i = 1; i<=length+1; i++){
            space[i-1] =1;
        }
        for (int i = 0; i<length; i++){
            if (nums[i]<=length && nums[i]>=1){
                space[nums[i]-1] = 1;
            }
        }
        int i =1;
        for (; i<=length+1; i++){
            if (space[i-1] ==0){
                break;
            }
        }
        return i;
    }
}
