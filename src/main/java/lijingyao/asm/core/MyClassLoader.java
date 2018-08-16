package lijingyao.asm.core;

/**
 * Created by yunshen.ljy on 2015/6/8.
 */
public class MyClassLoader extends ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }




}
