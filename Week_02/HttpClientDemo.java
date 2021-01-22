import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpClientDemo {

    private static final String URL = "http://localhost:8801";
    private static final int TIME_OUT = 60000;

    public static void main(String[] args) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(TIME_OUT)
                .setConnectTimeout(TIME_OUT).build();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        doGet(httpClient,requestConfig);
    }

    private static void doGet(CloseableHttpClient httpClient, RequestConfig requestConfig) {
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setConfig(requestConfig);
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            System.out.printf("status:%s\ncontent:%s%n",
                    httpResponse.getStatusLine(),
                    EntityUtils.toString(httpResponse.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void okhttpGet(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(URL)
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
