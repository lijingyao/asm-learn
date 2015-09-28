package eight;

/**
 * Created by yunshen.ljy on 2015/7/20.
 */
public class EightClass implements EightInterface {
    @Override
    public double calculate(int a) {
        return sqrt(a + 1);
    }
}
