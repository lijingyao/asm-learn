package asm.core.methord;

import org.objectweb.asm.MethodVisitor;

/**
 * Created by yunshen.ljy on 2015/7/1.
 */
public abstract class PatternMethodAdapter extends MethodVisitor {
    protected final static int SEEN_NOTHING = 0;
    protected int state;
    public PatternMethodAdapter(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        visitInsn();
        mv.visitInsn(opcode);
    }
    @Override
    public void visitIntInsn(int opcode, int operand) {
        visitInsn();
        mv.visitIntInsn(opcode, operand);
    }
    protected abstract void visitInsn();
}
