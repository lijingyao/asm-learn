package lijingyao.asm.core;

import org.objectweb.asm.ClassReader;

import java.io.IOException;

/**
 * Created by yunshen.ljy on 2015/6/8.
 */
public class ParseClasses {

    public static void main(String[] args) {
        try {
            ClassReader cr = new ClassReader("lijingyao.asm.core.Task");
            ClassPrintVisitor cp = new ClassPrintVisitor();
            cr.accept(cp, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

//cr.accept(cw, 0);
//            byte[] b = cw.toByteArray();
//            File file = new File("NewTask.class");
//            FileOutputStream fout = new FileOutputStream(file);
//            fout.write(b);
//            fout.close();