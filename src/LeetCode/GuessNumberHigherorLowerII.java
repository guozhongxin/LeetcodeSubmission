package LeetCode;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by dell on 2016/8/6.
 */
public class GuessNumberHigherorLowerII {
    public static void main(String[] args){
        System.out.println(new GuessNumberHigherorLowerII().getMoneyAmount(10));
    }
    public int getMoneyAmount(int n) {
        int[][] f = new int[n+2][n+2];
        for(int i = 1; i<=n-1; i++){
            f[i][i+1] = i;
        }
        for (int l = 2; l<=n-1; l++){
            for (int i = 1; i<=(n-l);i++){
                int min = Integer.MAX_VALUE;
                for (int g = i; g<= i+l; g++){

                    int a = g + Math.max(f[i][g-1], f[g+1][i+l]);
                    if (a<min){
                        min = a;
                    }
                }
                f[i][i+l] = min;
            }
        }
        return f[1][n];
    }
}
