package com.ds.linkedlist;

import java.util.LinkedList;

public class ZeroOnesSort {
	public static void main(String[] args) {

		LinkList ls = new LinkList(1);
		ls.next = new LinkList(0);
		ls.next.next = new LinkList(1);
		ls.next.next.next = new LinkList(1);
		ls.next.next.next.next = new LinkList(0);
		ls.next.next.next.next.next = new LinkList(0);

		LinkList temp = ls;
		int zerosOnes;

		for (int i = 1; i < 10; i++) {
			zerosOnes = (int) (Math.random() * 2);
			temp.next = new LinkList(zerosOnes);
			temp = temp.next;
		}

		System.out.println(ls);
		ls = sort(ls);
		System.out.println(ls);
	}

	private static LinkList sort(LinkList ls) {
		LinkList head = ls;
		// will be the first node and is what we are going to return
		LinkList tail = ls; // will be the last node
		LinkList temp;
		LinkList ptr = ls;
		LinkList prev = ls;
		int count = 1;
		while (tail.next != null) {
			tail = tail.next;
			count++;
		}
		for (int i = 0; i < count; i++) {
			temp = ptr;
			ptr = ptr.next;
			if (temp.val == 1) {
				// Inserting at the End.
				tail.next = temp;
				temp.next = null;
				tail = temp;

				// If first Node.
				if (prev == temp)
					head = prev = ptr;
				else
					prev.next = ptr;
			} else {
				if (prev != temp)
					prev = prev.next;
			}
		}
		// tail.next = null;
		return head;
	}

}
