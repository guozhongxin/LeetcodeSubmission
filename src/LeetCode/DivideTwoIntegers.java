package LeetCode;

/**
 * Created by v-zhoguo on 7/12/2016.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor== 0){
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean neg = (dividend>= 0 && divisor >= 0) || (dividend <0 && divisor<0);
        long dividendl = Math.abs((long)dividend);
        long divisorl = Math.abs((long)divisor);

        long result = 0;
        long remainer = dividendl;

        long sub = divisorl;
        long c = 1;
        while (remainer >= divisorl){
            if (sub <= remainer){
                remainer -= sub;
                result += c;
                sub= sub<<1;
                c = c <<1;
            }else {
                sub = sub>>1;
                c = c>>1;
            }

        }

        if (neg ){
            return (int ) result;
        }else{
            return  (int)-result;
        }
    }
}
