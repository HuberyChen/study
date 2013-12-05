package main.java.nov.http;

import java.io.IOException;

public class ServerRunner {
    public static void run(Class serverClass) {
        try {
            executeStart((NanoHTTPD) serverClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop(Class serverClass) {
        try {
            executeStop((NanoHTTPD) serverClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeStart(NanoHTTPD server) {
        try {
            server.start();
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
            System.exit(-1);
        }
    }

    public static void executeStop(NanoHTTPD server) {
        server.stop();
        System.out.println("Server stopped.\n");
    }
}
