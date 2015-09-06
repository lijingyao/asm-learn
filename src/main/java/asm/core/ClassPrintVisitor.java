package asm.core;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

/**
 * Created by yunshen.ljy on 2015/6/8.
 */
public class ClassPrintVisitor extends ClassVisitor {

    public ClassPrintVisitor(ClassVisitor cv) {
        super(Opcodes.ASM4, cv);
    }

    public ClassPrintVisitor() {
        super(Opcodes.ASM4);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (name.startsWith("is")) {
            System.out.println(" field name: " + name + desc);

        }
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.startsWith("is")) {
//            System.out.println(" start with is method: " + name + desc);
        }
        return new MethodNode(Opcodes.ASM5, access, name, desc, signature, exceptions)
        {
            @Override public void visitEnd() {
                accept(cv);
            }
        };
    }

    public void visitEnd() {
        System.out.println("}");
    }
}
