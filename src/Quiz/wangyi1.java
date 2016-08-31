package Quiz;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dell on 2016/8/2.
 */
public class wangyi1 {
    public static void main(String[] args){

        int[] r1 =new int[]{3,4,5,3};
        int[] r2 =new int[]{3,4,5,3};
        int[] r3 =new int[]{3,4,3,1};
        int[] r4 =new int[]{3,4,3,2};
        int[][] m = new int[][]{r1,r2,r3,r4,r1};
        System.out.println(new wangyi1().max(5,4,m));
    }
    public int max (int r, int c, int[][] matrix){
        List<List<Integer>> rcuts = cut(r-1);
        List<List<Integer>> ccuts = cut(c-1);

        int max = 0;
        for(List<Integer> rcut : rcuts){
            for (List<Integer> ccut : ccuts){
                int min = Integer.MAX_VALUE;
                for (int rcutIntex = 0;  rcutIntex< 4; rcutIntex++){
                    for (int ccutIndex = 0; ccutIndex < 4; ccutIndex++ ){
                        int rstart = 0;
                        if (rcutIntex > 0){
                            rstart = rcut.get(rcutIntex-1)+1;
                        }
                        int rend;
                        if (rcutIntex == 3){
                            rend = r-1;
                        }else {
                            rend = rcut.get(rcutIntex);
                        }

                        int cstart = 0;
                        if (ccutIndex >0){
                            cstart = ccut.get(ccutIndex-1)+1;
                        }
                        int cend;
                        if(ccutIndex == 3){
                            cend = c-1;
                        }else {
                            cend  = ccut.get(ccutIndex);
                        }
                        int current = 0;
                        for (int i = rstart; i<=rend; i++){
                            for (int j = cstart; j<=cend; j++){
                                current +=matrix[i][j];
                            }
                        }
                        if (current < min){
                            min = current;
                        }
                    }
                }
                if (min >max){
                    max = min;
                }
            }
        }
        return max;
    }

    public List<List<Integer>> cut(int n){
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        dfs(0, 3, n, res, cur);
        return res;
    }

    private void dfs(int last, int cuts, int n, List<List<Integer>> res, List<Integer> cur) {
        int size = cur.size();
        if (size == cuts){
            List<Integer> cp = new LinkedList<Integer>(cur);
            res.add(cp);
            return;
        }
        for (int i = last; i< (n-(cuts-size)+1); i++){
            cur.add(new Integer(i));
            dfs(i+1, cuts, n, res, cur);
            cur.remove(new Integer(i));
        }
    }

}
