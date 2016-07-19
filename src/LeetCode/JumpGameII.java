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

    public int jump(int[] nums){
        int length = nums.length;
        int step = 0;

        if (length==2){
            return 1;
        }
        if (length==1){
            return 0;
        }


        return step;
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
