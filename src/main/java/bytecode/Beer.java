package bytecode;

/**
 * Created by yunshen.ljy on 2015/7/27.
 */
public class Beer extends Wine{

    /**
     * 重写父类方法，实现多态
     */
    public String drink(int ml){
        return "drink " + ml +"ml beer";
    }
}