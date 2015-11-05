package eight;

import java.util.Optional;

/**
 * Optional ����,nullpoint������
 * Created by yunshen.ljy on 2015/7/27.
 */
public class OptionalUse {

    public static void main(String[] args){
        Optional< Object > fullName = Optional.empty();
        //�ǿ�ֵ�Ļ���isPresent()����true����ӷ���false��
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        // orElseGet()����ͨ���ص�����������һ��Ĭ��ֵ��
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        // orElse()������orElseGet()�������ƣ�����orElse����һ��Ĭ��ֵ������һ���ص�������
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );


        Optional< String > firstName = Optional.of( "Tom" );
//        firstName="haha";
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        System.out.println();
    }
}
