package lijingyao.asm.core.methord;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * methods api 动态生成字节码 Created by yunshen.ljy on 2015/6/24.
 */
public class GenerateClasses {

    public static void main(String[] args) throws IOException {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "bytecode/MethodGenClass", null, "java/lang/Object", null);
        cw.visitField(Opcodes.ACC_PRIVATE, "espresso", "I", null, null).visitEnd();
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "addEspresso", "(I)V", null, null);

        mv.visitCode();
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        Label label = new Label();
        mv.visitJumpInsn(Opcodes.IFLT, label);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(Opcodes.PUTFIELD, "bytecode/MethodGenClass", "espresso", "I");
        Label end = new Label();
        mv.visitJumpInsn(Opcodes.GOTO, end);
        mv.visitLabel(label);
//        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        mv.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException");
        mv.visitInsn(Opcodes.DUP);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "()V", false);
        mv.visitInsn(Opcodes.ATHROW);
        mv.visitLabel(end);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(2, 2);
        mv.visitEnd();
        cw.visitEnd();

        byte[] b = cw.toByteArray();

        File file = new File("MethodGenClass.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(b);
        fout.close();
    }

}
