package lesson2;

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

	public static void main(String[] args) {
		// int[] A = { 1, 2, 3, 4, 5, 6 };
		int[] A = { 1, 2, 3, -1, -2, -3, 4 };

		Solution sol = new Solution();
		sol.solution(A);
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		int sum1 = 0;
		int sum2 = 0;
		int ans = 0;
		for (int i : A) {
			sum1 += i;
		}
		ans = sum1;
		System.out.println("sum " + sum1);

		for (int j : A) {
			sum2 += j;
			if (ans > Math.abs(sum1 - (2 * sum2)))
				ans = Math.abs(sum1 - (2 * sum2));
		}

		System.out.println("Ans :" + ans);

		return ans;

	}
}
