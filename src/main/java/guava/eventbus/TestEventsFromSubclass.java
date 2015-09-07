package guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Created by yunshen.ljy on 2015/6/30.
 */
public class TestEventsFromSubclass {

    public static void main(String[] args){
        EventBus eventBus = new EventBus();
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener(eventBus);
        eventBus.register(integerListener);
       ;

        eventBus.post(new Integer(100));

//        System.out.println("integerListener message:" + integerListener.getLastMessage());
//        System.out.println("numberListener message:" + numberListener.getLastMessage());

        eventBus.post(new Long(200L));

//        System.out.println("integerListener message:" + integerListener.getLastMessage());
//        System.out.println("numberListener message:" + numberListener.getLastMessage());
    }
}
