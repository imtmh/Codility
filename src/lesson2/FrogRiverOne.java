package lesson2;

import java.util.*;

public class FrogRiverOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] A = { 1, 2, 3, 4, 5, 6 };
		// int[] A = { 1, 2, 3, -1, -2, -3, 4 };

	}

	public int solution(int X, int[] A) {
		// write your code in Java SE 8
		Set<Integer> tempSet = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {

			if (A[i] <= X)
				tempSet.add(A[i]);
			if (tempSet.size() == X) {
				return i;
			}
		}
		return -1;
	}
}