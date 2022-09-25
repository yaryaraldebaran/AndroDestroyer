package coid.nexsoft.app;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class tryLocationTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeZone timeZone1 = TimeZone.getTimeZone("Europe/London");
		TimeZone timeZone2 = TimeZone.getTimeZone("Europe/Copenhagen");
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone(timeZone1);
		long timeCPH = calendar.getTimeInMillis();
		System.out.println("timeCPH  = " + timeCPH);
		System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("menit     = " + calendar.get(Calendar.MINUTE));
		System.out.println("arek-arek     = " + calendar.get(Calendar.SECOND));

		calendar.setTimeZone(timeZone2);
		System.out.println("====================================================");
		long timeLA = calendar.getTimeInMillis();
		System.out.println("timeLA   = " + timeLA);
		System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));
	}

}
