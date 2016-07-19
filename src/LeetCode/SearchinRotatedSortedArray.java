package LeetCode;

/**
 * Created by v-zhoguo on 7/15/2016.
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        SearchinRotatedSortedArray srs = new SearchinRotatedSortedArray();
        srs.search(new int[]{8,1,2,3,4,5,6,7}, 6);
    }
        public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0){
            return -1;
        }
        int start= 0; int end = length-1;
        int middle;

        if (length ==1 ){
            if(nums[start] == target){
                return start;
            }else {
                return -1;
            }
        }
        while (start<end){
            middle = (start+end)>>1;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[start] == target){
                return start;
            }
            if (nums[end] == target){
                return end;
            }
            if(nums[end]> nums[start]){
                if (nums[middle]< target){
                    start = middle+1;
                }else {
                    end = middle-1;
                }
            }else {
                if (nums[middle] > nums[start]) {
                    if (target < nums[end] || target > nums[middle]) {
                        start = middle+1;
                    } else if (target > nums[start] && target < nums[middle]) {
                        end = middle-1;
                    } else {
                        return -1;
                    }
                }else if (nums[middle]< nums[end]){
                    if(target> nums[start] || target< nums[middle]){
                        end = middle-1;
                    }else if (target > nums[middle] && target< nums[end]){
                        start = middle+1;
                    } else {
                        return -1;
                    }
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
