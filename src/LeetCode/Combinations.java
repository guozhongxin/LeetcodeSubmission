package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-zhoguo on 8/2/2016.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        dfs(0, n, k, res, cur);

        return res;
    }

    private void dfs(int last, int n, int k, List<List<Integer>> res, List<Integer> cur){
        int curLength = cur.size();
        if (curLength == k){
            List<Integer> newCombination = new LinkedList<Integer>(cur);
            res.add(newCombination);
//            cur.clear();   wrong!!!
            return;
        }
        for (int i = last+1; i<= n-(k-curLength)+1; i++){
            cur.add(i);
            dfs(i, n, k, res, cur);
            cur.remove(new Integer(i));
        }

    }
}
