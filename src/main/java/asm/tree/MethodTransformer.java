package asm.tree;

import org.objectweb.asm.tree.MethodNode;

/**
 * Created by yunshen.ljy on 2015/7/30.
 */
public class MethodTransformer {
    protected MethodTransformer mt;

    public MethodTransformer() {

    }

    public MethodTransformer(MethodTransformer ct) {
        this.mt = mt;
    }

    public void transform(MethodNode cn) {
        if (mt != null) {
            mt.transform(cn);
        }
    }
}
