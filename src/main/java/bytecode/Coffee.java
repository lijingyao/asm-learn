package bytecode;

/**
 * /Users/lijingyao/Documents/Workspace/JavaWorkforceIdea/asm/src/main/java/bytecode/Coffee.java
 * Created by yunshen.ljy on 2015/6/16.
 */
public class Coffee {

    private static final int constant =2;


    int f;

    public void addEspresso(int f) {
        if (f >= 1) {
            this.f = f;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
