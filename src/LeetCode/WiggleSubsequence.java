package LeetCode;

/**
 * Created by dell on 2016/8/6.
 */
public class WiggleSubsequence {

    public static void main(String[] args){
        System.out.print(new WiggleSubsequence().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length<=1){
            return length;
        }
        int res = 1;
        int pre = nums[0];
        int i =1;
        while (i<length && nums[i]==nums[0]){
            i++;
        }
        if (i==length){
            return res;
        }
        res++;
        boolean curorder = (nums[i]> nums[0]);
        while (i<length){
            if (nums[i]==nums[i-1]){
                i++;
                continue;
            }
            if ((nums[i]> nums[i-1])== curorder){
                i++;
            }else {
                i++;
                res++;
                curorder = !curorder;
            }
        }

        return res;

    }
}
