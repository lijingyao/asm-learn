package bytecode;

/**
 * Created by yunshen.ljy on 2015/8/14.
 */
public class TransformByteCode {

    private int espresso ;

    public void addEspresso(int espresso) {
        if (espresso > 0) {
            this.espresso = espresso;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
