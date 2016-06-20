package LeetCode;

/**
 * Created by v-zhoguo on 6/20/2016.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // beats 28.5%
//        StringBuilder s = new StringBuilder( M[num/1000]);
//        s.append(C[num%1000/100]).append(X[num%100/10]).append(I[num%10]);
//        return s.toString();

        // beats 39.52%
        return M[num/1000]+C[num%1000/100]+X[num%100/10]+I[num%10];
    }


    // beats 67.72%
    public int romanToInt(String s) {
        int ret = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int pre = toNumber(s.charAt(i - 1));
            int cur = toNumber(s.charAt(i));
            if (pre < cur) {
                ret += cur - 2*pre;
            } else {
                ret += cur;
            }
        }
        return ret;
    }
    public int toNumber(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
