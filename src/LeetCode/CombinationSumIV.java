package LeetCode;

/**
 * Created by v-zhoguo on 8/5/2016.
 */
public class CombinationSumIV {

    public static void main(String[] args){
        System.out.print(new CombinationSumIV().combinationSum4(new int[]{1,2,3}, 32));
    }

    public int combinationSum4(int[] nums, int target){
        int res = 0;
        int[] counts = new int[target+1];
        for (int i : nums){
            if (i<=target) {
                counts[i] = 1;
            }
        }
        for (int i =1; i<=target; i++){
            for (int j : nums){
                if (i-j>=1){
                    counts[i] += counts[i-j];
                }
            }
        }
        return counts[target];
    }

    public int combinationSum4_1(int[] nums, int target) {
        int[] res = new int[]{0};
        refind(target, nums, res);
        return res[0];
    }

    private void refind(int target, int[] nums, int[] res) {
        if (target==0){
            res[0]+=1;
            return;
        }else if (target<0){
            return;
        }
        for (int i : nums){
            refind(target-i, nums, res);
        }
    }
}
