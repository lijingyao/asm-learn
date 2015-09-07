package asm.core;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yunshen.ljy on 2015/6/13.
 */
public class CheckClassAdapterTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("asm.core.Task");
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor acv = new AddingClassesVisitor(cw,
        Opcodes.ACC_PRIVATE,"addedField","I");
        //
        CheckClassAdapter cv = new CheckClassAdapter(acv);
        TraceClassVisitor tcv = new TraceClassVisitor(cv, new
                PrintWriter(System.out));
        cr.accept(tcv, 0);
        byte[] toByte = cw.toByteArray();// byt 和toByte其实是相同的数组
        // 输出到class文件
        File file = new File("Task.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
        byte a = 127;
        byte b = 127;
        int c = (a << a | b);
        System.out.println(c);
    }
}
