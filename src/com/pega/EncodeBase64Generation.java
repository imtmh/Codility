package com.pega;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.*;
import javax.crypto.spec.*;

public class EncodeBase64Generation {
	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException, UnsupportedEncodingException {
		String secret = "OtxrzxIsfpFjA7SwPzILwy8Bw21TLhquhboDYROV";
		String data = "GET\n\n\n\nx-amz-date:Thu, 17 Nov 2005 18:49:58 GMT\nx-amz-magic:abracadabra\n/quotes/nelson";
		System.out.println("Get bytes ::::::::::"+data.getBytes());
		System.out.println(" Get with UTF8:::::::::::"+data.getBytes("UTF8"));
		
		String bt = doHMAC(data.getBytes("UTF8"), secret.getBytes("UTF8"));
		
		System.out.println(bt);
		// Charset.forName("UTF-8").encode(myString)
	}

	// convert from UTF-8 -> internal Java String format
	public static String convertFromUTF8(String s) {
		System.out.println(" BEfore UTF8 :" + s);
		String out = null;
		try {
			out = new String(s.getBytes("ISO-8859-1"), "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			return null;
		}
		System.out.println("After UTF8 :" + out);
		return out;
	}

	// convert from internal Java String format -> UTF-8
	public static String convertToUTF8(String s) {
		System.out.println("BEfore UTF8 :" + s);
		String out = null;
		try {
			out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
		} catch (java.io.UnsupportedEncodingException e) {
			return null;
		}
		System.out.println("After UTF8 :" + out);

		return out;
	}

	static String doHMAC(byte[] data, byte[] secret)
			throws NoSuchAlgorithmException, InvalidKeyException {
		System.out.println("Sign string data: " + new String(data));
		System.out.println("Sign string secret: " + new String(secret));
		System.out.println("data " + data + "\n secret " + secret);
		SecretKey key = new SecretKeySpec(secret, "HmacSHA1");
		Mac m = Mac.getInstance("HmacSHA1");
		m.init(key);
		return byteArrayToHex(m.doFinal(data));
	}
	static byte[] doHMAC(String data, String secret)
			throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		byte[] secretBytes = secret.getBytes("UTF8");
		byte[] datatBytes = data.getBytes("UTF8");

		SecretKey key = new SecretKeySpec(secretBytes, "HmacSHA1");
		Mac m = Mac.getInstance("HmacSHA1");
		m.init(key);
		return m.doFinal(datatBytes );
		}
	
	

	public static String byteArrayToHex(byte[] a) {
		String raw = new String(a);
		System.out.println("Sign string: " +raw);
		//convertToUTF8(raw);
		int hn, ln, cx;
		String hexDigitChars = "0123456789abcdef";
		StringBuffer buf = new StringBuffer(a.length * 2);
		for (cx = 0; cx < a.length; cx++) {
			hn = ((int) (a[cx]) & 0x00ff) / 16;
			ln = ((int) (a[cx]) & 0x000f);
			buf.append(hexDigitChars.charAt(hn));
			buf.append(hexDigitChars.charAt(ln));
		}
		return buf.toString();
	}
}
