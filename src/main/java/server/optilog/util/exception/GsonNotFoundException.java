package server.optilog.util.exception;


public class GsonNotFoundException extends OptilogException {
    public GsonNotFoundException() {
    }
    
    public GsonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public GsonNotFoundException(String message) {
        super(message);
    }
    
    public GsonNotFoundException(Throwable cause) {
        super(cause);
    }
}

