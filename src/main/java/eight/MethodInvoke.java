package eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法调用
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
        // 1、构造没有参数
        final MethodInvoke car = MethodInvoke.create( MethodInvoke::new );
        final List< MethodInvoke > cars = Arrays.asList(car);
        // 2、静态方法调用，接受一个本类的参数
        cars.forEach( MethodInvoke::collide );
        // 3、无参数的特定类的任意方法
        cars.forEach(MethodInvoke::repair);
        // 4、特定对象的引用，接受一个本类型的参数
        cars.forEach( car::follow );
    }
}
