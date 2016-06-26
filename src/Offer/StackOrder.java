package Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by v-zhoguo on 6/19/2016.
 */
public class StackOrder {
    public static boolean judgeStackOrder(int[] pushOrder, int[] popOrder){
        boolean isOrder = false;
        Stack<Integer> stack = new Stack<Integer>();
        int pushLength = pushOrder.length;
        int popLength = popOrder.length;
        if (pushLength < popLength || pushLength == 0){
            return isOrder;
        }
        int nextPop = 0 ;
        int nextPush = 0 ;
        while ( nextPop < popLength ){
            if (stack.empty() ||stack.peek() != popOrder[nextPop]){
                if (nextPush<= pushLength-1){
                    stack.push(pushOrder[nextPush++]);
                }else {
                    return false;
                }

            }else if (stack.peek()==popOrder[nextPop]){
                stack.pop();
                nextPop++;
            }
        }
        isOrder = true;

        return isOrder;
    }
    public static void main(String[] args){

        int[] pushOrder = {1,2,3,2,4,3,5,7};
        int[] popOrder = {3,4,2,7,5,3,2,1};

        System.out.println(judgeStackOrder(pushOrder, popOrder));

    }
}
