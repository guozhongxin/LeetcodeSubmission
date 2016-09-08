package Quiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by dell on 2016/9/5.
 */
public class jd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        while (sc.hasNext()) {
            a = sc.nextInt();
            b = sc.nextInt();
            HashMap<Integer, Integer> records = new HashMap<Integer, Integer>();
            int[] rd = new int[b];
            for (int i = 0; i < b; i++) {
                int d = sc.nextInt();
                rd[i] = d;
                records.put(d, sc.nextInt());
            }
            String res = compute(records,rd, a);
            System.out.println(res);
        }
    }

    private static String compute(HashMap<Integer, Integer> records, int[] ds, int days){
        Arrays.sort(ds);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i< ds.length; i++){
            int curday = ds[i];
            int preday = ds[i-1];
            int curh = records.get(curday);
            int preh = records.get(preday);
            if (curday == preday){
                return "IMPOSSIBLE";
            }
            if ((curday - preday) < Math.abs(curh-preh) ){
                return "IMPOSSIBLE";
            }else {
                int interval = curday-preday;
                int gap = Math.abs(curh-preh);
                int curMax =  (interval - gap)/2 + Math.max(curh, preh);
                if (curMax > max){
                    max = curMax;
                }
            }
        }
        if (ds[0] !=1){
            int curMax = records.get(ds[0]) + ds[0]-1;
            if (curMax > max){
                max = curMax;
            }
        }
        if (ds[ds.length-1] != days){
            int curMax = records.get(ds[ds.length-1]) + (days - ds[ds.length-1]);
            if (curMax > max){
                max = curMax;
            }
        }
        return max+"";
    }
}
