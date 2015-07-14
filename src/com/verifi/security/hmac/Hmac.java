package com.verifi.security.hmac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * Base class for HMAC encryption Algorithm
 */
public abstract class Hmac {

	/**
	 * Calculate HMAC from data and secret key
	 * 
	 * @param data
	 *            data content
	 * @param key
	 *            secret key
	 * @return HMAC string
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public String calculate(String data, String key)
			throws NoSuchAlgorithmException, InvalidKeyException {

		byte[] keyBytes = key.getBytes();

		SecretKey sk = new SecretKeySpec(keyBytes, getHmacAlgorithm());

		/*
		 * Get an HMAC Mac instance and initialize with the secret key
		 */
		Mac mac = Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);

		/*
		 * Compute the HMAC on input data bytes
		 */
		byte[] rawHmac = mac.doFinal(data.getBytes());

		return Hex.encodeHexString(rawHmac);
	}

	protected abstract String getHmacAlgorithm();
}
