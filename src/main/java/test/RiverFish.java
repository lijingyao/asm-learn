package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yunshen.ljy on 2015/8/5.
 */
public class RiverFish {


    public static void main(String[] args){
        //matches()判断字符串是否匹配某个表达式，"."表示任何一个字符
        p("auctionfacade010179037099.s.et2".matches("[a-z]{3}"));
        //将字符串"a2389a"中的数字用*替换，\d 表示“0--9”数字
        p("a2389a".replaceAll("\\d", "*"));
        //将任何是a--z的字符串长度为3的字符串进行编译，这样可以加快匹配速度
        Pattern p = Pattern.compile("[a-z]{3}");
        //进行匹配，并将匹配结果放在Matcher对象中
        Matcher m = p.matcher("abc");
        p(m.matches());
        //上面的三行代码可以用下面一行代码代替
        p("abc".matches("[a-z]{3}"));
    }

    public static void p(Object o){
        System.out.println(o);
    }
}
