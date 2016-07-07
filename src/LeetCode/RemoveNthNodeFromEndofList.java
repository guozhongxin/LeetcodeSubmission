package LeetCode;

/**
 * Created by v-zhoguo on 7/5/2016.
 */
public class RemoveNthNodeFromEndofList {

     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
     }
    public static void main(String[] args){

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        if(ahead == null){
            return null;
        }
        for (int i = 1; i<=n; i++){   // i<=n  : pre points the N+1 th node from end of list
            ahead = ahead.next;
            if (ahead == null){
                return head.next;
            }
        }
        ListNode pre = head;
        while (ahead.next!=null){
            ahead = ahead.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
