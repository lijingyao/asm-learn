package guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * ������ - ͨ���������ݶ�������ȷʵ�Ƿ��Ǽ�������
 * Created by yunshen.ljy on 2015/6/30.
 */
public class NumberListener {
    private Number lastMessage;

    public NumberListener(EventBus eventBus){
        eventBus.register(this);
    }

    @Subscribe
    public void listen(Number integer) {
        lastMessage = integer;
        System.out.println("NumberListener:"+lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
