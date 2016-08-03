package LeetCode;

/**
 * Created by guozhongxin on 16/7/20.
 */
public class NQueensII {
	public static void main(String[] args) {
	}
	public int totalNQueens(int n) {
		int[] nums = new int[n];
		for (int i =0; i< n; i++){
			nums[i]=i;
		}
		int[] res = new int[1];
		rePermute(nums, 0, res);
		return res[0];
	}

	private void rePermute(int[] nums, int start, int[] res) {
		int length = nums.length;
		if(!check(nums, start)){
			return;
		}
		if (start == length-1){
			res[0]+=1;
			return;
		}
		rePermute(nums, start+1, res);
		for (int i = start+1; i<=length-1; i++){
			swap(nums, start, i);
			rePermute(nums, start+1, res);
			swap(nums, i, start);
		}
	}

	private boolean check(int[] nums, int start) {
		for (int i = 0; i<=start; i++) {
			for (int j = i+1; j<=start; j++) {
				if (Math.abs(i-j) == Math.abs(nums[i]-nums[j])) {
					return false;
				}
			}
		}
		return true;
	}


	private void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
