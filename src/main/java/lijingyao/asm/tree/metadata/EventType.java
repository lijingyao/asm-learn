package lijingyao.asm.tree.metadata;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lijingyao on 15/12/3 10:58.
 */
public enum EventType {

    LOCAL, ONS;

    public static List<String> getTypeValue() {
        return Arrays.asList(LOCAL.name(), ONS.name());
    }
}
