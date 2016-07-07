package LeetCode;

import java.util.*;


/**
 * Created by v-zhoguo on 7/4/2016.
 */
public class LetterCombinations {

    public static void main(String[] args){
        LetterCombinations lc = new LetterCombinations();
        List<String> list = lc.letterCombinations("23");
        System.out.print(list);
    }

    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations_1(String digits) {

        List<String> lcs = new LinkedList<String>();
        int length = digits.length();
        if (length==0 || digits.contains("1") || digits.contains("0")){
            return lcs;
        }

        RecursiveLC_1(digits, 0, "",lcs);

        return lcs;
    }

    private void RecursiveLC_1(String digits, int p, String prefix, List<String> lcs) {

        if (p== digits.length()){
            lcs.add(prefix);
            return;
        }

        char[] letters = this.mapping[Integer.parseInt(digits.charAt(p)+"")].toCharArray();
        for (char letter: letters ) {

            String prefixA = prefix+letter;
            RecursiveLC_1(digits, p+1, prefixA, lcs);
        }
        return;
    }


    public List<String> letterCombinations_2(String digits) {
        List<String> lcs = new LinkedList<String>();
        int length = digits.length();
        if (length==0 || digits.contains("1") || digits.contains("0")){
            return lcs;
        }
        Stack<Character> prefix = new Stack<Character>();
        RecursiveLC_2(digits, 0, prefix,lcs);

        return lcs;
    }

    private void RecursiveLC_2(String digits, int p, Stack<Character> prefix, List<String> lcs) {
        if (p== digits.length()){
            char[] lc = new char[1];
            lcs.add(prefix.toString());
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(p));
        char[] letters = mapping[digit].toCharArray();
        for (char letter : letters){
            prefix.push(letter);
            RecursiveLC_2(digits, p+1, prefix, lcs);
            prefix.pop();
        }
    }


    // FIFO!!!!!!!!!!!!!!!!
    public List<String> letterCombinations(String digits) {
        LinkedList<String> lcs = new LinkedList<String>();
        int length = digits.length();
        if (length==0 || digits.contains("1") || digits.contains("0")){
            return lcs;
        }
        lcs.add("");
        for (int i = 0; i< length; i++){
            int digit = Character.getNumericValue(digits.charAt(i));
            char[] letters = mapping[digit].toCharArray();
            while(lcs.peek().length() == i){
                String t = lcs.removeFirst();
                for (char letter : letters){
                    lcs.add(t+letter);
                }
            }
        }
        return lcs;
    }
}
