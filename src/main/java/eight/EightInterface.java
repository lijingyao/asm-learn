package eight;

/**
 * java8
 * ����ʽ�ӿ�
 * Created by yunshen.ljy on 2015/7/20.
 */
@FunctionalInterface
public interface EightInterface {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);

    }
}
