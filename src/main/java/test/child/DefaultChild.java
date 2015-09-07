package test.child;

/**
 * Created by yunshen.ljy on 2015/5/29.
 */
public class DefaultChild extends ParentFactoryImpl {

    public void getName(){
        System.out.println("DefaultChild no name");
    }

    @Override
    public void getAge() {
        System.out.println("DefaultChild 0 year");
    }
}
