package pratice.date;

import com.quidsi.core.util.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author hubery.chen
 */
public class SimpleDateFormatTest {

    @Test
    public void test() {
        Date date = new Date(1359641834000L);// 2013-1-31 22:17:14
        String dateStr = "2014-02-20 10:43:55";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date dateTmp = dateFormat.parse(dateStr);
            System.out.println(dateTmp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateStrTmp = dateFormat.format(date);
        System.out.println(dateStrTmp);
    }

    @Test
    public void setDateTest() {
        String dateStr = "2014-02-20";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateTmp = dateFormat.parse(dateStr);
            System.out.println(dateTmp);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateTmp);
            calendar.set(Calendar.HOUR_OF_DAY, DateUtils.getHour(new Date()));
            calendar.set(Calendar.MINUTE, DateUtils.getMinute(new Date()));
            System.out.println(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
