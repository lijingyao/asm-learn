package asm.tree.method;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by yunshen.ljy on 2015/8/26.
 */
public class OptimizeJumpTransformerTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("bytecode.Coffee");
        ClassNode cn = new ClassNode();
        cr.accept(cn, 0);
        OptimizeJumpTransformer at = new OptimizeJumpTransformer();
        List<MethodNode> methodNodes = cn.methods;
        for(MethodNode mn :methodNodes){
            if(mn.name.equals("addEspresso")){
                at.transform(mn);
            }
        }

        ClassWriter cw = new ClassWriter(0);
        cn.accept(cw);
        byte[] toByte = cw.toByteArray();
        // 输出到class文件
        File file = new File("TimeJump.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }
}
