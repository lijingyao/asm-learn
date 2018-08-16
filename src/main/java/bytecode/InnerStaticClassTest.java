package bytecode;

/**
 * Created by lijingyao on 16/1/25 21:10.
 */
public class InnerStaticClassTest {

    public static void main(String[] args) {
        System.out.println(new InnerStaticClassTest.MyInnerClass(" hello ").getInnerString());
        System.out.println(new InnerStaticClassTest.MyInnerClass(" hello2 ").getInnerString());
        System.out.print(new InnerStaticClassTest.MyInnerClass(" hello ").equals(new InnerStaticClassTest.MyInnerClass(" hello ")));
        new InnerStaticClassTest(" hello ");
    }

    private static String myPropString = "myPropString";

    private String changeString;

    public InnerStaticClassTest(String changeString) {
        this.changeString = changeString;
        myPropString = " newPropString ";
        System.out.print(new NonStaticClass(" nonStaticString ").getInnerString());
    }

    class NonStaticClass {
        private String nonStaticString;

        public NonStaticClass(String nonStaticString) {
            this.nonStaticString = nonStaticString;
        }

        public String getInnerString() {
            return nonStaticString + changeString + myPropString;
        }

    }

    static class MyInnerClass {
        private String innerString;

        public MyInnerClass(String innerString) {
            this.innerString = innerString;
        }


        public String getInnerString() {
            return innerString + InnerStaticClassTest.myPropString;
        }
    }
}
