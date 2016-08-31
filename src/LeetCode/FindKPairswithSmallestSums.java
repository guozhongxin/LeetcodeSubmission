package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dell on 2016/8/6.
 */
public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<int[]>();
        if (nums1.length<1 || nums2.length<1){
            return res;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        int[] firstPointer = new int[nums1.length];
        Arrays.fill(firstPointer, -1);
        int[] secondPointer = new int[nums2.length];
        Arrays.fill(secondPointer, -1);
        int[] firstPair = new int[]{nums1[0], nums2[0]};
        res.add(firstPair);
        firstPointer[0] =0;
        secondPointer[0] =0;
        int i=1;
        while (firstIndex<nums1.length && secondIndex< nums2.length && i<k){
            if (firstPointer[firstIndex] == nums2.length-1 && firstIndex<nums1.length){
                firstIndex++;
            }
            if(secondPointer[secondIndex]== nums1.length-1 && secondIndex < nums2.length){
                secondIndex++;
            }
            int p1 = nums1[firstIndex] + nums2[firstPointer[firstIndex]+1];
            int p2 = nums2[secondIndex] + nums1[secondPointer[secondIndex]+1];
            if (p1>p2){
                int[] newPair = new int[]{nums2[secondIndex], nums1[secondPointer[secondIndex]+1]};
                secondPointer[secondIndex] ++;
                firstPointer[secondPointer[secondIndex]] = secondIndex;
                res.add(newPair);
                i++;
            }else {
                int[] newPair = new int[]{nums1[firstIndex] , nums2[firstPointer[firstIndex]+1]};
                firstPointer[firstIndex] ++;
                secondPointer[firstPointer[firstIndex]] =firstIndex;
                res.add(newPair);
                i++;
            }
        }

        return res;
    }
}
