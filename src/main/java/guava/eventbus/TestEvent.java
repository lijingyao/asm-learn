package guava.eventbus;

/**
 * Created by yunshen.ljy on 2015/6/30.
 */
public class TestEvent {
    private final int message;
    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message:"+message);
    }
    public int getMessage() {
        return message;
    }
}
