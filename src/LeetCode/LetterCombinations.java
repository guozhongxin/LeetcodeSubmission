package LeetCode;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by v-zhoguo on 7/4/2016.
 */
public class LetterCombinations {
    public static void main(String[] args){
        List<String> list = letterCombinations("12");
        System.out.print(list);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> lcs = new LinkedList<String>();
        int length = digits.length();
        if (length==0){
            return lcs;
        }

        RecursiveLC(digits, 0, "",lcs);

        return lcs;
    }
//    public List<Character> getLetters(char )

    private static void RecursiveLC(String digits, int p, String prefix, List<String> lcs) {
        if (p== digits.length()){
            lcs.add(prefix);
            return;
        }
        for (int i = 1; i<= Integer.parseInt(digits.charAt(p)+""); i++){
            String prefixA = prefix;
            RecursiveLC(digits, p+1, prefixA, lcs);
        }
        return;
    }

}
