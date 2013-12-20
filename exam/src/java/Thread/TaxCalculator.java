package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author hubery.chen
 */
public class TaxCalculator implements Callable<Integer> {

    private int seedMoney;

    public TaxCalculator(int seedMoney) {
        this.seedMoney = seedMoney;
    }

    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(10000);
        return seedMoney / 10;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(new TaxCalculator(100));
        while (!future.isDone()) {
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.print("#");
        }
        System.out.println("\n tax is:" + future.get() + " dollar");
        es.shutdown();
    }
}
