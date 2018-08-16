package lijingyao.asm.tree.method;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import bytecode.Coffee;

/**
 * Created by yunshen.ljy on 2015/8/12.
 */
public class AddTimerTransformTest {


    public static void main(String[] args) throws IOException {

        Coffee test = new Coffee();
        Class<?> clazz = test.getClass();
        String  name = clazz.getName();
        ClassReader cr = new ClassReader(name);
        ClassNode cn = new ClassNode();
        cr.accept(cn, 0);
        AddTimerTransformer at = new AddTimerTransformer();
        at.transform(cn);
        ClassWriter cw = new ClassWriter(0);
        cn.accept(cw);
        byte[] toByte = cw.toByteArray();
        // 输出到class文件
        File file = new File("TimeAdd.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }
}
