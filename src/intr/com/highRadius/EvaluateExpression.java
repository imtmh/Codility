package intr.com.highRadius;

import java.util.*;

public class EvaluateExpression {

	public static void main(String[] args) {
		// String str = "(/ 225 25)";//
		String str = "(+ 3 (* 5 2) (- 6 3))"; // "(* 2 (- 7 3) 4)";
		float res = evaluateExpr(str);
		System.out.println((int) res);
	}

	private static float evaluateExpr(String str) {
		char[] ch = str.toCharArray();
		int i = 1;
		char operator = ch[i];
		List<Float> numbers = new ArrayList<Float>();
		for (; i < ch.length; i++) {
			if (ch[i] == ' ') {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			while (Character.isDigit(ch[i])) {
				sb.append(ch[i]);
				i++;
			}
			if (!sb.toString().trim().equals(""))
				numbers.add((float) Integer.parseInt(sb.toString()));
			if (ch[i] == '(') {
				sb = new StringBuilder();
				sb.append(ch[i++]);
				int count = 1;
				while (count != 0) {
					if (ch[i] == '(')
						count++;
					else if (ch[i] == ')')
						count--;
					sb.append(ch[i++]);
				}
				numbers.add(evaluateExpr(sb.toString()));
			}
		}
		return getSol(operator, numbers);
	}

	private static float getSol(char operator, List<Float> numbers) {

		float res = 0;
		if (operator == '+') {
			for (Float i : numbers) {
				res += i;
			}
		} else if (operator == '*') {
			res = 1;
			for (Float i : numbers) {
				res *= i;
			}
		} else if (operator == '-') {
			for (Float i : numbers) {
				res = -(res - i);
			}
			res = -res;
		} else if (operator == '/') {
			float f = 1;
			for (Float i : numbers) {
				f = 1 / (f / i);
			}
			res = 1 / f;
		}
		return res;
	}
}
