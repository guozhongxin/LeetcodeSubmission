package LeetCode;

import utils.ListNode;

/**
 * Created by guozhongxin on 16/7/11.
 */
public class SwapNodesOInPairs {
	public static void main(String[] args) {
		SwapNodesOInPairs sp = new SwapNodesOInPairs();
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		l11.next = l12;
		ListNode l13 = new ListNode(5);
		l12.next = l13;
		ListNode l14 = new ListNode(8);
		l13.next = l14;
		ListNode l15 = new ListNode(9);
		l14.next = l15;
		ListNode l = sp.swapPairs(l11);
		System.out.println(l);
	}
	public ListNode swapPairs(ListNode head) {
		if (head==null || head.next == null)
			return head;
		ListNode pre = new ListNode(0);
		ListNode ans = pre;
		pre.next = head;
		ListNode current = head;
		ListNode next = head.next;

		while (current !=null && next !=null){
			pre.next = next;
			current.next = next.next;
			next.next = current;

			pre = current;
			current = current.next;
			if (current != null){
				next = current.next;
			}
		}
		return ans.next;
	}
}
