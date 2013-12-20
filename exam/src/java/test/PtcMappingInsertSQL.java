package java.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

public class PtcMappingInsertSQL {

    @SuppressWarnings("resource")
    @Test
    public void test() throws IOException {
        String filePath = "D:\\ptc-mapping-insert.csv";
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        CSVReader reader = new CSVReader(isr);
        List<String[]> transitTimeList = reader.readAll();
        System.out.println("insert into dbo.Sales_Tax_PTC_Mapping (PTCCode,State,Taxable,CreateBy,CreateDate,UpdateDate)");
        for (String[] transitTime : transitTimeList) {
            System.out.print("select ");
            for (int i = 0; i < transitTime.length; i++) {
                System.out.print("'" + transitTime[i] + "',");
            }
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(date);
        }
    }

}
