package pratice.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {

    public static void main(String[] args) throws Exception {
        String str = "10.2368686986859686";
        Pattern p = Pattern.compile("[\\d]*[\\.][\\d]{2}"); // С������λС��
        Matcher m = p.matcher(str);

        int a = 1, b = 2;
        if (a == 1 || b == 1) {
            System.out.println("!!!!!!!!!!!!!!!!!!");
        }

        // ������Ӧ���ַ�
        while (m.find()) {
            String tmp = m.group();
            if (!"".equals(tmp)) {
                System.out.println(tmp);
            }
        }

        // �ж��Ƿ�ƥ��
        System.out.println(m.matches());

        str = "��ɽ���ϻ��򲻵�";
        p = Pattern.compile("�ϻ��򲻵�");
        m = p.matcher(str);

        // ������Ӧ���ַ�
        while (m.find()) {
            String tmp = m.group();
            if (!"".equals(tmp)) {
                System.out.println(tmp);
            }
        }
    }

}
