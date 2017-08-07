package pl.itgolo.plugin.helper.Logger;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import pl.itgolo.plugin.helper.Logger.Classes.Log;
import pl.itgolo.plugin.helper.Logger.Enums.Level;
import pl.itgolo.plugin.helper.Sound.BeepHelper;
import pl.itgolo.plugin.helper.Sound.Exceptions.BeepHelperException;

import java.util.Objects;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class LoggerHelper {

    /* @var log */
    private static SimpleObjectProperty<Log> log = new SimpleObjectProperty<>();

    /* @var showed console */
    private static Boolean showedConsole = false;

    /* @var beep on */
    private static Boolean beepOn = true;

    static {
        synchronized (LoggerHelper.class) {
            showConsole();
        }
    }

    /**
     * Get log property
     *
     * @return log property
     */
    public static SimpleObjectProperty<Log> logProperty() {
        return log;
    }


    /**
     * Set log
     *
     * @param className class name
     * @param level     level
     * @param message   message
     */
    public static void setLog(Class className, Level level, String message) {
        synchronized (LoggerHelper.class) {
            Log log = new Log(className, level, message);
            LoggerHelper.log.set(log);
        }
    }

    /**
     * Set log
     *
     * @param className class name
     * @param level     level
     * @param message   message
     * @param beep      beep
     */
    public static void setLog(Class className, Level level, String message, Boolean beep) {
        synchronized (LoggerHelper.class) {
            Log log = new Log(className, level, message, beep);
            LoggerHelper.log.set(log);
        }
    }

    /**
     * Set log
     *
     * @param className class name
     * @param level     level
     * @param message   message
     * @param cause     cause
     */
    public static void setLog(Class className, Level level, String message, Throwable cause) {
        synchronized (LoggerHelper.class) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                //System.err.println(stackTraceElement.toString());
            }

            Log log = new Log(className, level, message, cause);
            LoggerHelper.log.set(log);
        }
    }

    /**
     * Show logs in console
     */
    public static void showConsole() {
        if (showedConsole == true) return;
        showedConsole = true;
        LoggerHelper.log.addListener((observable, oldValue, newValue) -> {
            synchronized (LoggerHelper.class) {
                String displayLog = String.format("[%1$s]: %2$s (%3$s)", newValue.getLevel().name(), newValue.getMessage(), newValue.getClassName().getName());
                switch (newValue.getLevel()) {
                    case DEBUG:
                        displayLog = ConsoleHelper.setColorBlue(displayLog);
                        break;
                    case ERROR:
                        displayLog = ConsoleHelper.setColorRed(displayLog);
                        break;
                    case INFO:
                        displayLog = ConsoleHelper.setColorWhite(displayLog);
                        break;
                    case SUCCESS:
                        displayLog = ConsoleHelper.setColorGreen(displayLog);
                        break;
                    case WARN:
                        displayLog = ConsoleHelper.setColorYellow(displayLog);
                        break;
                    default:
                        displayLog = ConsoleHelper.setColorWhite(displayLog);
                }
                System.out.println(displayLog);
                if (Objects.nonNull(newValue.getCause())) {
                    if (beepOn)
                        beep();
                    for (String stackLine : ExceptionUtils.getStackFrames(newValue.getCause())) {
                        System.out.println(ConsoleHelper.setColorRed(stackLine));
                    }
                } else if (BooleanUtils.isTrue(newValue.getBeep())) {
                    if (beepOn)
                        beep();
                }
            }
        });
    }

    /**
     * Set beep on
     *
     * @param beepOn beep on
     */
    public static void setBeepOn(Boolean beepOn) {
        LoggerHelper.beepOn = beepOn;
    }

    /**
     * Beep
     */
    private static void beep() {
        try {
            BeepHelper.getSoundBeep07().playLoop(3);
        } catch (BeepHelperException e) {
            // this exception is not required
        }
    }
}