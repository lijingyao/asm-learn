package eight;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 并行数组处理 Created by yunshen.ljy on 2015/7/28.
 */
public class ParallelArrays {

    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        // parallelSetAll 数组元素随机赋值
        Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
        // 打印前十个元素
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();
        // 对数组排序
        Arrays.parallelSort(arrayOfLong);
        // 打印排序后十个元素
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
