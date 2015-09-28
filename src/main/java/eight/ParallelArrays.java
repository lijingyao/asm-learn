package eight;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * �������鴦�� Created by yunshen.ljy on 2015/7/28.
 */
public class ParallelArrays {

    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        // parallelSetAll ����Ԫ�������ֵ
        Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
        // ��ӡǰʮ��Ԫ��
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();
        // ����������
        Arrays.parallelSort(arrayOfLong);
        // ��ӡ�����ʮ��Ԫ��
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
