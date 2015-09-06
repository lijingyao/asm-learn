package asm.tree;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 添加和移除class 元素
 * Created by yunshen.ljy on 2015/7/13.
 */
public class TestRemoveAndAddTransformer {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("asm.core.Task");
        ClassNode cn = new ClassNode();
        cr.accept(cn,0);
        RemoveMethodTransformer rt = new RemoveMethodTransformer("isNeedRemove","V");
        rt.transform(cn);
        AddFieldTransformer at= new AddFieldTransformer(Opcodes.ACC_PRIVATE,"addedField","I");
        at.transform(cn);
        ClassWriter cw = new ClassWriter(0);
        cn.accept(cw);
        byte[] toByte = cw.toByteArray();// byt 和toByte其实是相同的数组
        // 输出到class文件

        File file = new File("Task.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }
}
