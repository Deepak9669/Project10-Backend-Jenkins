package com.rays.exception;

/**
 * Custom exception class for database-related errors.
 * 
 * This exception is used to handle and represent issues
 * that occur during database operations. It extends
 * RuntimeException, so it is an unchecked exception.
 * 
 * <p>
 * This allows it to be thrown without being explicitly
 * declared in method signatures.
 * </p>
 * 
 * @author 
 */
public class DatabaseException extends RuntimeException {

    /**
     * Constructs a new DatabaseException with the specified message.
     * 
     * @param msg the detail message explaining the exception
     */
    public DatabaseException(String msg) {
        super(msg);
    }
}