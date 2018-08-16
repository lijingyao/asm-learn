package lijingyao.asm.tree.metadata;

import com.google.common.eventbus.Subscribe;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lijingyao on 15/12/3 21:09.
 */
public class AnnotationTransformer {

    public void transform(ClassNode cn) {

        for (MethodNode mn : (List<MethodNode>) cn.methods) {
            if ("<init>".equals(mn.name) || "<clinit>".equals(mn.name)) {
                continue;
            }

            List<AnnotationNode> insns = mn.visibleAnnotations;
            List<AnnotationNode> insnsnew = new ArrayList<>();
            if (null == insns || insns.size() == 0) {
                continue;
            }
            Iterator<AnnotationNode> nodes = insns.iterator();
            while (nodes.hasNext()) {
                AnnotationNode node = nodes.next();
                insnsnew.add(node);
                if (node.desc.equals(getInternalName(ServiceSubscriber.class.getName()))) {
                    List<String[]> types = (List<String[]>) node.values.get(1);
                    types.stream().forEach(t -> {
                        if (t[1].equals(EventType.LOCAL.toString())) {
                            insnsnew.add(new AnnotationNode(Opcodes.ASM5, getInternalName(Subscribe.class.getName())));
                        }
                    });
                }
            }
            mn.visibleAnnotations = insnsnew;
        }
    }

    private String getInternalName(String className) {
        return "L" + className.replace(".", "/") + ";";
    }
}
