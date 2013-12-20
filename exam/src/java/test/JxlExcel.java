package java.test;

import jxl.CellType;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.junit.Test;

import java.io.File;

import static jxl.Workbook.createWorkbook;

/**
 * @author hubery.chen
 */
public class JxlExcel {

    String[] cols = {"项目编号", "项目名称", "所属ODC", "po单号", "po金额", "4月", "5月", "6月", "7月", "8月",
            "9月", "10月", "11月", "12月", "1月", "2月", "3月", "合计",};

    @Test
    public void test() throws Exception {
        WorkbookSettings wSet = new WorkbookSettings();
        wSet.setEncoding("gb2312");
        File file = new File("D://java.test//java.test.xls");
        WritableWorkbook wwb = createWorkbook(file);
        WritableSheet ws = wwb.createSheet("java/test", 0);
        WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
        WritableCellFormat wcf1 = new WritableCellFormat(wf1);
        wcf1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
        WritableCellFormat wcf = new WritableCellFormat(wf);
        wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

        jxl.write.Label label;
        for (int i = 0; i < cols.length; i++) {
            ws.setColumnView(i, 10);
            label = new jxl.write.Label(i, 0, cols[i], wcf1);
            ws.addCell(label);
        }
        label = new jxl.write.Label(0, 1, "1", wcf);
        ws.addCell(label);
        label = new jxl.write.Label(0, 1, "2", wcf);
        ws.addCell(label);
        label = new jxl.write.Label(0, 1, "3", wcf);
        ws.addCell(label);
        wwb.write();
        wwb.close();
    }


    @Test
    public void updateExcel() {
        try {
            File file1 = new File("D://java.test//1.xls");
            //get file.
            Workbook wb = Workbook.getWorkbook(file1);
            //open a copy file(new file), then write content with same content with Test.xls.
            WritableWorkbook book =
                    Workbook.createWorkbook(file1, wb);
            //add a Sheet.
            WritableSheet sheet = book.createSheet("Sheet_2", 1);
            sheet.addCell(new Label(0, 0, "test2"));
            book.write();
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modifyExcel() {
        File file1 = new File("D://java.test//1.xls");
        File file2 = new File("D://java.test//2.xls");
        try {
            Workbook rwb = Workbook.getWorkbook(file1);
//打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook wwb = Workbook.createWorkbook(file2, rwb);//copy
            WritableSheet ws = wwb.getSheet(0);
            WritableCell wc = ws.getWritableCell(0, 0);
            //判断单元格的类型,做出相应的转换
            if (wc.getType() == CellType.LABEL) {
                Label label = (Label) wc;
                label.setString("The value has been modified");
            }
            wwb.write();
            wwb.close();
            rwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generate() {
        //设置excel的编码格式
        WorkbookSettings wSet = new WorkbookSettings();
        wSet.setEncoding("gb2312");
        // 构建excel工作表
        File file = new File("D://java.test//1.xls");
        try {
            WritableWorkbook wwb = createWorkbook(file);
            // 工作表名称
            WritableSheet ws = wwb.createSheet("test2", 0);
            // 声明表头(列)样式
            WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 10,
                    WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
            WritableCellFormat wcf1 = new WritableCellFormat(wf1);
            // wcf1.setBackground(jxl.format.Colour.ICE_BLUE);
            wcf1.setBorder(jxl.format.Border.ALL,
                    jxl.format.BorderLineStyle.THIN);
            // 声明表数据样式
            WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
                    WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setBorder(jxl.format.Border.ALL,
                    jxl.format.BorderLineStyle.THIN);

            //声明一个单元格对象
            jxl.write.Label label;
            //插入列值
            for (int i = 0; i < cols.length; i++) {
                //设置第i列的宽度
                ws.setColumnView(i, 10);

                label = new jxl.write.Label(i, 0, cols[i], wcf1);
                //将定义好的单元格添加到工作表ws对象中
                ws.addCell(label);
            }
            label = new Label(0, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(1, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(2, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(3, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(4, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(5, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(6, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(7, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(8, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(9, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(10, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(11, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(12, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(13, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(14, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(15, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(16, 1, "java/test", wcf);
            ws.addCell(label);
            label = new Label(17, 1, "java/test", wcf);
            ws.addCell(label);
            wwb.write();
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}