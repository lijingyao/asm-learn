package eight;

import java.util.Collections;

/**
 * Created by lijingyao on 15/11/4 17:29.
 */
public class Validate {
    static boolean validate(Object... t) {
        for (Object t1 : t) {
            if (null == t1) {
                return false;
            }
            Class c = t1.getClass();
            if (t1 instanceof  Integer) {
                if ((Integer) t1 <= 0)
                    return false;
            }
            if (t1 instanceof Long) {
                if ((Long) t1 <= 0)
                    return false;
            }
            if(t1 instanceof Collections){
//                if(null == t1 || t1)
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Long userId = 9l;
        Integer offset = 0;
        System.out.print(validate(userId, offset));
    }
}
