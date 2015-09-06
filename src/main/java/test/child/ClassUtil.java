package test.child;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunshen.ljy on 2015/6/1.
 */
public class ClassUtil {


    public static void main(String[] args) {
        try {
//            System.out.println("接口实现类：");
//            for (Class<?> c : getAllAssignedClass(Intf.class)) {
//                System.out.println(c.getName());
//            }
            System.out.println("子类：");
            for (Class<?> c : getAllAssignedClass(ParentFactoryImpl.class)) {
                System.out.println(c.getSimpleName());
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 获取同一路径下所有子类或接口实现类
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getAllAssignedClass(Class<?> cls) throws IOException,
            ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (Class<?> c : getClasses(cls)) {
            if (cls.isAssignableFrom(c) && !cls.equals(c)) {
                classes.add(c);
            }
        }
        return classes;
    }

    /**
     * 取得当前类路径下的所有类
     *
     * @param cls
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClasses(Class<?> cls) throws IOException,
            ClassNotFoundException {
        String pk = cls.getPackage().getName();
        return getClasses(new File(ParentFactoryImpl.class.getProtectionDomain().getCodeSource().getLocation().getPath()), pk);
    }

    /**
     * 迭代查找类
     *
     * @param dir
     * @param pk
     * @return
     * @throws ClassNotFoundException
     */
    private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        if (!dir.exists()) {
            return classes;
        }
        for (File f : dir.listFiles()) {
            if (f.isDirectory()) {
                classes.addAll(getClasses(f, pk + "." + f.getName()));
            }
            String name = f.getName();
            if (name.endsWith(".class")) {
                classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
            }
        }
        return classes;
    }



}


