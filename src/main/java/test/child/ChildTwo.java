package test.child;

/**
 * Created by yunshen.ljy on 2015/5/29.
 */
public class ChildTwo extends ParentFactoryImpl{

    public void getName(){
        System.out.println("ChildTwo Lily");
    }

    @Override
    public void getAge() {
        System.out.println("ChildTwo 2years");
    }
}
