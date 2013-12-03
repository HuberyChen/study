package test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Storage storage = new Storage();
        new Producer(storage).start();
        new Customer(storage).start();

    }

}

class Customer extends Thread {

    private Storage storage;

    public Customer(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        while (true) {
            try {
                if (Storage.NUM == 0) {
                    System.out.println("打印：" + 0 + ",线程终止");
                    break;
                }
                Integer num = storage.print();
                System.out.println("打印：" + num);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {

    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public void run() {

        while (true) {

            try {
                Integer num = new Random().nextInt(1000);
                Storage.NUM = num;
                if (Storage.NUM == 0) {
                    System.out.println("生产：" + 0 + ",线程终止");
                    break;
                }
                storage.put(num);
                System.out.println("生产：" + num);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

class Storage {
    private BlockingQueue<Integer> randomData = new ArrayBlockingQueue<Integer>(1);// 空间大小为1的阻塞队列

    public static int NUM = -1;

    public void put(Integer number) {

        try {
            randomData.put(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int print() {
        try {
            Integer number = randomData.take();
            return number;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}