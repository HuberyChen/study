package nov.http;

/**
 * @author Thomas.chen
 */
public class HttpServer implements Server {

    private int port = 8080;
    private HttpListener listener;

    @Override
    public Server start() {
        this.listener = new HttpListener(port);
        this.listener.start();
        return this;
    }

    @Override
    public void stop() {
        if (this.listener != null) {
            if (this.listener.getServerSocket() != null) {
                this.listener.setServerSocket(null);
            }
            this.listener.interrupt();
        }
    }
}
