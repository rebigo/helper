package pl.itgolo.plugin.helper.Logger.Classes;

import pl.itgolo.plugin.helper.Logger.Enums.Level;

import java.util.Calendar;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class Log {

    /* @var class name */
    private Class className;

    /* @var level */
    private Level level;

    /* @var message */
    private String message;

    /* @var cause */
    private Throwable cause;

    /* @var beep */
    private Boolean beep;

    /* @var created at */
    private Calendar createdAt;

    /**
     * Constructor
     * @param className class name
     * @param level level
     * @param message message
     */
    public Log(Class className, Level level, String message) {
        this.className = className;
        this.level = level;
        this.message = message;
        this.createdAt = Calendar.getInstance();
    }

    /**
     * Constructor
     * @param className class name
     * @param level level
     * @param message message
     *                @param beep beep
     */
    public Log(Class className, Level level, String message, Boolean beep) {
        this.className = className;
        this.level = level;
        this.message = message;
        this.beep = beep;
        this.createdAt = Calendar.getInstance();
    }

    /**
     * Constructor
     * @param className class name
     * @param level level
     * @param message message
     * @param cause cause
     */
    public Log(Class className, Level level, String message, Throwable cause) {
        this.className = className;
        this.level = level;
        this.message = message;
        this.cause = cause;
        this.createdAt = Calendar.getInstance();
    }

    /**
     * Get class name
     * @return class name
     */
    public Class getClassName() {
        return className;
    }

    /**
     * Set class name
     * @param className class name
     */
    public void setClassName(Class className) {
        this.className = className;
    }

    /**
     * Get level
     * @return level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Set level
     * @param level level
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Get message
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set message
     * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get cause
     * @return cause
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * Set cause
     * @param cause cause
     */
    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    /**
     * Get beep
     * @return beep
     */
    public Boolean getBeep() {
        return beep;
    }

    /**
     * Set beep
     * @param beep beep
     */
    public void setBeep(Boolean beep) {
        this.beep = beep;
    }
}