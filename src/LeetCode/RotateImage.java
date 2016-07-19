package LeetCode;

/**
 * Created by v-zhoguo on 7/19/2016.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        double maxi = Math.ceil(n/2d);
        double maxj = Math.floor(n/2d);
        for (int i = 0; i<maxi; i++){
            for (int j = 0; j< maxj; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]= matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
