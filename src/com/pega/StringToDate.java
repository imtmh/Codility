package com.pega;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {
	public static void main(String[] args) {
		String inpStr = "2012-12-12Z";
		System.out.println(getTheDate(inpStr));
	}

	private static String getTheDate(String inpStr) {

		SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");

		String reformattedStr ="";
		try {
			reformattedStr = myFormat.format(fromUser.parse(inpStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reformattedStr;
	}
}
