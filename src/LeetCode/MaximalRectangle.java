package LeetCode;

/**
 * Created by dell on 2016/9/4.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        if (m==0){
            return max;
        }
        int n = matrix[0].length;
        int[] dp = new int[n];
        dp[0] = matrix[0][0]-'0';
        max = dp[0];
        for (int i = 1; i<n ; i++){
            dp[i] = (matrix[0][i]-'0')* (matrix[0][i]-'0'+1);
            if (dp[i]>max){
                max = dp[i];
            }
        }
        for (int i = 1; i< m; i++){
            dp[0] = (matrix[i][0]-'0')*(matrix[i][0]-'0'+1);
            for(int j = 1; j< n; j++){
                if (matrix[i][j] == '1'){

                }else {
                    dp[j] = 0;
                }
            }
        }
        return max;
    }
}
