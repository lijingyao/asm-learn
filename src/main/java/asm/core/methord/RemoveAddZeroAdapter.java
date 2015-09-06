package asm.core.methord;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by yunshen.ljy on 2015/7/1.
 */
public class RemoveAddZeroAdapter extends MethodVisitor {
    private static int SEEN_ICONST_0 = 1;
    protected final static int SEEN_NOTHING = 0;
    protected int state;
    public RemoveAddZeroAdapter(MethodVisitor mv) {
        super(Opcodes.ASM4, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        // 是否检测到前一个指令是ICONST_0
        if (state == SEEN_ICONST_0) {
            // 并且当前指令时iadd
            if (opcode == Opcodes.IADD) {
                // 重新初始化指令状态
                state = SEEN_NOTHING;
                // 移除指令序列
                return;
            }
        }
        visitInsn();
        // 如果当前指令是ICONST_0 记录指令状态，并且直接返回(移除)
        if (opcode == Opcodes.ICONST_0) {
            state = SEEN_ICONST_0;
            return;
        }
        // 继续访问下一条指令
        mv.visitInsn(opcode);
    }

    protected void visitInsn() {
        // 如果最后访问的是SEEN_ICONST_0指令，那么还原指令（因为刚才被移除了）
        if (state == SEEN_ICONST_0) {
            mv.visitInsn(Opcodes.ICONST_0);
        }
        state = SEEN_NOTHING;
    }

}
