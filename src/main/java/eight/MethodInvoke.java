package eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * ��������
 * Created by yunshen.ljy on 2015/7/27.
 */
public class MethodInvoke {

    public static MethodInvoke create( final Supplier< MethodInvoke > supplier ) {
        return supplier.get();
    }

    public static void collide( final MethodInvoke car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final MethodInvoke another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }

    public static void main(String[] args){
        // 1������û�в���
        final MethodInvoke car = MethodInvoke.create( MethodInvoke::new );
        final List< MethodInvoke > cars = Arrays.asList(car);
        // 2����̬�������ã�����һ������Ĳ���
        cars.forEach( MethodInvoke::collide );
        // 3���޲������ض�������ⷽ��
        cars.forEach(MethodInvoke::repair);
        // 4���ض���������ã�����һ�������͵Ĳ���
        cars.forEach( car::follow );
    }
}
