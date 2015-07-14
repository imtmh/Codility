package com.practice;

public class EquilibriumIndexOfArray {

	public static void main(String[] args) {
		int[] A = new int[8];
		A[0] = -1;
		A[1] = 3;
		A[2] = -4;
		A[3] = 5;
		A[4] = 1;
		A[5] = -6;
		A[6] = 2;
		A[7] = 1;
		getEquiliElement(A);

	}

	private static void getEquiliElement(int[] A) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int a : A)
			sum += a;
		sum = sum - A[0];
		int sum2 = 0;
		for (int i = 0; i < A.length - 1; i++) {
			int b = A[i];
			sum2 += b;
			sum -= A[i + 1];
			//System.out.println(i + ": sum:	" + sum + "	sum2:	" + sum2);
			if (sum2 == sum)
				System.out.println(i + 1);
		}
	}
}
