package lijingyao.asm.tree.method;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * tree api method �����ֽ��� Created by yunshen.ljy on 2015/7/20.
 */
public class GenerateClasses {

    public static void main(String[] args) throws IOException {
        ClassNode classNode = new ClassNode();
        classNode.version = Opcodes.V1_8;
        classNode.access = Opcodes.ACC_PUBLIC;
        classNode.name = "bytecode/TreeMethodGenClass";
        classNode.superName = "java/lang/Object";
        classNode.fields.add(new FieldNode(Opcodes.ACC_PRIVATE, "espresso", "I", null, null));
        // public void addEspresso(int espresso) ��������
        MethodNode mn = new MethodNode(Opcodes.ACC_PUBLIC, "addEspresso", "(I)V", null, null);
        classNode.methods.add(mn);
        InsnList il = mn.instructions;
        il.add(new VarInsnNode(Opcodes.ILOAD, 1));
        il.add(new InsnNode(Opcodes.ICONST_1));
        LabelNode label = new LabelNode();
        // if (espresso > 0) ��תͨ��LabelNode�����ת��ַ
        il.add(new JumpInsnNode(Opcodes.IF_ICMPLE, label));
        il.add(new VarInsnNode(Opcodes.ALOAD, 0));
        il.add(new VarInsnNode(Opcodes.ILOAD, 1));
        // this.espresso = var1;
        il.add(new FieldInsnNode(Opcodes.PUTFIELD, "bytecode/TreeMethodGenClass", "espresso", "I"));
        LabelNode end = new LabelNode();
        il.add(new JumpInsnNode(Opcodes.GOTO, end));
        // label ���������һ��ָ���ַ
        il.add(label);
        // java7֮���stack map frame �Ĵ���
        il.add(new FrameNode(Opcodes.F_SAME, 0, null, 0, null));
        // throw new IllegalArgumentException();
        il.add(new TypeInsnNode(Opcodes.NEW, "java/lang/IllegalArgumentException"));
        il.add(new InsnNode(Opcodes.DUP));
        il.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "()V", false));
        il.add(new InsnNode(Opcodes.ATHROW));
        il.add(end);
        // stack map �ĵڶ���ƫ�Ƽ�¼
        il.add(new FrameNode(Opcodes.F_SAME, 0, null, 0, null));
        il.add(new InsnNode(Opcodes.RETURN));
        // �ֲ�������Ͳ�����ջ��С�Ĵ���
        mn.maxStack = 2;
        mn.maxLocals = 2;
        mn.visitEnd();
        classNode.visitEnd();
        // ��ӡ�鿴class�����ɽ��
        ClassWriter cw = new ClassWriter(Opcodes.ASM5);
        classNode.accept(cw);
        byte[] byteArray = cw.toByteArray();
        // NIO ������ļ�
        RandomAccessFile file = new RandomAccessFile ("TreeMethodGenClass.class","rw");
        FileChannel fc = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(byteArray.length);
        buf.clear();
        buf.put(byteArray);

        buf.flip();

        while(buf.hasRemaining()) {
            // ��buffer��channel д����
            fc.write(buf);
        }
        fc.close();

    }
}
