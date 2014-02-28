package pratice.date;

import com.quidsi.core.util.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author hubery.chen
 */
public class CalendarTest {

    public static void main(String[] args) {
        Date date = new Date();
        TimeZone oldZone = TimeZone.getTimeZone("America/New_York");
        TimeZone newZone = TimeZone.getTimeZone("America/Chicago");
        System.out.println(convertTimeZone(date, oldZone, newZone));
        System.out.println(convertSelfTimeZone(date, oldZone, newZone));
    }

    public static Date changeTimeZone(Date date, TimeZone oldZone, TimeZone newZone) {
        Date dateTmp = null;
        if (date != null) {
            int timeOffset = oldZone.getRawOffset() - newZone.getRawOffset();
            dateTmp = new Date(date.getTime() - timeOffset);
        }
        return dateTmp;
    }

    private static Date convertTimeZone(Date target, TimeZone fromTz, TimeZone toTz) {
        Calendar fromCal = Calendar.getInstance(fromTz);
        fromCal.setTime(target);
        Calendar toCal = Calendar.getInstance(toTz);
        toCal.setTime(target);

        System.out.println(fromCal.get(Calendar.DST_OFFSET));
        System.out.println(toCal.get(Calendar.DST_OFFSET));
        System.out.println("-----------------------");

        int offset = toTz.getRawOffset() + toCal.get(Calendar.DST_OFFSET) - fromTz.getRawOffset() - fromCal.get(Calendar.DST_OFFSET);
        Date toDate = DateUtils.add(target, Calendar.MILLISECOND, offset);

        return toDate;
    }

    private static Date convertSelfTimeZone(Date target, TimeZone fromTz, TimeZone toTz) {
        int offset = toTz.getRawOffset() - fromTz.getRawOffset();
        Date toDate = DateUtils.add(target, Calendar.MILLISECOND, offset);

        return toDate;
    }

}
