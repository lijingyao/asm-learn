package lijingyao.asm.tree.method;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yunshen.ljy on 2015/7/30.
 */
public class AddTimerTransformer {

    public void transform(ClassNode cn) {
        for (MethodNode mn : (List<MethodNode>) cn.methods) {
            if ("<init>".equals(mn.name) || "<clinit>".equals(mn.name)) {
                continue;
            }

            //            RemoveGetFieldPutFieldTransformer re = new RemoveGetFieldPutFieldTransformer();
            //            re.transform(mn);

            InsnList insns = mn.instructions;
            if (insns.size() == 0) {
                continue;
            }
            Iterator<AbstractInsnNode> j = insns.iterator();
            while (j.hasNext()) {
                AbstractInsnNode in = j.next();
                int op = in.getOpcode();
                if ((op >= Opcodes.IRETURN && op <= Opcodes.RETURN) || op == Opcodes.ATHROW) {
                    InsnList il = new InsnList();
                    il.add(new FieldInsnNode(Opcodes.GETSTATIC, cn.name, "timer", "J"));
                    il.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false));
                    il.add(new InsnNode(Opcodes.LADD));
                    il.add(new FieldInsnNode(Opcodes.PUTSTATIC, cn.name, "timer", "J"));
                    insns.insert(in.getPrevious(), il);
                }
            }
            InsnList il = new InsnList();
            il.add(new FieldInsnNode(Opcodes.GETSTATIC, cn.name, "timer", "J"));
            il.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false));
            il.add(new InsnNode(Opcodes.LSUB));
            il.add(new FieldInsnNode(Opcodes.PUTSTATIC, cn.name, "timer", "J"));
            insns.insert(il);
            mn.maxStack += 4;
        }
        int acc = Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC;
        cn.fields.add(new FieldNode(acc, "timer", "J", null, null));
    }
}
