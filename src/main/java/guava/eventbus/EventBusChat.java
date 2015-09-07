package guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

/**
 * Created by yunshen.ljy on 2015/6/30.
 */
public class EventBusChat {
    public static void main(String[] args) {
        AsyncEventBus channel = new AsyncEventBus(Executors.newFixedThreadPool(3));
        ServerSocket socket;
        try {
            socket = new ServerSocket(4425);
            while (true) {
                Socket connection = socket.accept();
                UserThread newUser = new UserThread(connection, channel);
                newUser.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
