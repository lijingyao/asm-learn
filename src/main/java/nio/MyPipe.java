package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 2���߳�֮��ĵ����������ӡ�Pipe��һ��sourceͨ����һ��sinkͨ�������ݻᱻд��sinkͨ������sourceͨ����ȡ��
 * Created by yunshen.ljy on 2015/7/23.
 */
public class MyPipe {

    public static void main(String[] args){
        try {
            Pipe pipe = Pipe.open();//�򿪹ܵ�
            // ׼����sink
            Pipe.SinkChannel sinkChannel = pipe.sink();

            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());

            buf.flip();
            // ��sinkд����
            while(buf.hasRemaining()) {
                sinkChannel.write(buf);
            }
            // �ӹܵ������ݣ�����source ͨ��
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int byteread = sourceChannel.read(byteBuffer);// byteread ��ʾ�����ֽڴ�source�����˻�����


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
