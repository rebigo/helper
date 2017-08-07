package pl.itgolo.plugin.helper.Async.Exceptions;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class AsyncHelperException extends Exception {

    /**
     * Constructor
     */
    public AsyncHelperException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public AsyncHelperException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public AsyncHelperException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public AsyncHelperException(String message, Throwable cause) {
        super (message, cause);
    }
}
