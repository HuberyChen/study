package nov.http;

import com.google.common.base.Stopwatch;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chi
 */
public class ServerTest {
    final String URL = "http://localhost:8080/";

    Server server;
    HttpClient httpClient;

    @Before
    public void init() {
        server = new HttpServer().start();
        httpClient = createHttpClient();
    }

    @After
    public void clean() {
        if (server != null)
            server.stop();
    }

    @Test
    public void test() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(40);
        int size = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(size);

        final AtomicInteger failed = new AtomicInteger();
        Stopwatch w = Stopwatch.createStarted();

        for (int i = 0; i < size; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        request();
                    } catch (Exception e) {
                        failed.incrementAndGet();
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }

        countDownLatch.await();

        System.out.printf("Time %dms%n", w.elapsed(TimeUnit.MILLISECONDS));
        Assert.assertEquals(failed.get(), 0);
        Assert.assertEquals("hello world", request());
    }


    String request() throws Exception {
        HttpGet get = new HttpGet(URL);
        try {
            HttpResponse httpResponse = httpClient.execute(get);
            String result = EntityUtils.toString(httpResponse.getEntity());
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                throw new IllegalStateException("not OK");
            }
            return result;
        } finally {
            get.releaseConnection();
        }
    }

    static HttpClient createHttpClient() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(1000);

        RequestConfig requestConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setExpectContinueEnabled(true)
                .setStaleConnectionCheckEnabled(true)
                .build();

        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .disableConnectionState()
                .setDefaultRequestConfig(requestConfig)
                .build();
    }
}
