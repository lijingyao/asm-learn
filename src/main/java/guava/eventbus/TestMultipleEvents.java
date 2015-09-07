package guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Created by yunshen.ljy on 2015/6/30.
 */
public class TestMultipleEvents {
    public static void  main(String[] args) throws Exception {

        EventBus eventBus = new EventBus();
        MultipleListener multiListener = new MultipleListener();

        eventBus.register(multiListener);

        eventBus.post(new Integer(100));
        eventBus.post(new Integer(200));
        eventBus.post(new Integer(300));
        eventBus.post(new Long(800));
        eventBus.post(new Long(800990));
        eventBus.post(new Long(800882934));

        System.out.println("LastInteger:"+multiListener.getLastInteger());
        System.out.println("LastLong:"+multiListener.getLastLong());
    }
}

