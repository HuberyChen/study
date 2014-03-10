package pratice.test;

import au.com.bytecode.opencsv.CSVReader;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InserSQL {

    @SuppressWarnings("resource")
    @Test
    public void test() throws IOException {

        String filePath = "D:\\insert.csv";
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        CSVReader reader = new CSVReader(isr);
        List<String[]> transitTimeList = reader.readAll();
        // Calendar calendar = Calendar.getInstance();
        // calendar.setLenient(false);
        // calendar.set(2013, 9, 1);
        // calendar.set(Calendar.MILLISECOND, 0);
        // SimpleDateFormat formatter = new
        // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String dateString = formatter.format(calendar.getTime());
        // System.out
        // .println("insert into dbo.Sales_Tax_Rate (ZIP_CODE,STATE_ABBREV,COUNTY_NAME,CITY_NAME,STATE_SALES_TAX,STATE_USE_TAX,COUNTY_SALES_TAX,COUNTY_USE_TAX,CITY_SALES_TAX,CITY_USE_TAX,TOTAL_SALES_TAX,TOTAL_USE_TAX,TAX_SHIPPING_ALONE,TAX_SHIPPING_AND_HANDLING_TOGETHER,EFFECTIVE_DATE)");
        for (String[] transitTime : transitTimeList) {
            System.out.print("SELECT ");
            for (int i = 0; i < transitTime.length; i++) {
                System.out.print("'" + transitTime[i] + "',");
            }
            System.out.println("'GETDATE()'");
            System.out.println("UNION ALL");
        }
        // for (String[] transitTime : transitTimeList) {
        // System.out.print("SELECT ");
        // for (int i = 0; i < transitTime.length; i++) {
        // switch (transitTime[i]) {
        // case "T":
        // System.out.print("'Y',");
        // break;
        // case "E":
        // System.out.print("'N',");
        // break;
        // case "E*":
        // System.out.print("'S',");
        // break;
        // case "T*":
        // System.out.print("'S',");
        // break;
        // case "":
        // System.out.print("");
        // break;
        // default:
        // System.out.print("'" + transitTime[i] + "',");
        // break;
        // }
        // }
        // System.out.print("'CO21890',");
        // String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
        // Date());
        // System.out.println("'" + date + "','" + date + "'");
        // System.out.println("UNION ALL");
    }
}
