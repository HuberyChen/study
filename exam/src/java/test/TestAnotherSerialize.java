package java.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestAnotherSerialize {

    /**
     * 
     * @param args
     * 
     * @throws IOException
     * 
     * @throws ClassNotFoundException
     */

    public static void main(String[] args) throws IOException,

    ClassNotFoundException {

        // 1. ׼�����

        List dataList = new ArrayList();

        dataList.add("abc");

        dataList.add("123");

        // 2. �������л���

        String sFilePath = "D://test_another_serialize.dat";

        FileOutputStream fos = null;

        ObjectOutputStream ooS = null;

        try {

            fos = new FileOutputStream(sFilePath);

            ooS = new ObjectOutputStream(fos);

            ooS.writeObject(dataList);

            System.out.println(fos);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fos != null)

                fos.close();

            if (ooS != null) {

                ooS.close();

            }

        }

        // 3. �����л��ļ��ж�ȡ���ļ�

        FileInputStream fiStream = null;

        ObjectInputStream oiStream = null;

        try {

            fiStream = new FileInputStream(sFilePath);

            oiStream = new ObjectInputStream(fiStream);

            List serializeResult = (List) oiStream.readObject();

            System.out.println(" ���л����Ϊ����" + serializeResult);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fiStream != null)

                fiStream.close();

            if (oiStream != null) {

                oiStream.close();

            }

        }

    }

}
