package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * UDP ���ͺͽ��ܱ��� Created by yunshen.ljy on 2015/7/23.
 */
public class MyDatagramChannel {

    public static void main(String[] args) {
        DatagramChannel channel = null;
        try {
            channel = DatagramChannel.open();
            channel.socket().bind(new InetSocketAddress(9999));
            // ��channel��������
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            channel.receive(buf);
            // �������ݵ�UDP�Ķ˿�80������֤�����յ�
            String newData = "New String to write to file..." + System.currentTimeMillis();

            ByteBuffer sbuf = ByteBuffer.allocate(48);
            sbuf.clear();
            sbuf.put(newData.getBytes());
            sbuf.flip();

            int bytesSent = channel.send(sbuf, new InetSocketAddress("jenkov.com", 80));

            System.out.println(bytesSent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
