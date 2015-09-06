package asm.core.methord;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yunshen.ljy on 2015/6/30.
 */
public class StatelessTransformTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("asm.core.methord.Time");
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new AddTimerAdapter(cw);
        cr.accept(cv, 0);
        byte[] toByte = cw.toByteArray();
        // 输出到class文件
        File file = new File("Time.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }

}
