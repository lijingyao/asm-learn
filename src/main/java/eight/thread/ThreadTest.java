package eight.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lijingyao on 15/11/29 15:30.
 */
public class ThreadTest {

    public static void main(String[] args){
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
