package les2;

public class FrogJmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] A = { 1, 2, 3, 4, 5, 6 };
		//int[] A = { 1, 2, 3, -1, -2, -3, 4 };

		FrogJmp sol = new FrogJmp();
		System.out.println(sol.solution(10, 101, 30));
	}

	public int solution(int X, int Y, int D) {
		// write your code in Java SE 8
		int diff = Y - X;
		int reminder = diff % D;

		int add = 0;
		add = reminder == 0 ? 0 : 1;

		return Y / D + add;
	}
}
