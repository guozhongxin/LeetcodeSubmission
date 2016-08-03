package LeetCode;

import java.util.Stack;

/**
 * Created by v-zhoguo on 7/19/2016.
 */
public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII jgii = new JumpGameII();
        System.out.println(jgii.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }

    // beats 93.51%
    public int jump(int[] nums){
        int length = nums.length;
        if (length==1){
            return 0;
        }
        int steps = 1;
        int target = length-1;
        int max = nums[0];
        int start = 0;

        int premax;
        while (max<target){
            premax = max;
            max = findnextmaxreach(nums,start, max);
            start = premax;
            steps++;
        }

        return steps;
    }

    private int findnextmaxreach(int[] nums, int start, int max) {

        int nextmax = max;
        for (int i = start+1; i<=max; i++){
            if ((i+nums[i])>nextmax){
                nextmax = i+nums[i];
            }
        }
        return nextmax;
    }

    //beats 93.5%
    public int jump_3(int[] nums){
        int length = nums.length;
        if (length==1){
            return 0;
        }
        int steps = 1;
        int maxreach = nums[0];
        if (maxreach>=length-1){
            return 1;
        }
        int prereach = 0;
        int currentreache ;
        for (int i = 1; i< length-1; i++){
            currentreache = i+ nums[i];
            if (currentreache> maxreach){
                if (i>prereach){
                    steps++;
                    prereach = maxreach;
                }
                maxreach=currentreache;
                if (maxreach>=length-1){
                    return steps;
                }
            }
        }
        return steps;
    }

    // beats 2.2%
    public int jump_2(int[] nums) {
        int length = nums.length;
        int step = 0;

        if (length==2){
            return 1;
        }
        if (length==1){
            return 0;
        }
        //int[] maxreach = new int[length];
        Stack<Integer> jumps = new Stack<Integer>();
        Stack<Integer> reach = new Stack<Integer>();
        jumps.push(length-2);
        reach.push(length-1);
        for (int i = length-3; i>=0; i--){
            int maxreach = Math.min(length-1, i+nums[i]);
            if (maxreach >= jumps.peek()) {
                while (!reach.empty() && maxreach >= reach.peek()) {
                    reach.pop();
                    jumps.pop();
                }
                if (reach.empty()){
                    reach.push(length-1);
                }else {
                    reach.push(jumps.peek());
                }
                jumps.push(i);

            }
        }
        return jumps.size();
    }
        // beat 0.7% ...
    public int jump_1(int[] nums) {
        int length = nums.length;
        int step = 0;
        int[] maxreach = new int[length];
        for (int i = 0; i< length; i++){
            maxreach[i] = i + nums[i];
        }
        int index=length-1;
        while (index!=0){
            index = findIndex(maxreach, index);
            step++;
        }
        return step;
    }

    public int findIndex (int[] maxreach, int dist){
        for (int i = 0; i<dist;i++){
            if (maxreach[i] >= dist){
                return i;
            }
        }
        return dist;
    }
}
