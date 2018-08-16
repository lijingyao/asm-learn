package lijingyao.asm.tree;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 * Created by yunshen.ljy on 2015/7/14.
 */
public class MyClassAdapter extends ClassVisitor {

    private ClassVisitor next;
    public MyClassAdapter(ClassVisitor cv) {
        super(Opcodes.ASM4,new ClassNode());
        this.next = cv;
    }

    @Override
    public void visitEnd() {
        ClassNode cn = (ClassNode)cv;
        cn.accept(cv);
    }
}
