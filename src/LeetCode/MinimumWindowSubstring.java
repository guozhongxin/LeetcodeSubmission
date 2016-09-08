package LeetCode;

import java.util.HashMap;

/**
 * Created by dell on 2016/9/4.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()){
            tmap.put(c, tmap.containsKey(c)?(tmap.get(c)+1):1);
        }
        if (tlength == 0){
            return "";
        }
        int count = tlength;
        int start = 0;
        int end = -1;
        int minwin = Integer.MAX_VALUE;
        String minString = "";
        while (end<slength){
            if (count!=0){
                end++;
                if (end==slength-1){
                    return minString;
                }
                if (tmap.containsKey(s.charAt(end))){
                    if (tmap.get(s.charAt(end))>0){
                        count--;
                    }
                    tmap.put(s.charAt(end),tmap.get(s.charAt(end))-1);
                }
            }else {
                System.out.println(s.substring(start, end+1));
                if (minwin>(end-start+1)){
                    minwin = end-start+1;
                    minString = s.substring(start, end+1);
                }
                if (tmap.containsKey(s.charAt(start))){
                    if (tmap.get(s.charAt(start))>=0){
                        count++;
                    }
                    tmap.put(s.charAt(start), tmap.get(s.charAt(start))+1);
                }
                start++;
            }
        }

        return minString;
    }
}
