package za.co.techtest.exception;

/**
 * Created by rchennupati on 1/26/18.
 */
public class ServiceException extends Exception {

    public ServiceException () {
        super();
    }

    public ServiceException (String message) {
        super (message);
    }

    public ServiceException (Throwable cause) {
        super (cause);
    }

    public ServiceException (String message, Throwable cause) {
        super (message, cause);
    }
}
