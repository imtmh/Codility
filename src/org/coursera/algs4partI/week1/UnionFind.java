package org.coursera.algs4partI.week1;

public class UnionFind {
	private int[] array;

	public UnionFind(int n) {
		array = new int[10];
		for (int i = 0; i < n; i++) {
			array[i] = i;
		}
	}

	public void print() {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

	void union(int i, int j) {
		if (i < j) {
			unify(i, j);
		} else {
			unify(j, i);
		}
	}

	private void unify(int i, int j) {
		array[j] = array[i];
	}

	boolean isConnected(int i, int j) {
		return false;
	}
}
