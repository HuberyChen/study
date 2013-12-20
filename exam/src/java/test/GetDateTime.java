package java.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetDateTime {

    @Test
    public void test() {
        String startDate = "11/25/2013";
        String endDate = "11/26/2013";

        List<String> dates = new ArrayList<>();
        Date start = stringConverToDate(startDate);
        Date end = stringConverToDate(endDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dates.add(sdf.format(start));
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        boolean bContinue = true;
        while (bContinue) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            if (end.after(cal.getTime())) {
                dates.add(sdf.format(cal.getTime()));
            } else {
                break;
            }
        }
        dates.add(sdf.format(end));
    }

    @Test
    public void convertToDate() {
        String date = "2013-11-04";
        SimpleDateFormat sdfChrome = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = null;
        try {
            dateFormat = sdfChrome.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(dateFormat.toString());
    }

    private Date stringConverToDate(String date) {
        String[] dateMessage = date.split("/");
        return new Date(Integer.parseInt(dateMessage[2]), Integer.parseInt(dateMessage[0]), Integer.parseInt(dateMessage[1]));
    }
}
