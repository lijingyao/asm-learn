package http;

import org.apache.commons.lang3.time.StopWatch;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lijingyao on 16/1/6 11:56.
 */
public class Test {

    private static final String url = "http://localhost:8088/h5/share?sourceId=103&type=PK_RESULT&jsoncallback=success_jsonpCallback&_" +
            "=1451528449589";

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10; i++) {
            RequestShare share = new RequestShare(i);
            share.run();
        }
        stopWatch.stop();
        System.out.println("total cost:" + stopWatch.getTime());
    }

    static class RequestShare implements Runnable {
        private int thread;

        public RequestShare(int thread) {
            this.thread = thread;
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

        int responseCode = con.getResponseCode();
        stopWatch.stop();

        // stop
        System.out.println("Response Code : " + responseCode + " of thread: " + thread + " no: " + i + " cost:" + stopWatch.getTime());
        con.disconnect();
        //        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        //        String inputLine;
        //        StringBuffer response = new StringBuffer();
        //
        //        while ((inputLine = in.readLine()) != null) {
        //            response.append(inputLine);
        //        }
        //        in.close();

        //print result
        //        System.out.println(response.toString());
    }


}
