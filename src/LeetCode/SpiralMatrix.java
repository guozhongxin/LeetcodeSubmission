package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-zhoguo on 7/19/2016.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        if (matrix.length == 0 || matrix[0].length==0){
            return res;
        }
        int maxcycle = (Math.min(matrix.length, matrix[0].length)+1)/2;
        for (int i =0; i<maxcycle; i++){
            addcycle(matrix, i, res);
        }
        return res;
    }

    private void addcycle(int[][] matrix, int s, List<Integer> res) {
        int r= matrix.length;
        int c = matrix[0].length;
        int i = s;
        int j = s;
        while (j<=c -1-s){
            res.add(matrix[i][j]);
            j++;
        }
//        j--;
//        if (j>=c-)
//        while (j<=)
    }
}
