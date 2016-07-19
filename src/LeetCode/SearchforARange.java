package LeetCode;

/**
 * Created by v-zhoguo on 7/15/2016.
 */
public class SearchforARange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }

        int[] result =new int[2];

        result[0] = findStart(nums, target);
        result[1] = findEnd(nums, target);

        return result;
    }

    private int findStart(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;
        int middle ;
        while (start<end){
            middle = ( start+ end)>>1;
            if (nums[middle]<target){
                start = middle+1;
            }else {
                end = middle;
            }
        }
        if (nums[start]==target){
            return start;
        }else if (start <nums.length-1 && nums[start+1]<target ){
            return start+1;
        }else {
            return -1;
        }
    }

    private int findEnd(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;
        int middle ;
        while (start<end){
            middle = ( start+ end)>>1;
            if (nums[middle]<=target){
                start = middle+1;
            }else {
                end = middle;
            }
        }
        if (nums[start]==target){
            return start;
        }else if ( start>0 && nums[start-1]== target){
            return start-1;
        }else {
            return -1;
        }
    }
}
