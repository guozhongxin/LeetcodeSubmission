package Quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wtist on 2016/8/2.
 */
public class wangyi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            String src = in.nextLine();
            String des = "235";
            System.out.println(isSub(src,des));
        }
    }

    private static String isSub(String src, String des) {
        Map<Character, Integer> s = new HashMap<Character, Integer>();
        Map<Character, Integer> d = new HashMap<Character, Integer>();
        for(int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if(s.containsKey(c)) {
                s.put(c, s.get(c) + 1);
            }else {
                s.put(c, 1);
            }
        }

        for(int j = 0; j < des.length(); j++) {
            char c = des.charAt(j);
            if(!s.containsKey(c)) {
                return "No";
            }
            if(d.containsKey(c)) {
                d.put(c, d.get(c) + 1);
            }else {
                d.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : d.entrySet()) {
            if(!s.containsKey(entry.getKey())) {
                return "No";
            } else if(s.get(entry.getKey()) < entry.getValue()){
                return "No";
            }
        }
        return "Yes";
    }
}
