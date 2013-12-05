package nov.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Thomas.chen
 */
public class HttpListener extends Thread {
    private ServerSocket serverSocket = null;
    private int port = 8080;

    public HttpListener(int port) {
        this.port = port;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                cachedThreadPool.execute(new HttpHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }


}
