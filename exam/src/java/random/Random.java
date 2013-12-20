package java.random;

public class Random implements Runnable {

    public void run() {
        String chars1 = "0123456789";
        String chars2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i = 0;
        boolean flag = true;

        while (flag) {
            try {
                System.out.print(chars1.charAt((int) (Math.random() * 10)));
                Thread.sleep(100);
                System.out.print(chars2.charAt((int) (Math.random() * 52)));
                i++;
                if (i == 10) {
                    flag = false;
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

}
