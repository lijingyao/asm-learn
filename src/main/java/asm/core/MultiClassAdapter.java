package asm.core;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;


public class MultiClassAdapter extends ClassVisitor {
    protected ClassVisitor[] cvs;
    public MultiClassAdapter(ClassVisitor[] cvs) {
        super(Opcodes.ASM4);
        this.cvs = cvs;
    }
    @Override public void visit(int version, int access, String name,
                                String signature, String superName, String[] interfaces) {
        for (ClassVisitor cv : cvs) {
            cv.visit(version, access, name, signature, superName, interfaces);
        }
    }


//    @Override
//    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//        MethodVisitor m = null;
//        for (ClassVisitor cv : cvs) {
//           m = cv.visitMethod(access, name, desc, signature, exceptions);
//        }
//        return m;
//    }
}