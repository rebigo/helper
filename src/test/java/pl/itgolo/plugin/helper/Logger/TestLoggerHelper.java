package pl.itgolo.plugin.helper.Logger;

import org.junit.Test;
import pl.itgolo.plugin.helper.Async.AsyncHelper;
import pl.itgolo.plugin.helper.Async.Exceptions.AsyncHelperException;
import pl.itgolo.plugin.helper.Logger.Enums.Level;
import pl.itgolo.plugin.helper.Sound.Exceptions.BeepHelperException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class TestLoggerHelper {

    @Test
    public void test_add_message_to_debuger() throws AsyncHelperException {
        asyncSetLog(11);
    }

    @Test
    public void test_beep_log_with_debug_level() throws AsyncHelperException {
        LoggerHelper.setLog(TestLoggerHelper.class, Level.DEBUG, "Debug message", true);
    }

    @Test
    public void test_beep_off_log_with_debug_level() throws AsyncHelperException {
        LoggerHelper.setBeepOn(true);
        LoggerHelper.setLog(TestLoggerHelper.class, Level.DEBUG, "Debug message", true);
    }

    @Test
    public void test_on_beep_log(){
        try {
            throw new BeepHelperException("Beep");
        } catch (Exception e){
            LoggerHelper.setLog(TestLoggerHelper.class, Level.ERROR, e.getMessage(), e);
        }
    }

    public static void asyncSetLog(Integer quantity) throws AsyncHelperException {
        List<Callable<Object>> callables = new ArrayList<>();
        for (int i=0 ; i<quantity ; i++){
            callables.add(()->{
                try {
                    throw new BeepHelperException("Example exception async");
                } catch (Exception e){
                    LoggerHelper.setLog(TestLoggerHelper.class, Level.ERROR, "message async", e);
                }
                return null;
            });
        }
        AsyncHelper.asyncMultiWait(callables, 10, "Thread", true,  Thread.NORM_PRIORITY);
    }
}
