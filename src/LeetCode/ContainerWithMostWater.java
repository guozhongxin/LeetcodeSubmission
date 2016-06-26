package LeetCode;

/**
 * Created by v-zhoguo on 6/20/2016.
 */
public class ContainerWithMostWater {

    // O(n2) stupid!
    public int maxArea_1(int[] height){
        int max=0;

        int length = height.length;
        for (int i=0; i<length-1; i++){
            for (int j = i+1; j<length; j++){
                int water = Math.min(height[i], height[j])*(j-i);
                max = Math.max(water, max);
            }
        }
        return max;
    }

    //O(n)  beat 68%
    public int maxArea_2(int[] height){
        int max = 0;
        int length = height.length;
        int i = 0, j = length-1;

        while (i<j){

            if (height[i]<height[j]){
                int water = height[i]*(j-i);
                max = Math.max(max, water);
                i++;
            }else if(height[i]==height[j]){
                int water = height[i]*(j-i);
                max = Math.max(max, water);
                i++;j--;
            }else {
                int water = height[j]*(j-i);
                max = Math.max(max, water);
                j--;
            }
        }

        return max;
    }

    // O(n) beats 83.4%
    public int maxArea_3(int[] height){
        int max=0, i=0, j = height.length-1;
        while (i<j){
            int left = height[i];
            int right = height[j];
            if (left<right){
                max = Math.max(max, left*(j-i));
                while (height[i]<left && i<j);   // i<j 不需要，只要height[i]<left即可
            }else {
                max = Math.max(max, right*(j-i));
                do {
                    j--;
                }while ( height[j]<right &&i<j);
            }
        }
        return max;
    }

    //O(n)  beats 95.53%  (no Math.max!!!!!)
    public int maxArea(int[] height){
        int max = 0, i =0, j = height.length-1;
        int area = 0;
        while (i<j){
            int left = height[i];
            int right = height[j];
            if (left<right){
                area = left*(j-i);
                while (height[++i]<left);   // i<j 不需要，只要height[i]<left即可
            }else {
                area = right*(j-i);
                while ( height[--j]<right);
            }
            if (area> max)
                max= area;  // better than Math.max()!!!
        }
        return max;
    }

}
