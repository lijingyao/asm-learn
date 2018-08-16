package eight;

import java.util.Optional;

/**
 * Optional 容器,nullpoint　处理
 * Created by yunshen.ljy on 2015/7/27.
 */
public class OptionalUse {

    public static void main(String[] args){
        Optional< Object > fullName = Optional.empty();
        //非空值的话，isPresent()返回true，否从返回false。
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        // orElseGet()方法通过回调函数来产生一个默认值。
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        // orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );


        Optional< String > firstName = Optional.of( "Tom" );
        //        firstName="haha";
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        System.out.println();
    }
}
