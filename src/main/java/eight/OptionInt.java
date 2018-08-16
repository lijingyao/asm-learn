package eight;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by lijingyao on 16/4/28 15:43.
 */
public class OptionInt {

    public static void main(String[] args) {

        int[] array = {10, 20, 30, 40, 50, 60};
        // Convert array to Stream.
        IntStream stream = Arrays.stream(array);

        // Filter outvalues less than 40.
        OptionalInt result = stream.filter(value -> value >= 100).map(value -> value + 10).findAny();
        // If a result is present, display it as an int.
        if (result.isPresent()) {
            // This is the first value returned by the filter.
            System.out.println(result.getAsInt());
        } else {
            System.out.println("no result.");
        }
    }

}
