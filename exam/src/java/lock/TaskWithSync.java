package java.lock;

/**
 * @author hubery
 */
public class TaskWithSync extends Task implements Runnable {
    @Override
    public void run() {
        synchronized ("A") {
            doSomething();
        }
    }
}
