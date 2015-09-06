package asm.core;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yunshen.ljy on 2015/6/13.
 */
public class TraceClassVisitorTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("asm.core.Task");
        ClassWriter cw = new ClassWriter(0);
        TraceClassVisitor cv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        cr.accept(cv, 0);
    }
}
