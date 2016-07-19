package LeetCode;

/**
 * Created by v-zhoguo on 7/17/2016.
 */
public class TrappingRainWater {

    // Interesting !
    public int trap(int[] height) {
        int length = height.length;
        if (length<=2){
            return 0;
        }
        int left = 0, right = length-1;
        int result = 0;
        int leftbar = height[left];
        int rightbar = height[right];
        while (left< right){

            if (leftbar<rightbar){
                left++;
                if (height[left] < leftbar){
                    result += leftbar - height[left];
                }else {
                    leftbar = height[left];
                }
            }else {
                right--;
                if (height[right]< rightbar){
                    result += rightbar-height[right];
                }else {
                    rightbar = height[right];
                }
            }
        }
        return result;
    }
}
