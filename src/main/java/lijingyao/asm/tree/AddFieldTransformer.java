package lijingyao.asm.tree;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

/**
 * Created by yunshen.ljy on 2015/7/12.
 */
public class AddFieldTransformer   {
    private int fieldAccess;
    private String fieldName;
    private String fieldDesc;

    public AddFieldTransformer(int fieldAccess, String fieldName, String fieldDesc) {
        this.fieldAccess = fieldAccess;
        this.fieldName = fieldName;
        this.fieldDesc = fieldDesc;
    }

    public void transform(ClassNode cn) {
        boolean isPresent = false;
        for (Object fn : cn.fields) {
            FieldNode ff = (FieldNode) fn;
            if (fieldName.equals(ff.name)) {
                isPresent = true;
                break;
            }
        }
        if (!isPresent) {
            cn.fields.add(new FieldNode(fieldAccess, fieldName, fieldDesc, null, null));
        }
    }

}
