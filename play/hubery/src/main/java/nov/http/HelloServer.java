package main.java.nov.http;

import java.util.Map;

/**
 * @author hubery
 */

public class HelloServer extends NanoHTTPD {
    public HelloServer() {
        super(8080);
    }

    @Override
    public Response serve(String uri, Method method, Map<String, String> header, Map<String, String> parms, Map<String, String> files) {
        System.out.println(method + " '" + uri + "' ");

        String msg = "<html><body><h1>Hello server</h1>\n";
        if (parms.get("username") == null)
            msg +=
                    "<form action='?' method='get'>\n" +
                            "</form>\n";
        else
            msg += "<p>Hello";

        msg += "</body></html>\n";

        return new NanoHTTPD.Response(msg);
    }

    public NanoHTTPD run() {
        ServerRunner.run(HelloServer.class);
        return this;
    }

}