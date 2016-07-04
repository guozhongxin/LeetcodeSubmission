package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by v-zhoguo on 7/4/2016.
 */
public class TripletSum {
    public static void main(String[] args){
        int[] nums = new int[6];
        nums[0]=-1;
        nums[1]=0;
        nums[2]=1;
        nums[3]=2;
        nums[4]=-1;
        nums[5]=-4;
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i< length-2; i++){
            if (nums[i]>0){
                return triplets;
            }
            int target = - nums[i];
            int start = i+1;
            int end = length-1;
            if (i ==0 || nums[i] != nums[i-1] ) {
                while (start < end) {
                    int sum = nums[start] + nums[end];

                    // Optimization
                    if (nums[start] > target || nums[end] < 0)
                        break;

                    if (sum == target) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[start], nums[end]);
                        triplets.add(triplet);
                        while (start++ < end && nums[start] == nums[start-1]);
                        while (start < end-- && nums[end] == nums[end+1]);
                    } else if (sum < target) {
                        while (start++ < end && nums[start] == nums[start-1]);
                    } else {
                        while (start < end-- && nums[end] == nums[end+1]);
                    }
                }
            }
        }

        return triplets;
    }
}
