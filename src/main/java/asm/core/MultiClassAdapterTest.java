package asm.core;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yunshen.ljy on 2015/6/13.
 */
public class MultiClassAdapterTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("asm.core.Task");
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor[] cvs = {new AddingClassesVisitor(cw, Opcodes.ACC_PRIVATE,"addOne","I"),new AddingClassesVisitor(cw, Opcodes.ACC_PRIVATE,"addTwo","L")};
        ClassVisitor mcv = new MultiClassAdapter(cvs);
        cr.accept(mcv, 0);
        byte[] toByte = cw.toByteArray();// byt 和toByte其实是相同的数组
        // 输出到class文件
        File file = new File("Task.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }
}
