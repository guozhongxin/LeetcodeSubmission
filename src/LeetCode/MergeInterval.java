package LeetCode;

import java.util.*;

/**
 * Created by dell on 2016/7/29.
 */
public class MergeInterval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

    }
    public static void main(String[] args){
        List<Interval> is = new LinkedList<Interval>();
        is.add(new Interval(1,4));
        is.add(new Interval(1,4));
        merge(is);

    }
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        Map<Integer, Integer> flags = new HashMap<Integer, Integer>();
        int[] flagInt = new int[intervals.size()*2];
        int i = 0;
        for (Interval interval : intervals){
            int start = interval.start;
            int end = interval.end;
            flagInt[i++]= start;
            flagInt[i++]=end;
            flags.put(start, ((flags.containsKey(start)? flags.get(start):0)+1));
            flags.put(end, ((flags.containsKey(end)? flags.get(end):0)-1));
        }
        Arrays.sort(flagInt);
        int count = 0;
        int cstart = 0;
        int cend =0;
        for (int j = 0; j < flagInt.length ; j++){
            if (j !=0 && flagInt[j]==flagInt[j-1]){
                continue;
            }
            int se = flagInt[j];
            int flag = flags.get(se);
            if (flag == 0){
                continue;
            }else if (flag >=1){
                if (count ==0){
                    cstart = se;
                }
                count+=flag;

            }else if (flag <=-1){
                count+=flag;
                if (count ==0 ){
                    cend = se;
                    res.add(new Interval(cstart, cend));
                }
            }
        }

        return res;
    }

//    public List<Interval> merge_1(List<Interval> intervals) {
//        Collections.sort(intervals, (a, b) -> a.start - b.start);
//        List<Interval> r = new ArrayList<>();
//        for(Interval curr : intervals){
//            if(r.size() == 0 || curr.start > r.get(r.size() - 1).end)
//                r.add(new Interval(curr.start, curr.end));
//            else
//                r.get(r.size() - 1).end = Math.max(r.get(r.size() - 1).end, curr.end);
//        }
//        return r;
//    }
}
