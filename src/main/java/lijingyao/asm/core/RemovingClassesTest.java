package lijingyao.asm.core;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RemovingClassesTest {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("lijingyao.asm.core.Task");
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new RemovingClassesVisitor(cw);
        cr.accept(cv, 0);
        byte[] toByte = cw.toByteArray();// byt ��toByte��ʵ����ͬ������
        // �����class�ļ�
        File file = new File("Task.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(toByte);
        fout.close();
    }
}
