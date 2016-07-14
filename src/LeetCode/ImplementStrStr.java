package LeetCode;

/**
 * Created by v-zhoguo on 7/12/2016.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }

        int nl = needle.length();
        for (int i = 0; i <= haystack.length()- nl; i++){
            String h = haystack.substring(i, i+nl);
            if (h.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
