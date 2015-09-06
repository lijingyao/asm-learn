package asm.core.methord;

/**
 * Created by yunshen.ljy on 2015/6/29.
 */
public class Time {
    public void myCount() {
        byte i = 5;
        byte j = 10;
        System.out.println(j - i);
        System.out.println(j + i);
        System.out.println(j + 0);
        System.out.println(0 + i);
    }

    public static void myMethod(int a){
        System.out.println(a+0);
    }

}
