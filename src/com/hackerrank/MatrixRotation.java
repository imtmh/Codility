package com.hackerrank;

import java.util.*;

public class MatrixRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] km = new int[5][3];
		for (int[] i : km) {
			for (int j : i) {
				System.out.print(j);
			}
			System.out.println();
		}

		int a = sc.nextInt();
		int b = sc.nextInt();
		int r = sc.nextInt();
		int[][] m = new int[a][b];
		int[][] n = new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		int min = Math.min(a, b);
		int cr = 0;
		for (int i = 0; i < min / 2; i++) {
			cr = 2 * (a + b - 2);
			int tempR = r % cr;
			int ta = 0;
			int tb = 0;
			if (tempR < a) {
				ta = i;
				tb = cr;
			} else if (tempR < a + b - 1) {
				ta = a - 1;
				tb = cr - i - a + 1;
			} else if (tempR < (2 * a + b - 2)) {
				ta = cr - a - b + 2;
				tb = b - 1-i;
			} else if (tempR < (2 * (a + b) - 3)) {
				ta = cr - i - 2 * a - b + 3;
				tb = i;
			}

			if (cr < a)

				System.out.println(i);
		}
		System.out.println(m.length);
	}
}