/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author DAELN
 */
public class NegativeStockException extends Exception {
    public NegativeStockException() {}
    
    public NegativeStockException(String message)
    {
         super(message);
    }
}
