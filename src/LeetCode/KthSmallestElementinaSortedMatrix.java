package LeetCode;

import java.util.Arrays;

/**
 * Created by v-zhoguo on 8/5/2016.
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int min = matrix[0][0];
        int r = matrix.length;
        int[][] flag = new int[r][r];
        int[] tag = new int[r];
        Arrays.fill(tag, -1);
        int i = 0;
        tag[0]=0;
        while (i<k){
            int next = Integer.MAX_VALUE;
            for (int j = 0; j< r; j++){
                if (tag[j] == r-1){
                    continue;
                }
                if (matrix[j][tag[j]] <next){
                    next = matrix[j][tag[j]];
                }
                if (j<r && tag[j] == tag[j+1]){
                    break;
                }
            }
            min = next;
            i++;
        }

        return min;
    }
}
