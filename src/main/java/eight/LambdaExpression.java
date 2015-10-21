package eight;

import java.util.Arrays;

/**
 * Created by yunshen.ljy on 2015/7/27.
 */
public class LambdaExpression {

    public static void main(String[] args) {
        long itemId = 12312312312312L;
        System.out.print(Long.toString(itemId));
        final String pre = "alph:";
        Arrays.asList("a", "b", "c").forEach(auctionSearchDO -> System.out.println(auctionSearchDO));

//        Arrays.asList("nani","sodetsu").subList(0,1).forEach(i -> {
//            System.out.println(i);
//        });
//

        Arrays.asList("d", "e", "f","g").subList(0, 2).forEach(e -> {
            System.out.println(pre + e);
        });
        Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));

    }

}
