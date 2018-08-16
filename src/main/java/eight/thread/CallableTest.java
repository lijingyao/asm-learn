package eight.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by lijingyao on 15/11/29 15:36.
 */
public class CallableTest {

    public static void main(String[] args) {
//        Callable<Integer> task = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                return 123;
//            } catch (InterruptedException e) {
//                throw new IllegalStateException("task interrupted", e);
//            }
//        };

        // 一个只有一个线程的线程池.和newSingleThreadExecutor相同.但是可以创建一个自定义的size.
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(callable("call",1));

        System.out.println("future done? " + future.isDone());

        Integer result = null;
        try {
            // 设置超时时间
            result = future.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            // 超时了
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);
    }

    static Callable<Integer> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            System.out.println("result: " + result);
            return 111;
        };
    }
}
