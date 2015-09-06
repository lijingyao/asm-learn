package test.child;

/**
 * Created by yunshen.ljy on 2015/5/29.
 */
public class ChildOne extends ParentFactoryImpl {

    public void getName(){
        System.out.println("ChildOne Tom");
    }

    @Override
    public void getAge() {
        System.out.println("ChildOne 1year");
    }
}
