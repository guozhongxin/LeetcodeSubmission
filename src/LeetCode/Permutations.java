package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-zhoguo on 7/19/2016.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();

		rePermute(nums, 0,res);
		return res;
    }

	private void rePermute(int[] nums, int start, LinkedList<List<Integer>> res) {
		int length = nums.length;
		if (start == length-1){
			List<Integer> l = new LinkedList<Integer>();
			for (int a : nums){
				l.add(a);
			}
			res.add(l);
			return;
		}
		rePermute(nums, start+1, res);
		for (int i = start+1; i<=length-1; i++){
			swap(nums, start, i);
			rePermute(nums, start+1, res);
			swap(nums, i, start);
		}
	}

	private void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
