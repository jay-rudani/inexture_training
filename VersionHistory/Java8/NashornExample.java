package VersionHistory.Java8;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class NashornExample {

    public static void main(String[] args) throws FileNotFoundException, ScriptException {
        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
        ee.eval(new FileReader("/home/root416/Desktop/Java/VersionHistory/Java8/hello.js"));
        ee.eval("print('Hii Nashorn')");
    }
}
