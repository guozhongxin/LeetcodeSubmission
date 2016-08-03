package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guozhongxin on 16/7/16.
 */
public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		cs.combinationSum(new int[]{2,3,6,7}, 7);

	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> currentList = new LinkedList<Integer>();
		for (int i = 0; i< candidates.length; i++) {
			findCombination(candidates, i, target, result, currentList);
			System.out.println(i);
		}
		return result;
	}

	public boolean findCombination(int[] candidates, int from, int target,
								List<List<Integer>> result, List<Integer> currentList){

		currentList.add(candidates[from]);
		int sum = sumList(currentList) ;
		if (sum == target){
			result.add(new LinkedList<Integer>(currentList));
			currentList.remove(new Integer(candidates[from]));
			return true;
		}else if(sum> target){
			currentList.remove(new Integer(candidates[from]));
			return false;
		} else {
			boolean canfindnext = false;
			for (int i = from; i< candidates.length; i++){
				canfindnext |= findCombination(candidates, i, target, result, currentList);
			}

			if (!canfindnext){
				currentList.remove(new Integer(candidates[from]));
				return false;
			}else {
				currentList.remove(new Integer(candidates[from]));
				return true;
			}

		}
	}

	public int sumList(List<Integer> list){
		int sum = 0;
		for (int i : list){
			sum+=i;
		}
		return sum;
	}

}
