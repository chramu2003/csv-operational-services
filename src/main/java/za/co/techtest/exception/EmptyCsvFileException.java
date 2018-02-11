package za.co.techtest.exception;

/**
 * Created by rchennupati on 1/26/18.
 */
public class EmptyCsvFileException extends Exception {

    public EmptyCsvFileException () {

    }

    public EmptyCsvFileException (String message) {
        super (message);
    }

    public EmptyCsvFileException (Throwable cause) {
        super (cause);
    }

    public EmptyCsvFileException (String message, Throwable cause) {
        super (message, cause);
    }
}
