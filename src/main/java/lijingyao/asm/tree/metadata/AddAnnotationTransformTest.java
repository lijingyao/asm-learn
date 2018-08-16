package lijingyao.asm.tree.metadata;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import lijingyao.asm.core.MyClassLoader;

/**
 * Created by yunshen.ljy on 2015/8/12.
 */
public class AddAnnotationTransformTest {


    public static void main(String[] args) throws IOException {

        TestAnno test = new TestAnno();
        Class<?> clazz = test.getClass();
        String name = clazz.getName();
        ClassReader cr = new ClassReader(name);
        ClassNode cn = new ClassNode();
        cr.accept(cn, 0);
        AnnotationTransformer at = new AnnotationTransformer();
        at.transform(cn);
        ClassWriter cw = new ClassWriter(0);
        cn.accept(cw);
        byte[] toByte = cw.toByteArray();

        MyClassLoader loader = new MyClassLoader();
        Class<?> newClass = loader.defineClass(test.getClass().getName(), toByte);
        //        clazz = (Class) method.invoke(loader, args);


        File file = new File("AddAnno.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }

    private static String getInternalName(String className) {
        return "L" + className.replace(".", "/") + ";";
    }


}


