package LeetCode;

/**
 * Created by dell on 2016/9/7.
 */
public class InterleavingString {
    private char[] sc1;
    private char[] sc2;
    private char[] sc3;

    public static void main(String[] a){
        InterleavingString i = new InterleavingString();
        System.out.println(i.isInterleave("ab", "cd", "acbd"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        sc1 = s1.toCharArray();
        sc2 = s2.toCharArray();
        sc3 = s3.toCharArray();
        if ((s1.length()+s2.length()) != s3.length()){
            return false;
        }

        boolean[][] dp = new boolean[sc2.length+1][sc1.length+1];
        dp[0][0] = true;
        for (int i = 1; i <= sc1.length; i++){
            dp[0][i] = dp[0][i-1] &&(sc1[i-1] == sc3[i-1]);
        }
        for (int i = 1; i<= sc2.length; i++){
            dp[i][0] = (sc2[i-1] == sc3[i-1]) && dp[i-1][0];
            for (int j =1; j<=sc1.length; j++){
                boolean checks1 = dp[i][j-1] && (sc1[j-1] == sc3[i+j-1]);
                boolean checks2 = dp[i-1][j] && (sc2[i-1] == sc3[i+j-1]);
                dp[i][j] = checks1 || checks2;
             }
        }
        return dp[sc2.length][sc1.length];
    }



    //  Time Limit Exceeded
    public boolean isInterleave_1(String s1, String s2, String s3) {
        sc1 = s1.toCharArray();
        sc2 = s2.toCharArray();
        sc3 = s3.toCharArray();
        if ((s1.length()+s2.length()) != s3.length()){
            return false;
        }
        return isInterleaveRR(0,0,0);
    }
    //  Time Limit Exceeded
    private boolean isInterleaveRR(int s1Index, int s2Index, int s3Index) {
        if (s1Index==sc1.length && s2Index == sc2.length && s3Index == sc3.length){
            return true;
        }
        if (s3Index>=sc3.length){
            return false;
        }
        if (s1Index<sc1.length && sc3[s3Index] == sc1[s1Index]){
            if (s2Index<sc2.length && sc2[s2Index] == sc1[s1Index]){
                return isInterleaveRR(s1Index+1, s2Index, s3Index+1) ||
                        isInterleaveRR(s1Index, s2Index+1, s3Index+1);
            }
            else return isInterleaveRR(s1Index+1, s2Index, s3Index+1);
        }else if (s2Index<sc2.length && sc3[s3Index] == sc2[s2Index]){
            return isInterleaveRR(s1Index, s2Index+1, s3Index+1);
        }else {
            return false;
        }
    }
}
