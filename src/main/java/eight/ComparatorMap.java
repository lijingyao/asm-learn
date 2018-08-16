package eight;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lijingyao on 16/5/10 16:44.
 */
public class ComparatorMap {

    public static void main(String[] args) {

        Map<Long, String> playerKda = new HashMap<>();
        playerKda.put(7l, "0");
        playerKda.put(1l, "0");
        playerKda.put(6l, "9");
        playerKda.put(3l, "200");
        playerKda.put(2l, "100");
        playerKda.put(4l, "0");
        playerKda.put(5l, "9898");
        //        playerKda.put(2l, "30000");
        playerKda.entrySet().stream().sorted( Collections.reverseOrder());
        List<Long> userId = playerKda.entrySet().stream().sorted(getEntryComparator().thenComparing(playerIdComparator)).map(Map
                .Entry::getKey).collect(Collectors.toList());

        //        System.out.println(userId.size());
        //        for (int i = 0; i < userId.size(); i++) {
        //            //            if (userId.get(i).equals(2l)) {
        //            System.out.println(i + 1);
        //            //            }
        //        }

        for (Long id : userId) {
            System.out.println(id);
        }

        //        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,10,9,14,12,18);
        //        list.stream().limit(10).forEach(i->{
        //            System.out.println(i);
        //        });

    }


    private static Comparator<Map.Entry<Long, String>> getEntryComparator() {
        return (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return 0;
            }
            if (Integer.parseInt(o1.getValue()) == 0) {
                return 1;
            }
            if (Integer.parseInt(o2.getValue()) == 0) {
                return -1;
            }
            if (Integer.parseInt(o1.getValue()) > Integer.parseInt(o2.getValue())) {
                return 1;
            } else {
                return -1;
            }
        };
        //        return (o1, o2) -> (Integer.parseInt(o1.getValue()) - Integer.parseInt(o2.getValue())) > 0;
    }

    private static Comparator<Map.Entry<Long, String>> playerIdComparator = (o1, o2) -> o2.getKey().compareTo(o1.getKey());
}
