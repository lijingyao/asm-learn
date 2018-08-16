package lijingyao.asm.core.metadata;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import lijingyao.asm.tree.metadata.TestAnno;

/**
 * Created by lijingyao on 15/12/3 23:51.
 */
public class AddAnnoTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader(TestAnno.class.getName());
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new AddAnnotationAdapter(cw, "Lmetadata/com/google/common/eventbus/Subscribe;");

        cr.accept(cv, 0);
        byte[] toByte = cw.toByteArray();
        File file = new File("AddAnnoCore.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }
}
