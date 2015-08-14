package org.coursera.algs4partI.week1;

import java.util.Scanner;

public class UnionFindTest {
	public static void main(String[] args) {
		System.out.println("Give a num below 10 :)");
		Scanner sc = new Scanner(System.in);
		int firstEntry = sc.nextInt();
		UnionFind uf = new UnionFind(firstEntry);
		uf.union(0, 1);
		uf.union(2, 3);
		uf.union(4, 5);
		uf.union(6, 7);
		uf.union(8, 9);
		uf.print();
		uf.union(5, 6);
		uf.print();
		sc.close();
	}

}
