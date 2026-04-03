package com.rays.exception;

/**
 * Custom exception class for duplicate record errors.
 * 
 * This exception is thrown when an attempt is made to
 * create or insert a record that already exists in the
 * database (violating unique constraints).
 * 
 * <p>
 * It extends RuntimeException, making it an unchecked
 * exception.
 * </p>
 * 
 * @author 
 */
public class DuplicateRecordException extends RuntimeException {

    /**
     * Constructs a new DuplicateRecordException with the specified message.
     * 
     * @param msg the detail message explaining the exception
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }

}