package com.leetcode;

public class ListNode {
	int value;
	ListNode next;

	public ListNode(int val) {
		value = val;
	}

	@Override
	public String toString() {
		String str = " " + value + " -> ";
		ListNode temp = next;
		while (temp != null) {
			str = str + "" + temp.value + " -> ";
			temp=temp.next;
		}
		return str + "null ";
	}

}
