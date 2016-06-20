package LeetCode;

/**
 * Created by v-zhoguo on 6/20/2016.
 */
public class LongestCommonPrefix {

    //O(n2) 13.44%
    public String longestCommonPrefix_1(String[] strs) {
        int number = strs.length;
        if(number==0){
            return "";
        }
        if (number == 1){
            return strs[0];
        }
        int length = strs[0].length();

        String longestPrefix ="";
        boolean isTooLong = false;
        for (int i=1; i<=length; i++){
            String prefix = strs[0].substring(0,i);
            boolean isCommon = true;
            for (int j =1; j<number; j++) {
                if (i> strs[j].length()){
                    isCommon = false;
                    isTooLong = true;
                    break;
                }
                if(!strs[j].startsWith(prefix)){
                    isCommon = false;
                    break;
                }
            }
            if (isTooLong){
                break;
            }
            if (isCommon){
                longestPrefix = prefix;
            }
        }

        return longestPrefix;
    }


    //O(n2) 25.94%
    public String longestCommonPrefix(String[] strs) {
        int number = strs.length;
        if(number==0){
            return "";
        }
        if (number == 1){
            return strs[0];
        }
        int length = strs[0].length();

        String longestPrefix ="";
        boolean isEnd = false;
        for (int i=1; i<=length; i++){
            String prefix = strs[0].substring(0,i);
            for (int j =1; j<number; j++) {
                if (i> strs[j].length()){
                    isEnd = true;
                    break;
                }
                if(!strs[j].startsWith(prefix)){
                    isEnd = true;
                    break;
                }
            }
            if (isEnd){
                break;
            }

            longestPrefix = prefix;
        }

        return longestPrefix;
    }


    //I think charAt is better than startWith or indexOf. Is that right?  https://leetcode.com/discuss/99963/simple-java-solution-in-3ms

    public static void main(String[] args){


        //System.out.println(a.substring(0,6));
    }
}
