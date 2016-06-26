package LeetCode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by gzx on 2015/9/7.
 */

public class TwoSum {
    /**O(n2) runtime, O(1) space �C Brute force:
     * The brute force approach is simple. Loop through each element x
     * and find if there is another value that equals to target �C x.
     * As finding another value requires looping through the rest of array,
     * its runtime complexity is O(n2).
     */
    public class Solution_1 {
        public int[] twoSum(int[] nums, int target) {
            int length = nums.length;
            int[] answer= new int[2];
            for (int i=0; i<length-1; i++){
                for (int j=i+1; j<length; j++){
                    if ((nums[i] + nums[j])==target){
                        answer[0]=i+1;
                        answer[1]=j+1;
                    }
                }
            }
            return  answer;
        }
    }

    /**O(n) runtime, O(n) space �C Hash table:
     * We could reduce the runtime complexity of looking up a value to O(1)
     * using a hash map that maps a value to its index.
     */
    /*���׳���ĵ㣺
        1. index��������ŵ�����������ĳ�����������i��j��+1���������Ҫô���������ţ�Ҫô����index����Ҫ������
        2. hashtable��hashmap�����𣡣�����
        3. ���ǵ�������valueֵ���ܳ�����ͬ���������
     */
    public class Solution_2 {
        public int[] twoSum(int[] nums, int target) {
            int length = nums.length;
            int[] answer= new int[2];

            Hashtable<Integer,Integer> hm = new Hashtable<Integer, Integer>();
            for(int i = 0; i<length; i++){
                hm.put(nums[i], i);
            }
            for(int i=0; i<length;i++){

                if (hm.containsKey(target-nums[i]) && hm.get(target-nums[i])>i){
                    answer[1] = hm.get(target-nums[i])+1;
                    answer[0] = i+1;
                }
            }
            return answer;
        }
    }


    /*
    �ϲ�����ѭ��
     */
    public class Solution_3 {
        public int[] twoSum(int[] nums, int target) {
            int length = nums.length;
            int[] answer= new int[2];

            Hashtable<Integer,Integer> hm = new Hashtable<Integer, Integer>();
            for(int i = 0; i<length; i++){
                if (hm.containsKey(target-nums[i])){
                    answer[0] = hm.get(target-nums[i])+1;
                    answer[1] = i+1;
                    return answer;
                }
                hm.put(nums[i], i);
            }

            return answer;
        }
    }

}
