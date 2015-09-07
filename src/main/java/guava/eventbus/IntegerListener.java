package guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by yunshen.ljy on 2015/6/30.
 */
public class IntegerListener {

    private Integer lastMessage;

    @Subscribe
    public void listen(Integer integer) {
        lastMessage = integer;
        System.out.println("Message:"+lastMessage);
    }

    public Integer getLastMessage() {
        return lastMessage;
    }
}
