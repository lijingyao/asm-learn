package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yunshen.ljy on 2015/7/22.
 */
public class SelectorManage {

    public static void main(String[] args) {

        try {
            Selector selector = Selector.open();
            // 非阻塞式的channel 才可以用selector
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            // SelectionKey 表示通道关注了感兴趣的事件
            SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            int interestSet = selectionKey.interestOps();
            // 判断感兴趣事件是否在集合中
            boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
            // 判断channel中就绪的事件
            int readySet = selectionKey.readyOps();
            selectionKey.isWritable();
            // 需要自己再通道外面转换成需要处理的类型 Channel channel = selectionKey.channel();
            // Selector selector = selectionKey.selector();
            // 添加附加对象，也可以在register方法中加
            // selectionKey.attach(theObject);
            // Object attachedObj = selectionKey.attachment();
            //访问“已选择键集（selected key set）”中的就绪通道
            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            // 持续监控selector的四种事件是否就绪
            while(keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if(key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.

                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.

                } else if (key.isReadable()) {
                    // a channel is ready for reading

                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                // 处理完通道时，自己移除
                keyIterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
