package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author hubery
 */
public class Runner implements Callable<Integer> {

    private CountDownLatch begin;

    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int source = new Random().nextInt(25);

        begin.await();

        TimeUnit.SECONDS.sleep(source);

        end.countDown();

        return source;
    }

    public static void main(String[] args) throws Exception {
        int num = 10;
        CountDownLatch begin = new CountDownLatch(1);

        CountDownLatch end = new CountDownLatch(num);

        ExecutorService es = Executors.newFixedThreadPool(num);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            futures.add(es.submit(new Runner(begin, end)));
        }

        begin.countDown();
        ;

        end.wait();

        int count = 0;

        for (Future<Integer> f : futures)
            count += f.get();

        System.out.println("avg source :" + count / num);
    }
}
