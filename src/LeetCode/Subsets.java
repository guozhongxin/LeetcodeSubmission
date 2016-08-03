package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-zhoguo on 8/2/2016.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        dfs(0, nums,  res, cur);
        return res;
    }

    private void dfs(int lastIndex, int[] nums, List<List<Integer>> res, List<Integer> cur){
        int curLength = cur.size();
        List<Integer> newCombination = new LinkedList<Integer>(cur);
        res.add(newCombination);

        for (int i = lastIndex; i< nums.length; i++){
            cur.add(nums[i]);
            dfs(i+1, nums, res, cur);
            cur.remove(new Integer(nums[i]));
        }
    }
}
