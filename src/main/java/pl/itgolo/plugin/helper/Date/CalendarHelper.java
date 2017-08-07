package pl.itgolo.plugin.helper.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;

/**
 * Created by ITGolo on 04.03.2017.
 */
public class CalendarHelper {

    /**
     * Get string datetime from calendar instance
     *
     * @param calendar calendar instance
     * @param pattern  pattern of string datetime
     * @return datetime for pattern
     */
    public static String toString(java.util.Calendar calendar, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(calendar.getTimeInMillis());
    }

    /**
     * Get string datetime now
     *
     * @param pattern  pattern of string datetime
     * @return datetime for pattern
     */
    public static String toString(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(java.util.Calendar.getInstance().getTimeInMillis());
    }

    /**
     * Parse string to calendar instance
     *
     * @param datetime datetime
     * @param pattern  pattern
     * @return calendar instance
     */
    public static java.util.Calendar toCalendar(String datetime, String pattern) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        DateTime dtf = DateTimeFormat.forPattern(pattern).parseDateTime(datetime);
        calendar.setTimeInMillis(dtf.getMillis());
        return calendar;
    }
}