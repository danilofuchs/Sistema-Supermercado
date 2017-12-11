package exceptions;

public class NegativeStockException extends Exception {
    public NegativeStockException() {}
    
    public NegativeStockException(String message)
    {
         super(message);
    }
}
