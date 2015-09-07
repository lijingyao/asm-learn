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
            // Scattering Reads 读到多个buffer.但是第一个buffer
            // 满了之后才会到下一个buffer去填充。固定大小消息。
            // inChannel.read(bufferArray);
            // Gathering write 数据写到channel,只有position和limit之间的数据才会被写入，动态大小
            // channel.write(bufferArray);
            long pos = inChannel.position();
            inChannel.position(pos + 23);// 设置filechannel的当前位置
            int bytesRead = inChannel.read(buf);// 1、read into buffer
            inChannel.truncate(1024);// 截取文件的前1024字节
            inChannel.force(true);// 将文件数据和元数据（权限信息）强制写到磁盘
            // inChannel.wri
            while (bytesRead != -1) {
                // bytesRead 表示读了多少字节

                System.out.println("bytesRead" + bytesRead);
                buf.flip();// 2、写模式切换到读模式

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());// 3、从buffer读取
                    // buf.mark();//获取当前position
                    // buf.reset();//将position恢复到mark
                }
                // 4、 全部清空缓存
                buf.clear();// 数据并未清空，只是标记了写数据的位置 position =0，limit = capacity
//                buf.compact();// 将数据拷贝到buffer起始位置，position到最后一个未读元素后面，limit =
                              // capacity
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
