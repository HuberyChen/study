package nov.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * @author Thomas.chen
 */
public class HttpHandler extends Thread {
    static final String result = "hello world";
    static byte[] header;
    static byte[] output;

    static {
        output = result.getBytes();
        StringBuilder headerBuilder = new StringBuilder();
        headerBuilder.append("HTTP/1.0 200 OK\r\nServer: OneFile 1.0\r\nContent-length: ");
        headerBuilder.append(output.length);
        headerBuilder.append("\r\nContent-type: text/html\r\n\r\n");
        try {
            header = headerBuilder.toString().getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private Socket socket;

    public HttpHandler(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try (OutputStream outputStream = socket.getOutputStream()) {
            outputStream.write(header);
            outputStream.write(output, 0, output.length);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
