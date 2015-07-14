package com.verifi.security.hmac;

/**
 * class for SHA1 HMAC encryption Algorithm
 */
public class HmacSHA1 extends Hmac {

	/**
	 * HMAC SHA1 algorithm name
	 */
	public static final String ALGORITHM = "HmacSHA1";

	/**
	 * @see com.verifi.security.hmac.Hmac#getHmacAlgorithm()
	 */
	@Override
	public String getHmacAlgorithm() {
		return ALGORITHM;
	}
}
