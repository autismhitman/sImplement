package com.neopane.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ReportTimeFormat {
	
	private ReportTimeFormat() {}
	
	public static String timeCaptured(long time) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date(time);
		return formatter.format(date).replaceAll(":", "_");
	}

}
