package lijingyao.asm.core;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by yunshen.ljy on 2015/6/10.
 */
public class ChangeAccessAdapter extends ClassVisitor {

    public ChangeAccessAdapter(ClassVisitor cv) {
        super(Opcodes.ASM4, cv);
    }
    @Override
    public void visit(int version, int access, String name,
                      String signature, String superName, String[] interfaces) {
        cv.visit(version, Opcodes.ACC_PUBLIC , name, signature, superName, interfaces);
    }

}