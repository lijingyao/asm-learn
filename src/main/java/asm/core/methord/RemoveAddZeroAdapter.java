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
        // �Ƿ��⵽ǰһ��ָ����ICONST_0
        if (state == SEEN_ICONST_0) {
            // ���ҵ�ǰָ��ʱiadd
            if (opcode == Opcodes.IADD) {
                // ���³�ʼ��ָ��״̬
                state = SEEN_NOTHING;
                // �Ƴ�ָ������
                return;
            }
        }
        visitInsn();
        // �����ǰָ����ICONST_0 ��¼ָ��״̬������ֱ�ӷ���(�Ƴ�)
        if (opcode == Opcodes.ICONST_0) {
            state = SEEN_ICONST_0;
            return;
        }
        // ����������һ��ָ��
        mv.visitInsn(opcode);
    }

    protected void visitInsn() {
        // ��������ʵ���SEEN_ICONST_0ָ���ô��ԭָ���Ϊ�ղű��Ƴ��ˣ�
        if (state == SEEN_ICONST_0) {
            mv.visitInsn(Opcodes.ICONST_0);
        }
        state = SEEN_NOTHING;
    }

}
