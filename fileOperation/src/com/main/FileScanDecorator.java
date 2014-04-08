package com.main;

public class FileScanDecorator extends Decorator {

    private long start, end;

    public void getTime() {
        start = System.currentTimeMillis();
        super.getTime();
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
