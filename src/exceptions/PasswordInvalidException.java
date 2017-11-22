package exceptions;

public class PasswordInvalidException extends Exception {
    public PasswordInvalidException() {}
    
    public PasswordInvalidException(String message)
    {
         super(message);
    }
}
