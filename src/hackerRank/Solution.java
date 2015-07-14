package hackerRank;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < size; i++) {
			System.out.println(doTheJob(sc.nextLine()));
		}
		sc.close();
	}

	private static int doTheJob(String s) {
		String id = "hackerrank";
		boolean one = false;
		boolean two = false;
		if (s.startsWith(id))
			one = true;
		if (s.endsWith(id))
			two = true;
		if (one && two)
			return 0;
		if (one)
			return 1;
		if (two)
			return 2;
		return -1;
	}
}