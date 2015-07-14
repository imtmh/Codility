package com.verifi.security.hmac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.pega.UTCTimeGeneration;

public class CopyOfTest {
	public static void main(String[] args) {
		
		String verifiPost = "POST" + "\n" 
				+ "api.testing.cdrn.com" + "\n" 
				+ "/issuers/cases" + "\n" 
				+ "<case xmlns=\"http://api.issuer.cdrn.com/domain\"><type>DISPUTE</type><acquirerReferenceNumber>24610442650004053098988</acquirerReferenceNumber><referenceTransactionDate>2015-04-02</referenceTransactionDate><referenceTransactionAmount>35.22</referenceTransactionAmount><referenceTransactionCurrency>USD</referenceTransactionCurrency><number>D-143</number><date>2015-05-15</date><amount>35.22</amount><currency>USD</currency><reasonCode>30</reasonCode><paymentType>VI</paymentType><accountNumber>435299xxxxxx9999</accountNumber><bin>435299</bin><lastFour>9999</lastFour><networkDescriptor>Swiss Hotel</networkDescriptor><uniqueMerchantIdentifier>25076899</uniqueMerchantIdentifier><generationTimestamp>2015-05-15T10:00:59.122Z</generationTimestamp></case>" + "\n" 
				+ "1.0" + "\n" 
				+ UTCTimeGeneration.getUTCTime() + "\n";
		String verifiReadGet = "GET" + "\n" 
				+ "api.testing.cdrn.com" + "\n" 
				+ "/issuers/cases" + "\n" 
				+ "caseId=1739260,1786213" + "\n" 
				+ "1.0" + "\n" 
				+ UTCTimeGeneration.getUTCTime() + "\n";
		String verifiReadGet1 = "GET" + "\n" 
				+ "api.testing.cdrn.com" + "\n" 
				+ "/issuers/cases/2721277" + "\n" 
				+ "" + "\n" 
				+ "1.0" + "\n" 
				+ UTCTimeGeneration.getUTCTime() + "\n";
		String encryptionKey = "9jdW2jdH";
		StringBuilder data = new StringBuilder();
		data.append(verifiReadGet1);
		System.out.println(allInPlace(data.toString(), encryptionKey));
	}

	private static String allInPlace(String data, String secret)/*
			throws NoSuchAlgorithmException, InvalidKeyException*/ {
		
		System.out.println(data);
		final String ALGORITHM = "HmacSHA1";
		byte[] keyBytes = secret.getBytes();
		javax.crypto.SecretKey sk= new javax.crypto.spec.SecretKeySpec(keyBytes, ALGORITHM);
		javax.crypto.Mac mac;
		byte[] rawHmac = null ;
		try {
			mac = javax.crypto.Mac.getInstance(sk.getAlgorithm());
			mac.init(sk);
			rawHmac = mac.doFinal(data.getBytes());
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String hexBytes = org.apache.commons.codec.binary.Hex.encodeHexString(rawHmac);
		return com.sun.org.apache.xml.internal.security.utils.Base64
				.encode(hexBytes.getBytes());
	}
}
