package eight;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
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
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " - "));
        System.out.println();
        String phones = "18969351198,\n" +
                "18969138222,\n" +
                "18969122122,\n" +
                "18968123623,\n" +
                "18967969697,\n" +
                "18967952187,\n" +
                "18967932980,\n" +
                "18967603336,\n" +
                "18967571777,\n" +
                "18967491136,\n" +
                "18967408973,\n" +
                "18967193883,\n" +
                "18967044799,\n" +
                "18967001889,\n" +
                "18966021872,\n" +
                "18960066665,\n" +
                "18958967818";
        String[] aa = phones.split(",");
        final List<String> phoneList = Arrays.asList(aa);
        StringJoiner joiner = new StringJoiner(",");
        phoneList.stream().map(String::trim).forEach(joiner::add);
        System.out.println(joiner.toString());
    }
}
