package pl.itgolo.plugin.helper.Logger;

import org.junit.Test;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class TestConsoleHelper {

    @Test
    public void test_console_helper(){
        System.out.println(ConsoleHelper.setColorYellow("This text has a green background but default text!"));
    }
}
