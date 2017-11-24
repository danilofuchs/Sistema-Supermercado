/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Brendow Avanzi
 */
public class ProductNotUniqueException extends Exception {
    public ProductNotUniqueException() {}
    
    public ProductNotUniqueException(String message)
    {
         super(message);
    }
}
