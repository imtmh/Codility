package com.pega;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UTCTimeGeneration {
	public static void main(String[] args) {
		getUTCTime();
	}

	public static String getUTCTime() {
		final Date currentTime = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		c2.setTime(currentTime);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println("UTC time: " + sdf.format(currentTime));
		return sdf.format(c2.getTime());

	}
}
