package LeetCode;

/**
 * Created by v-zhoguo on 7/17/2016.
 */
public class WildcardMatching {
    public static void main(String[] args){
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("abcadsd","a?*ds*"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') count++;
        }
        if (count==0 && m != n) return false;
        else if (n - count > m) return false;

        boolean[] match = new boolean[m+1];
        match[0] = true;
        for (int i = 0; i < m; i++) {
            match[i+1] = false;
        }
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                for (int j = 0; j < m; j++) {
                    match[j+1] = match[j] || match[j+1];
                }
            } else {
                for (int j = m-1; j >= 0; j--) {
                    match[j+1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
                }
                match[0] = false;
            }
        }
        return match[m];
    }


    public boolean isMatch_1(String s, String p) {
        recurisiveMatch(s.toCharArray(), p.toCharArray(), 0, 0);
        return false;
    }

    private boolean recurisiveMatch(char[] s, char[] p, int sIndex, int pIndex) {
        if (sIndex==s.length){
            if (pIndex==p.length ){
                return true;
            }else{
                int i = pIndex;
                while (i< p.length && p[i]=='*' ){   //!!!!!!
                    i++;
                }
                return !(i< p.length);
            }
        }else if (pIndex == p.length){
            return false;
        }

        if (p[pIndex] == '?'){
            return recurisiveMatch(s,p, sIndex+1, pIndex+1);
        }else if(p[pIndex] == '*'){
            int i = pIndex;
            while (i< p.length && p[i]=='*' ){   //!!!!!!   ****
                i++;
            }
            pIndex = --i;
            return recurisiveMatch(s,p, sIndex+1, pIndex) || recurisiveMatch(s,p, sIndex+1, pIndex+1)
                    || recurisiveMatch(s,p, sIndex, pIndex+1);  // !!!!!!!!!!
        }else if (s[sIndex] == p[pIndex]){
            return recurisiveMatch(s,p, sIndex+1, pIndex+1);
        }else {
            return false;
        }
    }
}
