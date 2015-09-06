package asm.tree.method;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.Iterator;

/**
 * 将GOTO label 替换成label实际跳转到的指令-RETURN
 * Created by yunshen.ljy on 2015/8/14.
 */
public class OptimizeJumpTransformer {

    public void transform(MethodNode mn) {
        InsnList insns = mn.instructions;
        Iterator<AbstractInsnNode> i = insns.iterator();
        while (i.hasNext()) {
            AbstractInsnNode in = i.next();
            if (in instanceof JumpInsnNode) {
                // 初始化label
                LabelNode label = ((JumpInsnNode) in).label;
                AbstractInsnNode target;
                // 循环调用，将goto XX 中的XX跳转地址记录在label变量中
                while (true) {
                    target = label;   // 跳转过滤掉FrameNode 和LabelNode
                    while (target != null && target.getOpcode() < 0) {
                        target = target.getNext();
                    }
                    if (target != null && target.getOpcode() == Opcodes.GOTO) {
                        label = ((JumpInsnNode) target).label;
                    } else {
                        break;
                    }
                }
                // 更新替换label的值(实际跳转地址)
                ((JumpInsnNode) in).label = label;
                // 如果指令是goto ,并且新的跳转的目标指令是ARETURN 指令，那么就将当前的指令替换成这个return指令的一个clone对象
                if (in.getOpcode() == Opcodes.GOTO && target != null) {
                    int op = target.getOpcode();
                    if ((op >= Opcodes.IRETURN && op <= Opcodes.RETURN) || op == Opcodes.ATHROW) {
                        // replace ’in’ with clone of ’target’
                        insns.set(in, target.clone(null));
                    }
                }
            }
        }
    }
}
