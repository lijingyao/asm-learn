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
            socketChannel.configureBlocking(false);// ���÷�����ģʽ�����ӽ���ǰ�Ϳ��Է���
            while (!socketChannel.finishConnect()) {
                // ȷ�������Ƿ���wait or do th
            }
            // socketChannel.connect(new
            // InetSocketAddress("http://www.iteye.com/", 80));
            // ByteBuffer buf = ByteBuffer.allocate(48);
            // int bytesRead = socketChannel.read(buf);// �����ݵ�buffer.����-1��ʾ������ĩβ

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
