package eight;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by lijingyao on 15/11/2 19:13.
 */
public class Functionnal {

    public static void main(String[] args) {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));

        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.print(comparator.compare(p1, p2));             // > 0
        comparator.reversed().compare(p1, p2);  // < 0


        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"
    }
}
