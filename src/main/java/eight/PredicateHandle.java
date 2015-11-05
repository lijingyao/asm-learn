package eight;

import java.util.function.Predicate;

/**
 * Created by lijingyao on 15/11/5 13:54.
 */
public class PredicateHandle {

    public static void main(String[] args){
        Predicate<String> hasLengthOf10 = t -> t.length() < 10;

        Predicate<String> containsLetterA = p -> p.contains("A");

        String containsA = "And";

        boolean outcome = hasLengthOf10.and(containsLetterA).test(containsA);
        System.out.println(outcome);


        System.out.println(validUser(-2).test(2l));
    }


    public static Predicate<Long> validateLong() {
        return p -> null != p && p > 0;
    }

    public static Predicate<Integer> validateOffset() {
        return p -> null != p && p >= 0 && p < 1000;
    }

    public static Predicate<Long> validUser(Integer offset) {
        return p -> validateLong().test(p) && validateOffset().test(offset);
    }
}
