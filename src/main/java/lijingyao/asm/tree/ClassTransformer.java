package lijingyao.asm.tree;

import org.objectweb.asm.tree.ClassNode;

/**
 * Created by yunshen.ljy on 2015/7/12.
 */
public class ClassTransformer {
    protected ClassTransformer ct;

    public ClassTransformer() {

    }

    public ClassTransformer(ClassTransformer ct) {
        this.ct = ct;
    }

    public void transform(ClassNode cn) {
        if (ct != null) {
            ct.transform(cn);
        }
    }
}
