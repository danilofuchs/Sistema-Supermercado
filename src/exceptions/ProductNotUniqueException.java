package exceptions;

public class ProductNotUniqueException extends Exception {
    public ProductNotUniqueException() {}
    
    public ProductNotUniqueException(String message)
    {
         super(message);
    }
}
