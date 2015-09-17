/**
 * Created by guozhongxin on 15/9/7.
 */
/*
* Definition for singly-linked list.
*/


public class Solution {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l,ln1, lnext;
		int a =0;
		int val = l1.val + l2.val + a;
		if (val>=10){
			a=1;
			ln1= new ListNode(val-10);
		} else {
			a=0;
			ln1 = new ListNode(val);
		}
		l=ln1;
		l1=l1.next;
		l2=l2.next;
		while(l1!=null && l2!=null){

			val = l1.val + l2.val + a;
			if (val>=10){
				a=1;
				lnext= new ListNode(val-10);
			} else {
				a=0;
				lnext = new ListNode(val);
			}
			l.next=lnext;
			l1=l1.next;
			l2=l2.next;
		}
		if (l1==null && l2!=null){
			l = l2;
			l.val=l.val+a;
		}
		if (l2==null && l1!=null){
			l = l1;
			l.val=l.val+a;
		}
		if (l1==null && l2==null && a==1){
			lnext = new ListNode(1);
			l.next =lnext;
		}

		return ln1;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		System.out.println(addTwoNumbers(l1,l1).next.val);
	}
}