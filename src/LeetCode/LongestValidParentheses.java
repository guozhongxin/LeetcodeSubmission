package LeetCode;

import java.util.Stack;

/**
 * Created by v-zhoguo on 7/14/2016.
 */
public class LongestValidParentheses {
    public static void main(String[] args){
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.print(lvp.longestValidParentheses("()"));
    }
    public int longestValidParentheses_1(String s) {
        int length = s.length();
        if(length==0){
            return 0;
        }
        int[] status = new int[length];
        int start = 0;
        int end = length-1;
        while (s.charAt(start)==')' && start<length-1){
            start++;
        }
        while (s.charAt(end) =='(' && end>0){
            end--;
        }
        if (start >= end ) {
            return 0;
        }
        status[start] = 1;
        int max = 1;
        for (int i = start+1; i<=end; i++){
            if (s.charAt(i)== '('){
                status[i] = status[i-1]+1;
            }else {
                status[i] = status[i-1]-1;
                int j = i-1;
                for (; j>=start; j--){
                    if (status[j] < status[i]){
                        break;
                    }
                }
                if (j == start-1 ){
                    if(status[i] == 0){
                        if (max< i-start+1){
                            max = i-start+1;
                        }
                    }else if (status[i] == 1){
                        if (max< i-start){
                            max = i-start;
                        }
                    }
                }else if (status[j]< status[i]){
                    if (max< i-j-1){
                        max = i-j-1;
                    }
                }else if (j == start){

                }

            }
        }
        return max;
    }

    public int longestValidParentheses(String s){
        int length = s.length();
        int max =0;
        int currentl = 0;

        if(length==0){
            return 0;
        }
        int start = 0;
        int end = length-1;
        while (s.charAt(start)==')' && start<length-1){
            start++;
        }
        while (s.charAt(end) =='(' && end>0){
            end--;
        }
        if (start > end ) {
            return 0;
        }

        int[] sl = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = start; i<= end; i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(i);
            }else {
                if (!stack.empty()) {
                    int index = stack.pop();
                    currentl = i - index + 1;
                    if (index != 0) {
                        currentl +=sl[index-1];
                    }
                    sl[i] = currentl;

                    if(currentl> max){
                        max = currentl;
                    }
                }
            }
        }

        return max;
    }
}
