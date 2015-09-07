import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by yunshen.ljy on 2015/5/22.
 */
public class TestMain extends ClassVisitor {
    public TestMain(ClassVisitor cv) {
        super(0);
    }

    public FieldVisitor visitField(final int access, final String name, final String desc, final String signature,
            final Object value) {
        int privateAccess = Opcodes.ACC_PRIVATE;
        return cv.visitField(privateAccess, name, desc, signature, value);
    }
}