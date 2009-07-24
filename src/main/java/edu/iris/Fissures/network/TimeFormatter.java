package edu.iris.Fissures.network;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import edu.iris.Fissures.Time;
import edu.iris.Fissures.model.ISOTime;
import edu.iris.Fissures.model.MicroSecondDate;

/**
 * @author groves Created on Oct 28, 2004
 */
public class TimeFormatter {

	
    public static synchronized String format(Time t) {
        return formatter.format(new MicroSecondDate(t));
    }

    private static final DateFormat formatter;

	static {
		formatter = new SimpleDateFormat(ISOTime.patterns[3]);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
}