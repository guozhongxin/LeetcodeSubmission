package LeetCode;

import utils.ListNode;

/**
 * Created by v-zhoguo on 7/10/2016.
 */
public class MergeKSortedLists {
    public static void main(String[] args){
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        ListNode l13 = new ListNode(5);
        l12.next = l13;
        ListNode l14 = new ListNode(8);
        l13.next = l14;
        ListNode l15 = new ListNode(9);
        l14.next = l15;

        ListNode l21 = new ListNode(4);

        ListNode l22 = new ListNode(6);
        l21.next = l22;
        ListNode l23 = new ListNode(7);
        l22.next = l23;
        ListNode l24 = new ListNode(10);
        l23.next = l24;

        ListNode[] lists = new ListNode[2];
        lists[0] = l11;
        lists[1] = l22;

        ListNode result = mergeKLists(lists);

        System.out.print(result);
    }

    // time limit exceeded
    public static ListNode mergeKLists_1(ListNode[] lists) {
        ListNode prehead = new ListNode(0);
        prehead.next = lists[0];
        ListNode current_node = prehead;
        boolean empty = true;
        do {
            int add_index = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode node_i = lists[i];
                if (node_i != null) {
                    if (current_node.next == null) {
                        current_node.next = node_i;
                        add_index = i;
                    } else if ( node_i.val <= current_node.next.val) {
                        current_node.next = node_i;
                        add_index = i;
                    }
                }
            }

            if (current_node.next != null) {
                lists[add_index] = lists[add_index].next;
                current_node = current_node.next;
            }else {
                break;
            }
            empty = true;
            for (ListNode node : lists){
                if (node!=null){
                    empty = false;
                    break;
                }
            }
        }while (!empty);
        return  prehead.next;
    }

    // merge sort!  68.9%
    public static ListNode mergeKLists(ListNode[] lists){
        if (lists.length==0)
            return null;
        return  partition(lists, 0 , lists.length-1);
    }

    private static ListNode partition(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        int middle = (left+right)>>1;
        ListNode l1 = partition(lists, left, middle);
        ListNode l2 = partition(lists, middle+1, right);
        return mergeTwo(l1,l2);
    }

    private static ListNode mergeTwo(ListNode l1, ListNode l2) {
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

    //
}
