package eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ��������
 * Created by yunshen.ljy on 2015/7/27.
 */
public class MethodInvoke {

    public static MethodInvoke create(final Supplier<MethodInvoke> supplier) {
        return supplier.get();
    }

    public static void collide(final MethodInvoke car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final MethodInvoke another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        // 1������û�в���
        final MethodInvoke car = MethodInvoke.create(MethodInvoke::new);
        final List<MethodInvoke> cars = Arrays.asList(car);
        // 2����̬�������ã�����һ������Ĳ���
        cars.forEach(MethodInvoke::collide);
        // 3���޲������ض�������ⷽ��
        cars.forEach(MethodInvoke::repair);
        //        MethodInvoke::repair;
        // 4���ض���������ã�����һ�������͵Ĳ���
        cars.forEach(car::follow);
        Arrays.asList(car).forEach(ss -> car.follow(car));

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));

//
//        Operation<String, Integer> operation = Integer::parseInt;
//
//        // Prints the integer 9
//        System.out.println(operation.calculate("34"));


//        Supplier<Person> personSupplier = Person::new;
//        personSupplier.get();   // new Person


//        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
//
//        Person p1 = new Person("John", "Doe");
//        Person p2 = new Person("Alice", "Wonderland");
//
//        comparator.compare(p1, p2);             // > 0
//        comparator.reversed().compare(p1, p2);  // < 0

    }
}
