package com.ds.linkedlist;

public class LinkList {
	int val;
	LinkList next;

	public LinkList(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		LinkList temp =this;
		while(temp!=null){
			sb.append(temp.val+" -> ");
			temp=temp.next;
		}
		sb.append("null");
		// TODO Auto-generated method stub
		return sb.toString();
	}
}
