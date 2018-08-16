package lijingyao.asm.core.metadata;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by lijingyao on 15/12/3 23:49.
 */
public class AddAnnotationAdapter extends ClassVisitor {
    private String annotationDesc;
    private boolean isAnnotationPresent;

    public AddAnnotationAdapter(ClassVisitor cv, String annotationDesc) {
        super(Opcodes.ASM5, cv);
        this.annotationDesc = annotationDesc;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (visible && desc.equals(annotationDesc)) {
            isAnnotationPresent = true;
        }
        return cv.visitAnnotation(desc, visible);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        cv.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return cv.visitField(access, name, desc, signature, value);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (mv != null && !name.equals("<init>") && !"<clinit>".equals(name)) {
//            mv.visitAnnotation("Lmetadata/lijingyao.asm/tree/metadata/ServiceSubscriber;", true);
            mv = new AddAnnoMethodAdapter(mv, annotationDesc);
        }
        return mv;

    }

    @Override
    public void visitEnd() {
        cv.visitEnd();
    }

}
