package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by v-zhoguo on 7/13/2016.
 */
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args){
        SubstringwithConcatenationofAllWords sw = new SubstringwithConcatenationofAllWords();
        String[] words = new String[2];
        words[0] ="foo";
        words[1] = "bar";
        sw.findSubstring("barfoothefoobarman", words);

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<Integer>();
        if (words.length == 0){
            return results;
        }
        int wl = words[0].length();
        HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
        for (int i = 0; i < words.length ; i++){
            if (wordsCount.containsKey(words[i])){
                wordsCount.put(words[i], wordsCount.get(words[i])+1);
            }else {
                wordsCount.put(words[i],1);
            }
        }
        HashMap<String, Integer> copy = (HashMap<String, Integer>) wordsCount.clone();
            for(int j =0; j< s.length()-words.length*wl+1; j++){
                int findNumber = 0;
                String substring = s.substring(j,j+words.length*wl);
                int from = 0 ;
                String subword = substring.substring(from,from+ wl);
                while (wordsCount.containsKey(subword)){
                    findNumber++;
                    int count = wordsCount.get(subword);
                    if (count >1){
                        wordsCount.put(subword, count-1);


                    }else if (count==1){
                        wordsCount.remove(subword);
                    }
                    if (findNumber == words.length){
                        break;
                    }
                    from +=wl;
                    subword = substring.substring(from, from+wl);

                }
                if (findNumber == words.length){
                results.add(j);

            }
            wordsCount.clear();
            wordsCount = (HashMap<String, Integer>) copy.clone();
        }
        return results;
    }
}
