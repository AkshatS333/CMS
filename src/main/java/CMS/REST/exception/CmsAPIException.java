package CMS.REST.exception;

import org.springframework.http.HttpStatus;

public class CmsAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public CmsAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public CmsAPIException(String message, HttpStatus status, String message2) {
        super(message);
        this.status = status;
        message = message2;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }

    

    

}
