package LeetCode;

/**
 * Created by v-zhoguo on 7/7/2016.
 */
public class MergeTwoSortedLists {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(0);
        ListNode head = new ListNode(0);
        preHead.next = head;
        while (l1 != null & l2 !=null){
            int newv = 0;
            if (l1.val < l2.val){
                newv  = l1.val;
                l1 = l1.next;
            }else {
                newv = l2.val;
                l2 = l2.next;
            }
            ListNode nextl = new ListNode(newv);
            head.next = nextl;
            head = nextl;
        }
        if (l1 == null)
            head.next = l2;
        if (l2 == null )
            head.next = l1;
        return preHead.next.next;
    }
}
