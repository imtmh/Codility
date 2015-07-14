package com.pega;

import java.io.UnsupportedEncodingException;

public class UTF8String {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = new String("b");
		String str2 = new String("a");

		for (byte b : str.getBytes())
			System.out.print(b);
		System.out.println();
		for (byte b : str2.getBytes("UTF-8"))
			System.out.print(b);
	}

}
