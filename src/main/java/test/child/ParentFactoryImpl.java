package test.child;

import test.parent.ParentFactory;

/**
 * Created by yunshen.ljy on 2015/5/29.
 */
public abstract class ParentFactoryImpl implements ParentFactory {

    public void getName(){
        System.out.println("ParentFactory getName");
    }


}
