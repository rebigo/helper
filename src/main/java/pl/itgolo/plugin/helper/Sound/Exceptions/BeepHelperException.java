package pl.itgolo.plugin.helper.Sound.Exceptions;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class BeepHelperException extends Exception {

    /**
     * Constructor
     */
    public BeepHelperException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public BeepHelperException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public BeepHelperException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public BeepHelperException(String message, Throwable cause) {
        super (message, cause);
    }
}
