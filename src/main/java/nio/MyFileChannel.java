package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yunshen.ljy on 2015/7/21.
 */
public class MyFileChannel {

    public static void main(String[] args) {
        RandomAccessFile aFile = null;
        try {
            // OutputStream os =
            aFile = new RandomAccessFile("time.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(100);

            // ByteBuffer header = ByteBuffer.allocate(128);
            // ByteBuffer body = ByteBuffer.allocate(1024);
            //
            // ByteBuffer[] bufferArray = { header, body };
            // Scattering Reads �������buffer.���ǵ�һ��buffer
            // ����֮��Żᵽ��һ��bufferȥ��䡣�̶���С��Ϣ��
            // inChannel.read(bufferArray);
            // Gathering write ����д��channel,ֻ��position��limit֮������ݲŻᱻд�룬��̬��С
            // channel.write(bufferArray);
            long pos = inChannel.position();
            inChannel.position(pos + 23);// ����filechannel�ĵ�ǰλ��
            int bytesRead = inChannel.read(buf);// 1��read into buffer
            inChannel.truncate(1024);// ��ȡ�ļ���ǰ1024�ֽ�
            inChannel.force(true);// ���ļ����ݺ�Ԫ���ݣ�Ȩ����Ϣ��ǿ��д������
            // inChannel.wri
            while (bytesRead != -1) {
                // bytesRead ��ʾ���˶����ֽ�

                System.out.println("bytesRead" + bytesRead);
                buf.flip();// 2��дģʽ�л�����ģʽ

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());// 3����buffer��ȡ
                    // buf.mark();//��ȡ��ǰposition
                    // buf.reset();//��position�ָ���mark
                }
                // 4�� ȫ����ջ���
                buf.clear();// ���ݲ�δ��գ�ֻ�Ǳ����д���ݵ�λ�� position =0��limit = capacity
//                buf.compact();// �����ݿ�����buffer��ʼλ�ã�position�����һ��δ��Ԫ�غ��棬limit =
                              // capacity
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
