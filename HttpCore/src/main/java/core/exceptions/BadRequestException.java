package core.exceptions;

/**
 *
 * @author Admin
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("Bad request");
    }

}
