package lijingyao.asm.core.metadata;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import lijingyao.asm.tree.metadata.ServiceSubscriber;

/**
 * Created by lijingyao on 15/12/4 00:05.
 */
public class AddAnnoMethodAdapter extends MethodVisitor {

    private String annotationDesc;
    private boolean isAnnotationPresent;

    public AddAnnoMethodAdapter(MethodVisitor mv, String annotationDesc) {

        super(Opcodes.ASM5, mv);
        this.annotationDesc = annotationDesc;
    }


    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        //"L" + getInternalName(annotationClass) + ";"
        if (visible && desc.equals(getInternalName(ServiceSubscriber.class.getName()))) {
            addAnnotation();
        }

        return mv.visitAnnotation(desc, visible);
    }

    private void addAnnotation() {
        if (!isAnnotationPresent) {
//            String t = Type.getDescriptor(EventType.class);
            AnnotationVisitor av = mv.visitAnnotation(annotationDesc, true);
            if (av != null) {
                av.visitEnd();
            }

            isAnnotationPresent = true;
        }
    }

    private String getInternalName(String className) {
        return "L" + className.replace(".", "/") + ";";
    }


}
