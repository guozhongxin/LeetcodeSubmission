package LeetCode;

import utils.ListNode;

/**
 * Created by dell on 2016/9/12.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int gap = Math.abs(lenA-lenB);
        int con = Math.min(lenA, lenB);
        ListNode first, second;
        if (lenA> lenB){
            first = headA;
            second = headB;
        }else {
            first = headB;
            second = headA;
        }
        while (gap!=0){
            first = first.next;
            gap--;
        }
        while (con!=0){
            if (first== second){
                return first;
            }
            first= first.next;
            second = second.next;
            con--;
        }
        return null;
    }
    private int getLength(ListNode head){
        int len = 0;
        while (head!=null){
            head= head.next;
            len++;
        }
        return len;
    }

}
