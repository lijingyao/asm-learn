package guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Created by yunshen.ljy on 2015/6/30.
 */
public class TestDeadEventListeners {

    public static void main(String[] args){
        EventBus eventBus = new EventBus();
        DeadEventListener deadEventListener = new DeadEventListener();
        eventBus.register(deadEventListener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));

        System.out.println("deadEvent:"+deadEventListener.isNotDelivered());
    }
}
