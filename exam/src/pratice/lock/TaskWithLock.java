package pratice.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hubery
 */
public class TaskWithLock extends Task implements Runnable {

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();
            doSomething();
        } finally {
            lock.unlock();
        }
    }
}
