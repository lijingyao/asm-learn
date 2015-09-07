package asm.core;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yunshen.ljy on 2015/6/8.
 */
public class GenerateClasses {

    public static void main(String[] args) throws IOException {
        byte[] b = gen();

        File file = new File("ChildClass.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(b);
        fout.close();

//        Class c = new MyClassLoader().defineClass("asm.core.ChildClass", b);
//        System.out.println(c.getSimpleName());
//        Method[] m = c.getMethods();
//        for (int i = 0; i < m.length; i++) {
//            System.out.println(m[i].getName());
//        }
//        Field[] f = c.getFields();
//        for (int i = 0; i < f.length; i++) {
//            System.out.println(f[i].getName());
//        }
    }

    private static byte[] gen() {
        ClassWriter cw = new ClassWriter(0);

        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "zero", "I", null, new Integer(0))
                .visitEnd();
        cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
                .visitEnd();
        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT ,
                "asm/core/ChildClass", null, "java/lang/Object", new String[]{"asm/core/ParentInter"});
        cw.visitEnd();
        return cw.toByteArray();
    }
}
