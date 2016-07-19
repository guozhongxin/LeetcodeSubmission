package LeetCode;

import java.util.*;

/**
 * Created by v-zhoguo on 7/19/2016.
 */
public class GroupAnagrams {
    public static void main(String[] args){
        GroupAnagrams ga = new GroupAnagrams();
        System.out.print(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    public List<List<String>> groupAnagrams_1(String[] strs) {

        int length = strs.length;
        LinkedList<List<String>> res = new LinkedList<List<String>>();
        HashMap<String, Integer> record = new HashMap<String, Integer>();
        int count = 0;
        for (int i =0; i< strs.length; i++){
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String ns = new String(s);
            if (record.containsKey(ns)){
                int index = record.get(ns);
                res.get(index).add(strs[i]);
            }else {
                record.put(ns, count);
                List<String> re = new LinkedList<String>();
                re.add(strs[i]);
                res.add(count, re);
                count++;
            }
        }
        return res;
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        int length = strs.length;
        LinkedList<List<String>> res = new LinkedList<List<String>>();
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        int count = 0;
        for (String s : strs){
            int key = transfer(s);
            if (record.containsKey(key)){
                res.get(record.get(key)).add(s);
            }else {
                record.put(key, count);
                List<String> re = new LinkedList<String>();
                re.add(s);
                res.add(count, re);
                count++;
            }
        }
        return res;
    }
    public int transfer (String s ){
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        char[] cs = s.toCharArray();
        int a =1;
        for (char c : cs){
            a *= prime[c-'a'];
        }
        return a;
    }
}
