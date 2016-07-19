package LeetCode;

/**
 * Created by v-zhoguo on 7/19/2016.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
        public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i< nums.length; i++){
            sum +=nums[i];
            if (sum> maxSum){
                maxSum = sum;
            }
            if (sum<0){
                sum =0;
            }
        }
        return maxSum;
    }
}
