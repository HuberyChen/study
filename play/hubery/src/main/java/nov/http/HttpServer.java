package main.java.nov.http;

import java.io.IOException;

/**
 * @author hubery
 */
public class HttpServer extends NanoHTTPD {
    public HttpServer() {
        super(8080);
    }

    public NanoHTTPD run() {
        this.start();
        return this;
    }

    @Override
    public void start() {
        try {
            super.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        super.stop();
    }
}
