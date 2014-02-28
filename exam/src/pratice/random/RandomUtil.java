package pratice.random;

import com.quidsi.core.util.DigestUtils;

public class RandomUtil {

    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            System.out.println(new Random().nextInt(1));
//        }
        System.out.println(DigestUtils.sha512("text"));
    }

}
