package asm.core;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by yunshen.ljy on 2015/6/12.
 */
public class RemovingClassesVisitor extends ClassVisitor{

    public RemovingClassesVisitor(int api) {
        super(api);
    }

    public RemovingClassesVisitor(ClassWriter cw) {
        super(Opcodes.ASM4,cw);
    }

    // 移除内部类
    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {

    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.startsWith("is")) {
            // 移除以is开头的方法名的方法
            return null;
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
