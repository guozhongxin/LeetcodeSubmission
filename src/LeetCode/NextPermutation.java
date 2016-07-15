package LeetCode;

import java.util.Arrays;

/**
 * Created by v-zhoguo on 7/14/2016.
 */
public class NextPermutation {
    public static void main(String[] args){
        NextPermutation np = new NextPermutation();
        int[] nums = new int[]{4,7,5,9,9,4,1};
        np.nextPermutation(nums);
        for (int a : nums) {
            System.out.print(a);
        }

    }
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length-1;
        for (; i>0; i--){
            if (nums[i]>nums[i-1]){
                break;
            }
        }
        if (i ==0){
            reverse(nums, 0, length-1);
        }else{
            int p = nums[i-1];
            int j = length-1;
            for (; j>=i ; j--){
                if (nums[j]> p)
                    break;
            }
            nums[i-1] = nums[j];
            nums[j] = p;
            //Arrays.sort(nums, i,length);
            reverse(nums, i, length-1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
