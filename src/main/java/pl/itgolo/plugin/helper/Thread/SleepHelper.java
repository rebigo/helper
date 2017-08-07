package pl.itgolo.plugin.helper.Thread;

import pl.itgolo.plugin.helper.Logger.Enums.Level;
import pl.itgolo.plugin.helper.Logger.LoggerHelper;

/**
 * Created by ITGolo on 03.03.2017.
 */
public class SleepHelper {

    /**
     * Sleep thread
     * @param milliseconds milliseconds
     */
    public static void sleep(Integer milliseconds){
        try {
            Thread.currentThread().sleep(milliseconds);
        } catch (Exception e) {
            LoggerHelper.setLog(SleepHelper.class, Level.ERROR, String.format("Error sleep in thread ID: %1$s.", Thread.currentThread().getId()), e);
        }
    }
}
