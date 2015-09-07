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
            serverSocketChannel.configureBlocking(false);// ������ģʽ
            while (true) {
                // accept�������������ӵ����������
                SocketChannel socketChannel = serverSocketChannel.accept();

                // do something with socketChannel...
                if (socketChannel != null) {
                    // ������ accept �������أ�û�������ӻ᷵��null
                }
            }
            // �ر�����
            // serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
