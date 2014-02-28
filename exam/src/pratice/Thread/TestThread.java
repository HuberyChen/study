package pratice.thread;

/**
 * @author chi
 */
public class TestThread implements Runnable {

    public void start(int _priority) {
        Thread t = new Thread(this);
        t.setPriority(_priority);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Math.hypot(Math.pow(924526789, i), Math.cos(i));
        }
        System.out.println(Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new TestThread().start(i % 10 + 1);
        }
    }
}
