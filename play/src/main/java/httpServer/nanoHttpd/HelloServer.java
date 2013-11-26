package httpServer.nanoHttpd;

import httpServer.nanoHttpd.core.NanoHTTPD;
import httpServer.nanoHttpd.webServer.ServerRunner;

import java.util.Map;

/**
 * @author hubery
 */
public class HelloServer extends NanoHTTPD {
    public HelloServer(int port) {
        super(8080);
    }

    @Override
    public Response serve(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files) {
        String msg = "<html><body><h1>Hello server</h1></body></html>";

        return new NanoHTTPD.Response(msg);
    }

//    @Override
//    public Response serve(IHTTPSession session) {
//        String msg = "<html><body><h1>Hello server</h1></body></html>";
//
//        return new NanoHTTPD.Response(msg);
//    }

    public static void main(String[] args) {

        ServerRunner.run(HelloServer.class);
    }
}
