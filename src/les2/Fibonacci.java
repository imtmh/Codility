package les2;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getFib(10));
	}

	private static int getFib(int n) {
		int num0 = 0;
		int num1 = 1;
		if (n == 0) {
			return num0;
		}
		if (n == 1) {
			return num1;
		} else {
			int sum = 0;
			for (int i = 2; i <= n; i++) {
				sum = num0 + num1;
				num0 = num1;
				num1 = sum;
			}
			return sum;
		}
	}
}
