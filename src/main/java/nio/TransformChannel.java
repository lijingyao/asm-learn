package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by yunshen.ljy on 2015/7/22.
 */
public class TransformChannel {

    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("time.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0;// ��position ��ʼд������
        long count = fromChannel.size();// ��ഫ���ֽ���
        // SocketChannel��һֱ��������ֱ��Ŀ��buffer��������
        // toChannel.transferFrom(fromChannel,position, count);
        fromChannel.transferTo(position, count, toChannel);
    }

}
