package test;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Objects;


/**
 * Created by yunshen.ljy on 2015/7/29.
 */
public class DealString {

    private int att1;
    private long att2;
    private String att3;

    public static void main(String[] args) {

    }

    /**
     * java7 ¿‡ø‚£¨nullª·∑µªÿ°∞null°±
     * 
     * @return
     */
    public String toString1() {
        return "MyObject{" + "att1='" + Objects.toString(att1) + "'" + ", att2='" + Objects.toString(att2) + "'"
                + ", att3='" + Objects.toString(att3) + "'" + "} " + super.toString();
    }

    public String toString2() {
        final StringBuilder sb = new StringBuilder("MyObject{");
        sb.append("att1='").append(att1).append("'");
        sb.append(", att2='").append(att2).append("'");
        sb.append(", att3='").append(att3).append("'");
        sb.append(super.toString());
        return sb.toString();
    }

// guava   public String toString() {
//        return Objects.toStringHelper(this)
//                .add("att1", att1)
//                .add("att2", att2)
//                .add("att3", att3)
//                .add("super", super.toString()).toString();
//    }

    public String toString3() {
        return new ToStringBuilder(this).append("att1", att1).append("att2", att2).append("att3", att3)
                .append("super", super.toString()).toString();
    }

    public String toString4() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String toString5() {
        return ReflectionToStringBuilder.toString(this);
    }

}
