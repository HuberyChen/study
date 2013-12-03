package random;

public class Client {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Random());
        t1.run();
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - start);
    }
}
