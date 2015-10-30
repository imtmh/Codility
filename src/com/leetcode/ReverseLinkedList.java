package com.leetcode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode temp = new ListNode(1);
		ListNode tempy = temp;
		for (int i = 2; i < 14; i++) {
			ListNode t = new ListNode(i);
			tempy.next = t;
			tempy = tempy.next;
		}
		System.out.println(temp);
		temp = reverseList(temp);
		System.out.println(temp);
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
}
