package lesson2;

import java.util.Arrays;

public class MaxCounters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] A = { 1, 2, 3, 4, 5, 6 };
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };

		MaxCounters sol = new MaxCounters();
		sol.solution(5, A);
	}

	public int[] solution(int N, int[] A) {
		int[] B = new int[N];
		int maxVal = 0;
		for (int i : A) {
			if (i > N) {
				Arrays.fill(B, maxVal);
			} else {
				B[i - 1] = B[i - 1] + 1;
				if (maxVal < B[i - 1]) {
					maxVal = B[i - 1];
				}
			}
		}
		return B;
	}
}