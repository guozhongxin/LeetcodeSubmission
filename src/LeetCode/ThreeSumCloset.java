package LeetCode;

import java.util.Arrays;

/**
 * Created by v-zhoguo on 7/4/2016.
 */
public class ThreeSumCloset {
    public static void main(String[] args){
        int[] nums = new int[5];
        nums[0]=-3;
        nums[1]=-2;
        nums[2]=-5;
        nums[3]=3;
        nums[4]=-4;
//        nums[5]=-4;
        System.out.println(threeSumClosest(nums,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int maxDiff = Integer.MAX_VALUE;

        int length = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i< length-1; i++){
            int st = target-nums[i];
            if (i ==0 || nums[i] !=nums[i-1]){
                int start = i+1;
                int end = length-1;
                while (start<end){
                    int d = st - nums[start] - nums[end];
                    if (d == 0){
                        return  target;
                    }
                    if (Math.abs(d)< Math.abs(maxDiff)) {
                       maxDiff = d ;
                    }
                    if (d>0){
                        while (start++<end && nums[start]== nums[start-1]);
                    } else if (d<0){
                        while (start< end-- && nums[end] == nums[end+1]);
                    }
                }
            }
        }

        return target-maxDiff;
    }
}
