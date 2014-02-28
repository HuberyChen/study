package pratice.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author hubery.chen
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) {
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
}
