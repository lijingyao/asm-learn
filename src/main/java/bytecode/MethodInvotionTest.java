package bytecode;

/**
 * Created by yunshen.ljy on 2015/7/26.
 */
public class MethodInvotionTest {

    public String drink(int ml) {

        Wine wines = new Beer();
        return wines.drink(ml);

    }


}
