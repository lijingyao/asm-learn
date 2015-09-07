package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by yunshen.ljy on 2015/7/23.
 */
public class MySocketChannel {

    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);// 设置非阻塞模式，链接建立前就可以返回
            while (!socketChannel.finishConnect()) {
                // 确定链接是否建立wait or do th
            }
            // socketChannel.connect(new
            // InetSocketAddress("http://www.iteye.com/", 80));
            // ByteBuffer buf = ByteBuffer.allocate(48);
            // int bytesRead = socketChannel.read(buf);// 读数据到buffer.返回-1表示读到流末尾

            String newData = "New String to write to file..." + System.currentTimeMillis();

            ByteBuffer wbuf = ByteBuffer.allocate(48);
            wbuf.clear();
            wbuf.put(newData.getBytes());

            wbuf.flip();

            while (wbuf.hasRemaining()) {
                socketChannel.write(wbuf);
            }

            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
