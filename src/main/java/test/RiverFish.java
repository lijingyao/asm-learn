package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yunshen.ljy on 2015/8/5.
 */
public class RiverFish {


    public static void main(String[] args){
        //matches()�ж��ַ����Ƿ�ƥ��ĳ�����ʽ��"."��ʾ�κ�һ���ַ�
        p("auctionfacade010179037099.s.et2".matches("[a-z]{3}"));
        //���ַ���"a2389a"�е�������*�滻��\d ��ʾ��0--9������
        p("a2389a".replaceAll("\\d", "*"));
        //���κ���a--z���ַ�������Ϊ3���ַ������б��룬�������Լӿ�ƥ���ٶ�
        Pattern p = Pattern.compile("[a-z]{3}");
        //����ƥ�䣬����ƥ��������Matcher������
        Matcher m = p.matcher("abc");
        p(m.matches());
        //��������д������������һ�д������
        p("abc".matches("[a-z]{3}"));
    }

    public static void p(Object o){
        System.out.println(o);
    }
}
