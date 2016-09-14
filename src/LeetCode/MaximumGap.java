package LeetCode;

import java.util.Arrays;

/**
 * Created by dell on 2016/9/14.
 */
public class MaximumGap {
    public static void main (String[] a){
        MaximumGap mg = new MaximumGap();
        System.out.println(mg.maximumGap(new int[]{132,21,245,436,324,463,277,127,985,876,576,732}));
    }
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length <=1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i< length; i++){
            if (max< nums[i]){
                max = nums[i];
            }
            if (min>nums[i]){
                min = nums[i];
            }
        }

        int avgGap = (max- min)/(length-1);
        if (avgGap == 0){
            avgGap++;
        }
        int len = (max-min)/avgGap +1;
        int[] intervalMin = new int[len];
        int[] intervalMax = new int[len];
        Arrays.fill(intervalMin, Integer.MAX_VALUE);
        Arrays.fill(intervalMax, -1);

        for (int i = 0; i< length; i++){
            int index = (nums[i]-min)/avgGap;
            if (nums[i]> intervalMax[index]){
                intervalMax[index] = nums[i];
            }
            if(nums[i]< intervalMin[index]){
                intervalMin[index] = nums[i];
            }
        }
        max = intervalMax[0];
        min = intervalMax[0];
        int maxGap = max - min;
        int gap = 0;
        for (int i = 1 ; i<len; i++){
            if (intervalMax[i]!=-1){
                max = intervalMin[i];
                gap = max -min;
                if (gap> maxGap){
                    maxGap = gap;
                }
                min = intervalMax[i];
            }
        }

        return maxGap;
    }
}
