package kp.cmsc.common.exception;

import org.springframework.http.HttpStatus;

public class KnwpException extends RuntimeException{
    private String message;
    private HttpStatus status;
    private static final long serialVersionUID = 6617079477661783059L;


    public KnwpException() {
        super();
    }

    public KnwpException(String message) {
        super(message);
    }

    public KnwpException(String message, Throwable cause) {
        super(message, cause);
    }

    public KnwpException(Throwable cause) {
        super(cause);
    }


    public KnwpException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
