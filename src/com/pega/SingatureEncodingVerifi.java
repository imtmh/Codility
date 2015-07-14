package com.pega;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class SingatureEncodingVerifi {
	public static void main(String[] args) {
		String str = "<case xmlns=\"http://api.issuer.cdrn.com/domain\"><number>D-1</number><type>DISPUTE</type><status>OPEN</status></case>";
		String strToSign = "POST" + "\n" + "api.testing.cdrn.com" + "\n"
				+ "/issuers/cases" + "\n" + str + "\n" + "1.0" + "\n" + "1340"
				+ "\n" + UTCTimeGeneration.getUTCTime() + "\n";
		System.out.println("String to sign::::" + strToSign);
		System.out.println(getUTCTime("9jdW2jdH", strToSign));
	}

	/*
	 * 1.0 1340 2015-04-01T08:45:54Z
	 */
	private static String getUTCTime(String secret, String data) {

		byte[] secretBytes = null;
		byte[] datatBytes = null;
		SecretKey key = null;
		Mac m = null;
		try {
			secretBytes = secret.getBytes("UTF8");
			datatBytes = data.getBytes("UTF8");
			key = new SecretKeySpec(secretBytes, "HmacSHA1");
			m = Mac.getInstance("HmacSHA1");
			m.init(key);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hmacSha1 = m.doFinal(datatBytes);
		System.out.println(new String(hmacSha1));
		Encoder ec = Base64.getEncoder();
		System.out.println("second::: " + new String(ec.encode(hmacSha1)));
		return com.sun.org.apache.xml.internal.security.utils.Base64
				.encode(hmacSha1);
	}
}
