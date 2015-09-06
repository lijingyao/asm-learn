package asm.tree.method;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.Iterator;

/**
 * ��GOTO label �滻��labelʵ����ת����ָ��-RETURN
 * Created by yunshen.ljy on 2015/8/14.
 */
public class OptimizeJumpTransformer {

    public void transform(MethodNode mn) {
        InsnList insns = mn.instructions;
        Iterator<AbstractInsnNode> i = insns.iterator();
        while (i.hasNext()) {
            AbstractInsnNode in = i.next();
            if (in instanceof JumpInsnNode) {
                // ��ʼ��label
                LabelNode label = ((JumpInsnNode) in).label;
                AbstractInsnNode target;
                // ѭ�����ã���goto XX �е�XX��ת��ַ��¼��label������
                while (true) {
                    target = label;   // ��ת���˵�FrameNode ��LabelNode
                    while (target != null && target.getOpcode() < 0) {
                        target = target.getNext();
                    }
                    if (target != null && target.getOpcode() == Opcodes.GOTO) {
                        label = ((JumpInsnNode) target).label;
                    } else {
                        break;
                    }
                }
                // �����滻label��ֵ(ʵ����ת��ַ)
                ((JumpInsnNode) in).label = label;
                // ���ָ����goto ,�����µ���ת��Ŀ��ָ����ARETURN ָ���ô�ͽ���ǰ��ָ���滻�����returnָ���һ��clone����
                if (in.getOpcode() == Opcodes.GOTO && target != null) {
                    int op = target.getOpcode();
                    if ((op >= Opcodes.IRETURN && op <= Opcodes.RETURN) || op == Opcodes.ATHROW) {
                        // replace ��in�� with clone of ��target��
                        insns.set(in, target.clone(null));
                    }
                }
            }
        }
    }
}
