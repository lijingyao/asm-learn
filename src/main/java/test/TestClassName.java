package test;

import test.child.DefaultChild;
import test.child.ParentFactoryImpl;
import test.child.ClassUtil;
import test.parent.ParentFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunshen.ljy on 2015/5/29.
 */
public class TestClassName {
    private static Map<Integer, String> map;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        getMap();//构造初始参数
        ParentFactory myChild = getMyChild(2);//通过编号寻找child
        myChild.getName();
        myChild.getAge();
    }

    private static ParentFactory getMyChild(int handlerId) throws IOException, ClassNotFoundException {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (handlerId != entry.getKey())
                continue;
            for (Class<?> t : ClassUtil.getAllAssignedClass(ParentFactoryImpl.class)) {
                try {
                    if (t.getSimpleName().toLowerCase().contains(entry.getValue())) {
                        return (ParentFactory) t.newInstance();
                    }
                } catch (InstantiationException e) {
                    // log
                } catch (IllegalAccessException e) {
                    // log
                }
            }
        }
        return new DefaultChild();
    }

    private static void getMap() {
        map = new HashMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
    }
}
