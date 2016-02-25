
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class AllCombOfString {
	public static void main(String[] args) {
		// doActionChinna("kincenvizh");
		doActionChinna("kincenvizh");
	}

	public static void doActionChinna(String s) {
		int count = 0;
		int len = s.length();
		Set<String> set = new HashSet<String>();
		for (int i = s.length(); i > 0; i--) {
			set.add("" + s.charAt(i - 1));
		}
		count = ((len * (len + 1)) / 2) - (len - set.size());
		System.out.println(count);
	}

	public static void doActionChaitu(String s) {

		String st = null;
		Set<String> set = new HashSet<String>();
		for (int i = s.length(); i > 0; i--) {
			System.out.println(i);
			st = s.substring(0, i);
			System.out.println(st);
			for (int j = st.length(); j > 0; j--) {
				set.add(st.substring(0, j));
			}
			s = s.substring(1, s.length());
			System.out.println(s);
		}
		System.out.println(set.size());
	}
}

class Combinations {
	private StringBuilder output = new StringBuilder();
	private final String inputstring;
	static int count = 0;
	public Combinations(final String str) {
		inputstring = str;
		System.out.println("The input string  is  : " + inputstring);
	}

	public static void main(String args[]) {
		Combinations combobj = new Combinations("aaaa");
		System.out.println("");
		System.out.println("");
		System.out.println("All possible combinations are :  ");
		System.out.println("");
		System.out.println("");
		System.out.println(" 1 "+ count);
		combobj.combine();
		System.out.println(" 3 "+ count);
	}

	public void combine() {
		combine(0);
		System.out.println(" 2 "+ count);
	}

	private void combine(int start) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			count++;
			System.out.println(output);
			if (i < inputstring.length())
				combine(i + 1);
			count++; output.setLength(output.length() - 1);
		}
	}
}