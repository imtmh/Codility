package com.verifi.security.hmac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.pega.UTCTimeGeneration;

public class Test {
	public static void main(String[] args) {
		HmacSHA1 hmac = new HmacSHA1();
		String encryptionKey = "9jdW2jdH";

		String str = "<case xmlns=\"http://api.issuer.cdrn.com/domain\"><number>D-1</number><type>DISPUTE</type><status>OPEN</status></case>";
		String strToSign = "POST" + "\n" + "api.testing.cdrn.com" + "\n"
				+ "/issuers/cases" + "\n" + str + "\n" + "1.0" + "\n" + "1340"
				+ "\n" + UTCTimeGeneration.getUTCTime() + "\n";
		// Base64.encodeBase64String(hmac.calculate(data.toString(),
		// encryptionKey).getBytes());
		StringBuilder data = new StringBuilder();
		data.append(strToSign);
		try {
			System.out.println("output: "
					+ com.sun.org.apache.xml.internal.security.utils.Base64
							.encode(hmac.calculate(data.toString(),
									encryptionKey).getBytes()));
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
