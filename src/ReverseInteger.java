/**
 * Created by WTI-LIU on 2015/10/13.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int[] digit = new int[11];
        boolean zheng = (x>=0);
        int p=Math.abs(x),q=0;
        int i=0;
        for(; i <= 11 && p!=0; i++){
            q = p/10;
            digit[i] = p%10;
            p=q;
        }
        i--;
        long r = 0l;
        for (int j =i; j>=0; j--){
            r+=Math.pow(10, i - j)*digit[j];
        }
        if (!zheng){
            r=0l-r;
        }
        if (r>Integer.MAX_VALUE||r<Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)r;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345));
    }
}
