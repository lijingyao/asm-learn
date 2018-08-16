package http;

import org.apache.commons.lang3.time.StopWatch;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lijingyao on 16/1/6 16:21.
 */
public class TestHttp {

    private static final String url = "http://localhost:8088/h5/share?sourceId=103&type=PK_RESULT&jsoncallback=success_jsonpCallback&_" +
            "=1451528449589";
    private static final String urlUser = "http://localhost:8088/users/summary?userId=57";

    private static final ExecutorService exec = Executors.newFixedThreadPool(30);

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int index = 0; index < 20; index++) {
            exec.execute(new RequestShare(index));
        }
        exec.shutdown();
        stopWatch.stop();
        System.out.println("total cost:" + stopWatch.getTime());


    }


    static class RequestShare implements Runnable {
        private int thread;

        public RequestShare(int no) {
            this.thread = no;
            run();
        }

        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    sendGet(i, thread);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void sendGet(int i, int thread) throws Exception {

        URL obj = new URL(url);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("X-User-UserId", "57");

        int responseCode = con.getResponseCode();
        stopWatch.stop();

        // stop
        System.out.println("Response Code : " + responseCode + " of thread: " + thread + " no: " + i + " cost:" + stopWatch.getTime());

        //        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        //        String inputLine;
        //        StringBuffer response = new StringBuffer();
        //
        //        while ((inputLine = in.readLine()) != null) {
        //            response.append(inputLine);
        //        }
        //        in.close();
        con.disconnect();
        //        System.out.println(response.toString());
    }


}
