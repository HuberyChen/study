package Thread;

/**
 * @author hubery
 */
public class TcpServer implements Runnable {
    public TcpServer() {
        Thread t = new Thread(this);
        t.setUncaughtExceptionHandler(new TcpServerExceptionHandler());
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("system is running:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TcpServerExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Thread: " + t.getName() + "appears exception,to reset itself,please analyzing reason.");
            e.printStackTrace();
            new TcpServer();
        }
    }
}
