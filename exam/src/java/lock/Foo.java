package java.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hubery
 */
public class Foo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Foo.class);

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock r = rwl.readLock();

    private final Lock w = rwl.writeLock();

    public void read() {
        try {
            r.lock();
            Thread.sleep(1000);
            System.out.println("read...........");
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        } finally {
            r.unlock();
        }
    }

    public void write(Object _object) {
        try {
            w.lock();
            Thread.sleep(1000);
            System.out.println("write..........");
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        } finally {
            w.unlock();
        }
    }
}
