package eight;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 编码解码，url、字符串、mime等
 * Created by yunshen.ljy on 2015/7/28.
 */
public class Base64s {
//     （Base64.getUrlEncoder() / Base64.getUrlDecoder(), Base64.getMimeEncoder()
//      Base64.getMimeDecoder()）。

    public static void main(String[] args) {
        final String text = "さよならにさよなら";
//        Base64.ge

        final String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
