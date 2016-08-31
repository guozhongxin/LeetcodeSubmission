package Quiz;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class wangyi2 {
    public static void main(String[] args){
        int[] nums = new int[]{4,0,0,2,0};
        System.out.print(new wangyi2().find(5,5,nums));
    }
    public int find(int n, int k, int[] nums){

        int res = 0;
        HashSet<Integer> shunxu = new HashSet<Integer>();
        for(int i =0; i<n;i++){
            shunxu.add(i+1);
        }
        for (int i : nums){
            if (i!=0){
                shunxu.remove(i);
            }
        }
        int[] remain = new int[shunxu.size()];
        int index =0;
        for (Integer i : shunxu){
            remain[index++] = i;
        }
        List<List<Integer>> permutes = permute(remain);

        for (List<Integer> list :permutes){
            int[] cp = nums.clone();
            int listIndex =0;
            for (int i = 0; i< n; i++){
                if (cp[i] == 0){
                    cp[i] = list.get(listIndex++);

                }
            }
            int geshu = checkShun(cp);
            if (geshu == k){
                res++;
            }
        }
        return res;
    }

    public int checkShun(int[] nums){
        int res = 0;
        for (int i =0; i<nums.length-1; i++){
            for (int j =i+1; j<nums.length;j++){
                if (nums[i]<nums[j]){
                    res++;
                }
            }
        }
        return res;
    }


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
