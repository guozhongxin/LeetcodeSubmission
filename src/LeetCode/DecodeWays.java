package LeetCode;

/**
 * Created by dell on 2016/9/7.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int length = s.length();
        if (length==0){
            return 0;
        }
        int[] res = new int[length+1];
        if ((s.charAt(0)-'0')==0){
            return 0;
        }
        res[1] = 1;

        for (int i = 2; i<= length; i++){
            char c = s.charAt(i-1);
            char prec = s.charAt(i-2);
            if ((c-'0')==0){
                if ((prec-'0') !=1 && (prec-'0') !=2){
                    return 0;
                }
                res[i] = res[i-2];
            }else {
                res[i] = res[i-1];

                if ((prec-'0')== 1 ||
                        ((prec-'0') == 2 && (c-'0')<=6)){
                    res[i]+=res[i-2];
                }
            }
        }

        return res[length];
    }
}
