package java.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hubery
 */
public class Executor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Executor.class);

    public static void runTasks(Class<? extends Runnable> clz) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("*****begin execute " + clz.getSimpleName() + " task*****");
        for (int i = 0; i < 3; i++) {
            es.submit(clz.newInstance());
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("------" + clz.getSimpleName() + " task is ending------/n");
        es.shutdown();
    }

    //显示锁(lock)是对象级别的锁，内部锁(synchronized)是类级别的锁
    //lock支持更细粒度的锁控制
    //lock无阻塞锁，synchronized阻塞锁
    //lock公平锁(先来后到)，默认为非公平锁，可实现公平锁，synchronized非公平锁
    //lock代码级，synchronized是JVM级
    //灵活、强大 lock，快捷、安全 synchronized
    public static void main(String[] args) throws Exception {
        runTasks(TaskWithLock.class);

        runTasks(TaskWithSync.class);

        final Lock lock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (Exception e) {
                        LOGGER.info(e.getMessage());
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
