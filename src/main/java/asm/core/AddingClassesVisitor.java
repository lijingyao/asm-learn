package asm.core;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by yunshen.ljy on 2015/6/13.
 */
public class AddingClassesVisitor  extends ClassVisitor {


    private int fAcc;
    private String fName;
    private String fDesc;
    private boolean isFieldPresent;
    public AddingClassesVisitor(ClassVisitor cv, int fAcc, String fName,
                           String fDesc) {
        super(Opcodes.ASM4, cv);
        this.fAcc = fAcc;
        this.fName = fName;
        this.fDesc = fDesc;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc,
                                   String signature, Object value) {
        return cv.visitField(fAcc, fName, fDesc, null, null);
    }
//    @Override
//    public void visitEnd() {
//        if (!isFieldPresent) {
//            FieldVisitor fv = cv.visitField(fAcc, fName, fDesc, null, null);
//            if (fv != null) {
//                fv.visitEnd();
//            }
//        }
//        cv.visitEnd();
//    }
}

