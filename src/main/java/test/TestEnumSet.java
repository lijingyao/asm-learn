package test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by yunshen.ljy on 2015/7/27.
 */
public class TestEnumSet {
    public static void main(String[] args) {
        // ����һ��ָ�����͵Ŀյļ���
        EnumSet set = EnumSet.noneOf(MyEnum.class);
        set.add(MyEnum.RED);
        set.add(MyEnum.GREEN);
        set.add(MyEnum.BULE);
        showSet(set);
        // ����һ��ָ�����͵��������ݵļ���
        EnumSet set2 = EnumSet.allOf(MyEnum.class);
        showSet(set2);
        // ����ָ������ָ����ʼ���ݵļ���
        EnumSet<MyEnum> set3 = EnumSet.of(MyEnum.GREEN, MyEnum.RED, MyEnum.WHITE);
        showSet(set3);
        // ����ָ�����ͣ�ָ����Χ�ļ���
        // �����߽�����
        EnumSet<MyEnum> set4 = EnumSet.range(MyEnum.RED, MyEnum.YELLOW);
        showSet(set4);
        // ���ϵ��÷�����ͨ��û������
    }

    private static void showSet(Set set) {
        System.out.println(Arrays.toString(set.toArray()));
    }
}
