package exceptions;

public class NameNotUniqueException extends Exception {
    public NameNotUniqueException() {}
    
    public NameNotUniqueException(String message)
    {
         super(message);
    }
}
