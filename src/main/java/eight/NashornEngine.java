package eight;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ava与JavaScript相互调用
 * Created by yunshen.ljy on 2015/7/28.
 */
public class NashornEngine {


    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName( "JavaScript" );

        System.out.println( engine.getClass().getName() );
        System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
    }
}
