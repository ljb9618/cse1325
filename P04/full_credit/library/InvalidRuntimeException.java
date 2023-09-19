package library;
/** An error in the runtime for videos. */

public class InvalidRuntimeException extends java.lang.ArithmeticException {

    public InvalidRuntimeException() {

        super();
    }

    public InvalidRuntimeException(String s) { super(s); }

    public InvalidRuntimeException(String title, long runtime) {

        String s = "\"" + title + "\"" + " invalid runtime " + runtime;
        throw new IllegalArgumentException(s);
    }
}
