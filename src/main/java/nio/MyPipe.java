package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 2个线程之间的单向数据连接。Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取。
 * Created by yunshen.ljy on 2015/7/23.
 */
public class MyPipe {

    public static void main(String[] args){
        try {
            Pipe pipe = Pipe.open();//打开管道
            // 准备好sink
            Pipe.SinkChannel sinkChannel = pipe.sink();

            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());

            buf.flip();
            // 向sink写数据
            while(buf.hasRemaining()) {
                sinkChannel.write(buf);
            }
            // 从管道读数据，访问source 通道
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int byteread = sourceChannel.read(byteBuffer);// byteread 表示多少字节从source读到了缓冲区


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
