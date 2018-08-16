package lijingyao.asm.core.metadata;

import org.objectweb.asm.signature.SignatureReader;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunshen.ljy on 2015/7/6.
 */
public class RenameTest {

    public static void main(String[] args) {
        String s = "Ljava/util/HashMap<TK;TV;>.HashIterator<TV;>;";
        Map<String, String> renaming = new HashMap<String, String>();
        renaming.put("java/util/HashMap", "A");
        renaming.put("java/util/HashMap.HashIterator", "B");
        SignatureWriter sw = new SignatureWriter();
        SignatureVisitor sa = new RenameSignatureAdapter(sw, renaming);
        SignatureReader sr = new SignatureReader(s);
        sr.acceptType(sa);
        System.out.println(sw.toString());
    }
}
