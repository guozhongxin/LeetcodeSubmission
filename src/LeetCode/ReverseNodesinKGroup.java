package LeetCode;

import utils.ListNode;

/**
 * Created by dell on 2016/7/12.
 */
public class ReverseNodesinKGroup {
    public static void main(String[] args){
        ReverseNodesinKGroup r = new ReverseNodesinKGroup();
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        ListNode l14 = new ListNode(4);
        l13.next = l14;
        ListNode l15 = new ListNode(5);
        l14.next = l15;
        r.reverseKGroup(l11, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k ==1 || k == 0){
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode kthNode = getkth(pre,k);
        while (kthNode != null){
            pre = reverseK(pre, kthNode, k);
            kthNode = getkth(pre, k);
        }
        return preHead.next;
    }

    private ListNode reverseK(ListNode pre, ListNode kthNode, int k) {
        ListNode nextpre = pre.next ;
        ListNode current = pre.next;
        ListNode next = current.next;
        ListNode end = kthNode.next;
        for (int i =0; i< k; i++){
            next = current.next;
            current.next = end;
            end = current;
            current = next;
        }
        pre.next = end;
        return nextpre;
    }

    private ListNode getkth(ListNode pre, int k) {
        ListNode c = pre.next;
        for(int i=0; i<k-1;i++){
            if (c!=null){
                c = c.next;
            }else {
                return null;
            }
        }
        return  c;
    }

}
