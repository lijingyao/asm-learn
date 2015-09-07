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
            // ������ʽ��channel �ſ�����selector
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            // SelectionKey ��ʾͨ����ע�˸���Ȥ���¼�
            SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            int interestSet = selectionKey.interestOps();
            // �жϸ���Ȥ�¼��Ƿ��ڼ�����
            boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
            // �ж�channel�о������¼�
            int readySet = selectionKey.readyOps();
            selectionKey.isWritable();
            // ��Ҫ�Լ���ͨ������ת������Ҫ��������� Channel channel = selectionKey.channel();
            // Selector selector = selectionKey.selector();
            // ��Ӹ��Ӷ���Ҳ������register�����м�
            // selectionKey.attach(theObject);
            // Object attachedObj = selectionKey.attachment();
            //���ʡ���ѡ�������selected key set�����еľ���ͨ��
            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            // �������selector�������¼��Ƿ����
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
                // ������ͨ��ʱ���Լ��Ƴ�
                keyIterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
