package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yunshen.ljy on 2015/7/23.
 */
public class MyServerSocketChannel {

    public static void main(String[] args) {

        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            serverSocketChannel.configureBlocking(false);// 非阻塞模式
            while (true) {
                // accept阻塞到有新连接到达，返回连接
                SocketChannel socketChannel = serverSocketChannel.accept();

                // do something with socketChannel...
                if (socketChannel != null) {
                    // 非阻塞 accept 立即返回，没有新连接会返回null
                }
            }
            // 关闭连接
            // serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
