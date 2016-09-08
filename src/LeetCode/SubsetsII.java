package LeetCode;

import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dell on 2016/9/7.
 */
public class SubsetsII {
    public static void main (String[] a){
        SubsetsII ss = new SubsetsII();
        ss.subsetsWithDup(new int[]{1,2,2});
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> cur = new LinkedList<Integer>();
        res.add((List<Integer>) cur.clone());
        int index = 0;
        subRe(nums, cur, res, index);

        return res;
    }

    private void subRe(int[] nums, LinkedList<Integer> cur, LinkedList<List<Integer>> res, int index) {

        for (int i = index; i< nums.length; i++){
            if (i!=index && nums[i] == nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            List<Integer> ccur = new LinkedList<Integer>(cur);
            res.add(ccur);
            subRe(nums, cur, res, i+1);
            cur.removeLast();
        }
    }
}
