package nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by yunshen.ljy on 2015/7/21.
 */
public class Test {
    public static String getString(ByteBuffer buffer)
    {
        Charset charset = null;
        CharsetDecoder decoder = null;
        CharBuffer charBuffer = null;
        try
        {
            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            // charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
            return charBuffer.toString();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "error";
        }
    }
    public static void main(String args[]) throws UnsupportedEncodingException {
        ByteBuffer b=ByteBuffer.allocate(4);
        b.putChar('c');
        b.putChar('d');
        b.position(0);
        String result=getString(b);

        System.out.println("result");
        System.out.println(result);

    }
}

