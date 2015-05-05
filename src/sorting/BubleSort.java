package sorting;

public class BubleSort {

	public static void main(String[] args) {
		int[] A = { 3, 7, 4, 9, 5, 2, 6, 1 };
		long startTime = System.nanoTime();
		int[] B = solution(A);
		long endTime = System.nanoTime();
		for (int i : B)
			System.out.println(i + ",");
		System.out.println("time taken :"+(endTime - startTime));
	}

	public static int[] solution(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 1; j < A.length - i; j++) {
				if (A[j - 1] > A[j]) {
					int temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				}
			}

		}
		return A;
	}

}
