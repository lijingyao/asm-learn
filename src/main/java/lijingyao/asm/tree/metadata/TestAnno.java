package lijingyao.asm.tree.metadata;

import com.sun.istack.internal.NotNull;

/**
 * Created by lijingyao on 15/9/7.
 */
public class TestAnno extends ClassLoader{

    public String name;

    @ServiceSubscriber(type = {EventType.LOCAL, EventType.ONS})
    public void addSubscriber(Object o) {

        System.out.print(o.toString());
    }

    public void addSubscribera(Object o) {

        System.out.print(o.toString());
    }

    @NotNull
    @TestTo(value = {})
    public void addSubscriberb(Object o) {

        System.out.print(o.toString());
    }

    @ServiceSubscriber(type = {EventType.ONS})
    @TestTo(value = {})
    public void addSubscriberaOns(Object o) {

        System.out.print(o.toString());
    }

    @ServiceSubscriber(type = {})
    public void addSubscriberaNull(Object o) {

        System.out.print(o.toString());
    }

    @ServiceSubscriber(type = {EventType.LOCAL})
    @TestTo(value = {})
    @NotNull
    public void addSubscriberaLocal(Object o) {

        System.out.print(o.toString());
    }
}